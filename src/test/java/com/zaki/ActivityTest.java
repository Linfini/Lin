package com.zaki;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ActivityTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Test
    public void query() {
        BpmnModel bpmnModel = repositoryService.getBpmnModel("oneTaskProcess:1:3");
        System.out.println(bpmnModel.toString() + "23333");
    }

    @Test
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("financialReport");
    }

    @Test
    public void getTasks() {
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        for (Task task : tasks) {
            taskService.claim(task.getId(), "zaki");
        }
        System.out.println("list:" + tasks);
        System.out.println(taskService.createTaskQuery().taskAssignee("zaki").list().toString());
    }

    @Test
    public void complete() {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("zaki").list();
        tasks.forEach(e -> {
            System.out.println(e.getProcessInstanceId());
            Map<String, Object> variable = new HashMap<>();
            variable.put("comment", "申请流程太慢了");
            variable.put("grade", "2");
            taskService.complete(e.getId(), variable);
        });
    }
}

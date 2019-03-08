package other.spring;

import com.zaki.Application;
import com.zaki.test.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestAysnc {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Test
    public void testCallback() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne1();
        Future<String> task2 = task.doTaskTwo1();
        Future<String> task3 = task.doTaskThree1();
        long end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start) + "毫秒");
    }

    //这相当于每个任务都开一个线程
    @Test
    public void testCallback2() throws InterruptedException, ExecutionException {
        Future<Long> task1 = task.doTaskOne2();
        Future<Long> task2 = task.doTaskTwo2();
        Future<Long> task3 = task.doTaskThree2();
        System.out.println("总耗时:" + (task1.get() + task2.get() + task3.get()) + "毫秒");
    }
}

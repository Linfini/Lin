package other.designpattern.action.command;

import org.junit.Test;

/**
 * 命令模式
 * 没有太理解了,大概是用不同的receiver构建不同的命令,再使用调用者去调用
 * 为啥要做要走 因为你的doSomething()方法不知道mei
 * */
public class Client {

    @Test
    public void test(){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        command.execute();
        //客服端通过调用者来执行命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();
    }
}

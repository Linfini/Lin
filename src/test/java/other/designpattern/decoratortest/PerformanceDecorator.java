package other.designpattern.decoratortest;

/**
 * 性能统计装饰器
 * */
public class PerformanceDecorator implements Command {

    Command command;

    public PerformanceDecorator() {
    }

    public PerformanceDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println(System.currentTimeMillis());
        command.execute();
        System.out.println(System.currentTimeMillis());

    }
}

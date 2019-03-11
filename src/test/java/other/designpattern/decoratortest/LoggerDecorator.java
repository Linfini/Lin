package other.designpattern.decoratortest;

import org.slf4j.LoggerFactory;

/**
 * 日志装饰器
 * */
public class LoggerDecorator implements Command {
    Command command;

    public LoggerDecorator() {
    }

    public LoggerDecorator(Command command) {
        this.command = command;
    }

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public void execute() {
        logger.debug("log begin...");
        command.execute();
        logger.debug("log end...");
    }
}

package other.designpattern.action.command;

public class Invoker {
    private Command command;

    public void action() {
        this.command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

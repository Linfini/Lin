package temp;

public class Test {
    public static void main(String[] args) {
        CommandArgs<Cp> cpCommandArgs = new CommandArgs<>();
        AbstractCommandFactory<Cp> factory = new GetOrderFactory();
    }
}

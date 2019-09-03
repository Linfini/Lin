package other.designpattern.decoratortest;

public class PaymentCommand implements Command {
    @Override
    public void execute() {
        System.out.println("支付操作...");
    }
}

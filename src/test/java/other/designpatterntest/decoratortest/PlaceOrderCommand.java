package other.designpatterntest.decoratortest;


/**
 * 下订单操作
 * */
public class PlaceOrderCommand implements Command {

    @Override
    public void execute() {
        System.out.println("下订单...");
    }
}

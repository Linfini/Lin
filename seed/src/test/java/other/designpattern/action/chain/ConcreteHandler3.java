package other.designpattern.action.chain;

public class ConcreteHandler3 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return new Level(5);
    }

    @Override
    public Response response(Request request) {
        System.out.println("------由处理器3进行处理-------");
        return null;
    }
}

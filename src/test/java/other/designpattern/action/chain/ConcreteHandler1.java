package other.designpattern.action.chain;

public class ConcreteHandler1 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return new Level(1);
    }

    @Override
    public Response response(Request request) {
        System.out.println("---------请求处理器1进行处理---------");
        return null;
    }
}

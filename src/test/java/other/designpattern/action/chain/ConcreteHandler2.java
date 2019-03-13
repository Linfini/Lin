package other.designpattern.action.chain;

public class ConcreteHandler2 extends Handler {

    @Override
    protected Level getHandlerLevel() {
        return new Level(5);
    }

    @Override
    public Response response(Request request) {
        System.out.println("----请求由处理器2进行处理...");
        return null;
    }

}

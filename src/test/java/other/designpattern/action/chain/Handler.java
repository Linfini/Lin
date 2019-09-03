package other.designpattern.action.chain;

public abstract class Handler {
    private Handler nextHandler;


    public final Response handleRequest(Request request) {
        Response response = null;
        if (this.getHandlerLevel().above(request.getLevel())) {
            return this.response(request);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            } else {
                System.out.println("没有合适的处理器");
            }
        }
        return response;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract Level getHandlerLevel();

    public abstract Response response(Request request);
}

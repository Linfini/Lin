package other.designpattern.action.chain;

public class Request {
    Level level;

    public Request(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

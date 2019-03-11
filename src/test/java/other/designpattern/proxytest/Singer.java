package other.designpattern.proxytest;

public class Singer implements Command {
    private String name;

    public Singer(String name) {
        this.name = name;
    }


    //歌手的execute方法 唱歌
    @Override
    public void execute() {
        System.out.println(String.format("%s在唱歌", name));
    }
}

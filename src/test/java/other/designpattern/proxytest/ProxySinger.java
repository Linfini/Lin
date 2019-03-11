package other.designpattern.proxytest;


/**
 *
 * */
public class ProxySinger implements Command {
    private Singer singer;
    private String name;

    public ProxySinger(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("助理演唱会收门票钱...");
        if (singer == null) {
            singer = new Singer(name);
        }
        singer.execute();
    }

}

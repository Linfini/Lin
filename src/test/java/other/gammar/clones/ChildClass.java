package other.gammar.clones;

public class ChildClass implements Cloneable {
    public String name;
    public int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package other.gammar.clones;

@SuppressWarnings("WeakerAccess")
public class FatherClass implements Cloneable {
    public String name;
    public int age;
    public ChildClass child;

    @Override
    protected Object clone() {
        try {
            FatherClass fatherClass = (FatherClass) super.clone();
            fatherClass.child = (ChildClass) this.child.clone();
            return fatherClass;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

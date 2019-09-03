package other.gammar.clones;


public class Test {

    /**
     * 实现深拷贝的关键在于父类的clone方法中对父类的引用对象再次进行拷贝
     */
    @org.junit.Test
    public void deepClone() {
        FatherClass fatherA = new FatherClass();
        fatherA.name = "张三";
        fatherA.age = 30;
        fatherA.child = new ChildClass();
        fatherA.child.name = "小三";
        fatherA.child.age = 5;
        FatherClass fatherB = (FatherClass) fatherA.clone();

    }
}

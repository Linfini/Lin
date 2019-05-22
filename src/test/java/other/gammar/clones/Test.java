package other.gammar.clones;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

        log.info("fatherA hash:{}", fatherA.hashCode());
        log.info("fatherB hash:{}", fatherB.hashCode());
        log.info("fatherA child hash:{}", fatherA.child.hashCode());
        log.info("fatherB child hash:{}", fatherB.child.hashCode());
        log.info("" + (fatherA == fatherB));
        log.info("" + (fatherA.child == fatherB.child));
    }
}

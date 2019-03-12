package other.designpattern.create.prototype;

import org.junit.Test;

/**
 * 原型模式
 *
 * 1.原型模式复制对象不会调用类的构造方法.因为对象的复制是通过Object类中的clone()方法来完成的.
 * 2.Object类中的clone()方法只会拷贝对象中的8种基本数据类型,和String,对于数组,容器对象,引用对象都不会拷贝,这就是浅拷贝.如果要实现深拷贝,必须将原型模式种的数组,容器对象,引用另行拷贝.
 * */
public class Client {

    @Test
    public void test(){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i = 0;i<10;i++){
            ConcretePrototype cloneCp = (ConcretePrototype) cp.clone();
            cloneCp.show();
        }
    }
}

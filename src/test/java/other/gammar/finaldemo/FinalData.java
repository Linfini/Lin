package other.gammar.finaldemo;

import org.junit.Test;

/**
 * 1.final 的成员变量不允许修改
 * 2.final 方法不允许重写
 * 3.final类不允许继承
 */
public class FinalData {
    //成员基本类型变量
    final int anInt = 10;
    //静态基本类型变量
    static final int staticInt = 11;
    //可变的成员变量
    final int randomInt = (int) (Math.random() * 20);
    //静态可变的变量
    static final int staticRandomInt = (int) (Math.random() * 20 + 1);

    //引用类型
    final Value value = new Value();
    //静态引用类型
    static final Value staticValue = new Value();

    final int[] a = {1, 2, 3, 4, 5, 6};

    @Test
    public void test1() {
        FinalData finalData = new FinalData();
//        finalData.anInt=anInt+1;
//        FinalData.staticInt=FinalData.staticInt+1;
//        finalData.randomInt=randomInt+1;
        for (int i = 0; i < 3; i++) {
            FinalData newFinal = new FinalData();
            System.out.println(randomInt);
            System.out.println(newFinal.randomInt);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(randomInt);
        }
    }
}

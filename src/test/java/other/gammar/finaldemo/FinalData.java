package other.gammar.finaldemo;

/**
 * fd1:i4 = 6,i5 = 19
 * new FinalData..
 * fd1:i4 = 6,i5 = 19
 * fd2:i4 = 14,i5 = 19
 * */
public class FinalData {
    final int i1 = 9;
    static final int I2 = 99;
    public static final int I3 = 39;
    //只要FinalData实例不改变 这个不改变
    final int i4 = (int) (Math.random() * 20);
    //FinalData被加载一次执行不辞random,就是说不被FinalData不消亡就一直不变
    static final int i5 = (int) (Math.random() * 20+1);

    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();

    final int[] a = {1, 2, 3, 4, 5, 6};

    public void print(String id) {
        System.out.println(id + ":" + "i4 = " + i4 + ",i5 = " + i5);
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData();
        //final的成员变量不能改变
        //fd1.i1++;
        fd1.v2.i++;
        fd1.v1 = new Value(); //不是final完全ok
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        //final 引用不让改变
        //fd1.v2=new Value();
        // 不能改变
        //v3=new Value()
        fd1.print("fd1");
        System.out.println("new FinalData..");
        FinalData fd2 = new FinalData();
        fd1.print("fd1");
        fd2.print("fd2");
    }
}

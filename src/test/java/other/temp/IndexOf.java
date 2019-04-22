package other.temp;

import org.junit.Test;

public class IndexOf {
    //循环次数：5百万次
    static int times = 5000000;
    //外围循环次数：5次
    static int nums = 5;
    //每项时间
    static long t1 = 0, t2 = 0;
    static String src = "BBC ABCDAB ABCDABCDABDE";
    static String tar = "BDE";

    @Test
    public  void test1() {
        //每项循环测试5次
        int i = 0;
        for (; i < 10; i++) {
            boolean matchResult = false;
            long begin = System.nanoTime();
            for (int j = 0; j < times; j++) {
                int i1 = src.indexOf(tar);
            }
            long end = System.nanoTime();
            System.out.println(end - begin);
        }
    }

    @Test
    public  void test2() {
        //每项循环测试5次
        int i = 0;
        for (; i < 10; i++) {
            boolean matchResult = false;
            long begin = System.nanoTime();
            for (int j = 0; j < 5000000; j++) {
                int i2 = src.indexOf(tar, 2);
            }
            long end = System.nanoTime();
            System.out.println(end - begin);
        }
    }
}

package thinkinjava;

import org.junit.Test;

public class Hide {
    class Homer{
        char doh(char c){
            System.out.println("doh(char)");
            return 'd';
        }
        float doh(float f){
            System.out.println("doh(float)");
            return 1.0f;
        }
    }

    class Milhouse{

    }
    class Bart  extends Homer{
        void doh(Milhouse m) {
        }
    }

    @Test
    public  void test(){
        Bart b=new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}

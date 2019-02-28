package other.gammar.base;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class OutInClass {
    static{
        System.out.println("OutInClass static code...");
    }
    {
        System.out.println("OutInClass construct code...");
    }

    public OutInClass() {
        System.out.println("OutInClass construct method...");
    }

    @Component
    public static class InClass{
        static{
            System.out.println("InClass static code...");
        }
        {
            System.out.println("InClass construct code...");
        }

        @Autowired
        public InClass() {
            System.out.println("InClass construct metho  d...");
        }
    }

    @Test
    public void test(){
        InClass inClass = new InClass();
        OutInClass outInClass = new OutInClass();
    }
}

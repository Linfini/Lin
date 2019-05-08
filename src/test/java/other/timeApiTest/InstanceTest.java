package other.timeApiTest;

import org.junit.Test;

import java.time.Instant;

public class InstanceTest {
    //Instant始终输出的是
    @Test
    public void test1(){
        Instant now = Instant.now();
        System.out.println(now);
        
        Instant instant = Instant.ofEpochSecond(20);
        System.out.println(instant);

        Instant milli = Instant.ofEpochMilli(2000);
        System.out.println(milli);
        System.out.println(Instant.ofEpochMilli(0));
    }
}

package other.timeApiTest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    //new Date()出来的年份是2012+1900 辣鸡API 而且月份也不对
    @Test
    public void test1() {
        Date date = new Date(2012, 1, 1);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 2);
        System.out.println(calendar.getTime());
    }

    //Calendar 的问题主要在于属性可变
    @Test
    public void test2() {
        Calendar birth = Calendar.getInstance();
        birth.set(1975, Calendar.MAY, 26);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth,now));
        System.out.println(daysBetween(birth,now));

    }

     private static long daysBetween(Calendar begin, Calendar end) {
        long daysBetween = 0;
        while (begin.before(end)) {
            begin.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

}

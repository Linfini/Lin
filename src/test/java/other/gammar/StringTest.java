package other.gammar;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    @Test
    public void test1(){
        boolean numeric = StringUtils.isNumeric("213.1") || isNumeric("213.1");
        System.out.println(numeric);
    }

    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    @Test
    public void testRegix(){
        String sql = "select * from #{tableName}";

        Pattern pattern = Pattern.compile("(#\\{.*\\})");
        Matcher matcher = pattern.matcher(sql);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        sql = matcher.replaceAll("your_table");
        System.out.println(sql);
    }

    @Test
    public void testRegix2(){
        String sql = "select #{userName} from #{tableName}";
        Map<String, String> map = new HashMap<>();
        map.put("tableName","user");
        map.put("userName","name");


        Matcher matcher = Pattern.compile("(#\\{.*\\})").matcher(sql);
        if (matcher.find()) {
            String group= matcher.group();
            group=group.replaceAll("#\\{","").replaceAll("\\}","");
            System.out.println(matcher.group(0));
        }
        sql = matcher.replaceAll("your_table");
        System.out.println(sql);
    }

    @Test
    public void testReplace(){
        String sql = "select #{userName} from #{tableName}";
        Map<String, String> map = new HashMap<>();
        map.put("tableName","user");
        map.put("userName","name");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String s = "#{" + entry.getKey() + "}";
            sql = sql.replace( s,entry.getValue());
        }
        System.out.println(sql);
    }

}

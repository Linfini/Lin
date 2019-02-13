package other;

import org.junit.Test;

import javax.transaction.UserTransaction;
import java.lang.reflect.InvocationHandler;
import java.sql.*;

public class JDBCTest {
    private static final String URL = "jdbc:mysql://localhost:3306/web_zaki?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        UserTransaction userTx = null;
        Connection mySqlConnection = null;
        Statement mySqlStat = null;

        Connection connB = null;
        Statement stmtB = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_expand");
        while (rs.next()) {
            System.out.println(rs.getString("user_name") + ":" + rs.getString("profile"));
        }
    }
}

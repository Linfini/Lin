package other.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * 还得JDBC怎么链接数据库吗?
 * JDBC 全程Java Database Connectivity,是java语言定义如何连接数据库的一套规范
 */
public class JDBCTest {

    final String driver = "com.mysql.cj.jdbc.Driver";
    final String jdbcUrl = "jdbc:mysql://localhost:3306/exam?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    final String user = "root";
    final String pass = "1234";

    @Test
    public void testConnection() {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(jdbcUrl, user, pass);
            stat = conn.createStatement();
            String sql;
            sql = "select * from user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id:"+id);
                System.out.println("name"+name);
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.zaki.drivermanage;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 通过jdbc驱动理解线程上下文加载器ThreadContextClassLoader
 * <p>
 * SPI机制
 * Java SPI的具体约定为：当服务的提供者提供了服务接口的一种实现之后，在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，并装载实例化，完成模块的注入。基于这样一个约定就能很好的找到服务接口的实现类，而不需要再代码里制定。jdk提供服务实现查找的一个工具类：java.util.ServiceLoader。
 */
public class DriverManageTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        Connection conn = java.sql.DriverManager.getConnection(url, "root", "1234");
        System.out.println("success");
    }
}

package other.mybatis;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SqlSessionFactoryTest {


    @Test
    public void getSqlSessionFactory() {
        MybatisSqlSessionFactory sessionFactory = new MybatisSqlSessionFactory();
        List<?> objects = sessionFactory.openSession();
        Assert.assertNotNull(objects);
    }


    public void getSqlSession() {

    }
}

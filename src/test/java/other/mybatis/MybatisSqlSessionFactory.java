package other.mybatis;

import com.zaki.mapper.CountryMapper;
import com.zaki.model.Country;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@SuppressWarnings("unchecked")
public class MybatisSqlSessionFactory {

    /**
     * 使用java代码构建SqlSessionFactory,而不是xml
     */
    public SqlSessionFactory getSqlSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/world?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        properties.setProperty("username", "root");
        properties.setProperty("password", "1234");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", jdbcTransactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(CountryMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    public List<?> openSession() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        List<Country> list = (List<Country>) mapper.selectAll();
        sqlSession.close();
        return list;
    }
}

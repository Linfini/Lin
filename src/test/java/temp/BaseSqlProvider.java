package temp;

import org.apache.ibatis.jdbc.SQL;

public final class BaseSqlProvider {

    private BaseSqlProvider() {

    }

    private static BaseSqlProvider instance = null;

    public static BaseSqlProvider getInstance() {
        if (null == instance) {
            instance = new BaseSqlProvider();
        }
        return instance;
    }

    private String table;

    public void setDomain(String domain) {
        getInstance().table = domain.toLowerCase() + "";
    }

    //下面的代码块会造成stackoverflow!!!!!!!
//    {
//        log.info("current table is :{}", getInstance().table);
//    }
    static {
    }

    public String selectAll() {
        return new SQL() {{
            SELECT("*");
            FROM(getInstance().table);
        }}.toString();
    }
}

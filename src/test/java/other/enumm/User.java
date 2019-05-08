package other.enumm;

public enum User {
    //用户问卷导出生成excel
    login("账号"),userName("姓名");
    private String name;
    User(String name) {
        this.name = name;
    }
}

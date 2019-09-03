package other.gammar.finaldemo;

/**
 * final修饰方法参数
 *
 * 1.使用loginInfo=new LoginInfo(); 因为final的LoginInfo不允许修改内存地址
 * 2.final int/Integer 也不允许重新赋值
 *
 *
 * final不允许改变loginInfo 或者id 是指在loginCheck和idCheck方法内部,对于调用者来说成员参数可以任意改变
 *
 * */
public class FinalDemo {

    public void loginCheck(final LoginInfo loginInfo){
//        loginInfo=new LoginInfo();
        loginInfo.setId(23L);
    }

    public void idCheck(final Integer id){
    }
}

package com.lin.events;

public class Client {
    public static void main(String[] args) {
        LoginBean loginBean = new LoginBean();

        LoginEventListener listenerA = new LoginValidatorA();
        LoginEventListener listenerB = new LoginValidatorB();
        loginBean.addLoginEventListener(listenerA);
        loginBean.addLoginEventListener(listenerB);

        loginBean.login("张三", null);
    }
}

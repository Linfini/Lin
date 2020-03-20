package com.lin.events;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * subject
 */
public class LoginBean {
    private List<LoginEventListener> loginEventListeners = new ArrayList<>();
    private LoginEvent loginEvent;


    public LoginBean() {
    }


    public void addLoginEventListener(LoginEventListener listener) {
        loginEventListeners.add(listener);
    }

    public void login(String userName, String pass) {
        loginEvent = new LoginEvent();
        loginEvent.setUserName(userName);
        loginEvent.setPassword(pass);
        actionPerformed(loginEvent);
        System.out.println("success");
    }


    private void actionPerformed(LoginEvent event) {
        for (LoginEventListener listener : loginEventListeners) {
            listener.validateLogin(event);
        }
    }
}

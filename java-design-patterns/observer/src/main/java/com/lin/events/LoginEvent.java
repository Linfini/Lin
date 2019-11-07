package com.lin.events;

import java.util.EventObject;

public class LoginEvent {
    private String userName;
    private String password;

    public LoginEvent() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

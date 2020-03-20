package com.lin.events;

public class LoginValidatorA implements LoginEventListener {
    @Override
    public void validateLogin(LoginEvent event) {
        if (null == event) {
            return;
        }
        if (null == event.getPassword()) {
            throw new RuntimeException("validatorA: 密码不能为空");
        }
    }
}

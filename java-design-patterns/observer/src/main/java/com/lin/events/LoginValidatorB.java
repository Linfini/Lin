package com.lin.events;

public class LoginValidatorB implements LoginEventListener {
    @Override
    public void validateLogin(LoginEvent event) {
        if (null == event) {
            return;
        }
        if (null == event.getUserName() || null == event.getPassword()) {
            throw new RuntimeException("validatorB:用户名或密码不能为空");
        }
    }
}

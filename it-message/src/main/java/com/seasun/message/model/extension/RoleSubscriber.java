package com.seasun.message.model.extension;

import java.util.List;

public class RoleSubscriber {
    private final Long roleId;
    private List<Subscriber> subscribers;

    public RoleSubscriber(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}

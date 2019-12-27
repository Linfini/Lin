package com.messsage.model.domain;

import lombok.Data;

@Data
public class Subscription {
    private Long id;

    private Long target;

    private String targetType;

    private String action;

    private String channel;

    private Long subscriber;

    private String subscriberType;
}
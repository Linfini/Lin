package com.messsage.model.domain;

import lombok.Data;

@Data
public class MessageTemplate {
    private Long id;

    private String targetType;

    private String action;

    private String type;

    private String template;
}
package com.messsage.model.extension;

import lombok.Data;

@Data
public class MessageSubject {
    private Long source;
    private String sourceInfo;
    private String action;
    private String targetType;
    private Long target;
    private String targetInfo;
}

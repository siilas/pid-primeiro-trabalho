package com.github.siilas.pid.primeiro.trabalho.enums;

import lombok.Getter;

@Getter
public enum Descriptor {
    
    GLCM("Gray Level Co-occurrence Matrix"),
    LBP("Local Binary Patterns"),
    WLD("Weber Local Descriptor");

    private final String value;
    
    Descriptor(String value) {
        this.value = value;
    }
    
}

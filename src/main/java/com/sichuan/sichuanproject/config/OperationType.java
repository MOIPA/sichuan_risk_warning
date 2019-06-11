package com.sichuan.sichuanproject.config;

/**
 * @author
 */
public enum OperationType {

    /**
     * 新增或者修改用户
     */
    CHANGE("C"),

    /**
     * 删除用户
     */
    DELETE("D");

    private String type;

    OperationType(String type) {
        this.type = type;
    }

    public String value() {
        return type;
    }
}

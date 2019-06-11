package com.sichuan.sichuanproject.config;

/**
 * @author
 */
public enum WarningModelType {

    /**
     * 监管对象
     */
    SUPERVISION_OBJECT(1,"监管对象"),

    /**
     * 监管行为
     */
    SUPERVISION_ACTION(2,"监管行为");

    private Integer index;
    private String typeName;

    WarningModelType(Integer index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public Integer indexValue() {
        return index;
    }

    public String typeNameValue() {
        return typeName;
    }

    public WarningModelType getWarningModelTypeByIndex(Integer index) {
        for (WarningModelType warningModelType : WarningModelType.values()) {
            if (index.equals(warningModelType.indexValue())) {
                return warningModelType;
            }
        }

        return null;
    }
}

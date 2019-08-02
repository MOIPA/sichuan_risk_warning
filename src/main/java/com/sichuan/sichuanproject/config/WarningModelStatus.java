package com.sichuan.sichuanproject.config;

/**
 * @author
 */
public enum WarningModelStatus {
    /**
     * 审批中
     */
    UNDER_REVIEW(1),

    /**
     * 审批未通过
     */
    NO_PASSED(2),

    /**
     * 已审批
     */
    REVIEWED(3),

    /**
     * 启用中
     */
    USING(4),

    /**
     * 已关闭
     */
    CLOSED(5),

    /**
     * 已删除
     */
    DELETED(9);

    private Integer index;

    WarningModelStatus(Integer index) {
        this.index = index;
    }

    public Integer value() {
        return index;
    }


}

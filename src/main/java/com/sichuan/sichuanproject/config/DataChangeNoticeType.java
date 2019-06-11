package com.sichuan.sichuanproject.config;

/**
 * @author
 */
public enum DataChangeNoticeType {

    /**
     * 用户信息
     */
    USER_INFO(1),

    /**
     * 账户信息
     */
    ACCOUNT_INFO(2),

    /**
     * 用户角色信息
     */
    USER_ROLE_INFO(3),

    /**
     * 角色信息
     */
    ROLE_INFO(4),

    /**
     * 角色菜单信息
     */
    ROLE_MENU_INFO(5),

    /**
     * 菜单信息
     */
    MENU_INFO(6),

    /**
     * 区域信息
     */
    AREA_INFO(7),

    /**
     * 部门信息
     */
    ORG_INFO(8);

    private Integer index;

    DataChangeNoticeType(Integer index) {
        this.index = index;
    }

    public Integer value() {
        return index;
    }
}

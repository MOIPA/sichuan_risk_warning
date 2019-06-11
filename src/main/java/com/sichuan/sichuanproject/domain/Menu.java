package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class Menu {
    private String menuContent;
    private Integer orderNum;
    private Long menuId;
    private Integer menuType;
    private String updateTime;
    private String menuName;
    private String appCode;
    private Long parentMenu;

    public Menu() {
        //do nothing;
    }

    public Menu(Long menuId, String menuName, Integer menuType, String menuContent, Long parentMenu, Integer orderNum, String appCode, String updateTime) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuType = menuType;
        this.menuContent = menuContent;
        this.parentMenu = parentMenu;
        this.orderNum = orderNum;
        this.appCode = appCode;
        this.updateTime = updateTime;
    }
}

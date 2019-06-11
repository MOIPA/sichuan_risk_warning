package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class MenuInfoDTO {
     private String menuContent;
     private Integer orderNum;
     private Long menuId;
     private Integer menuType;
     private String updateTime;
     private String menuName;
     private String appCode;
     private Long parentMenu;
     private String icon;
     private String perms;
}

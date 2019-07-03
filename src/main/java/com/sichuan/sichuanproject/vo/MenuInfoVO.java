package com.sichuan.sichuanproject.vo;

import lombok.Data;

/**
 * @author
 */

@Data
public class MenuInfoVO {
    private Long menuId;
    private String menuName;
    private Long parentMenuId;
    private Integer orderNum;
}

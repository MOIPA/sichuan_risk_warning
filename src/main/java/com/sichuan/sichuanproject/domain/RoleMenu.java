package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class RoleMenu {
    private Long roleMenuId;
    private Long roleCode;
    private Long orgId;
    private Long menuId;
    private String updateTime;

    public RoleMenu() {
        //do nothing;
    }

    public RoleMenu(Long roleMenuId, Long roleCode, Long orgId, Long menuId, String updateTime) {
        this.roleMenuId = roleMenuId;
        this.roleCode = roleCode;
        this.orgId = orgId;
        this.menuId = menuId;
        this.updateTime = updateTime;
    }
}

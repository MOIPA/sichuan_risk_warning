package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class Role {
    private Long roleCode;
    private String roleName;
    private String description;
    private Integer validStatus;
    private String updateTime;

    public Role() {
        //do nothing;
    }

    public Role(Long roleCode, String roleName, String description, Integer validStatus, String updateTime) {
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.description = description;
        this.validStatus = validStatus;
        this.updateTime = updateTime;
    }
}

package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class UserRole {
    private Long userId;
    private Long roleCode;
    private Long orgId;
    private String updateTime;

    public UserRole() {
        //do nothing;
    }

    public UserRole(Long userId, Long orgId, Long roleCode, String updateTime) {
        this.userId = userId;
        this.orgId = orgId;
        this.roleCode = roleCode;
        this.updateTime = updateTime;
    }
}

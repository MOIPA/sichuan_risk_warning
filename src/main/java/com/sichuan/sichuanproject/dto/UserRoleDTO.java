package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class UserRoleDTO {
    private Long userId;
    private Long roleCode;
    private Long orgId;
    private String updateTime;
}

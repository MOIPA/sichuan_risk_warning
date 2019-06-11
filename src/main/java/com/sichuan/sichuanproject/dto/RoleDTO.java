package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class RoleDTO {
    private Long roleCode;
    private String roleName;
    private String roleDesc;
    private Integer validStatus;
    private String updateTime;
}

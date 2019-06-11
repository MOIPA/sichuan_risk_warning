package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private Long orgId;
    private String birthAddress;
    private String address;
    private String mobile;
    private String idCode;
    private String updateTime;
}

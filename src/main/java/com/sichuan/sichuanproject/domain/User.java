package com.sichuan.sichuanproject.domain;

import lombok.Data;


/**
 * @author
 */

@Data
public class User {
    private Long userId;

    private String userName;

    private Long orgId;

    private String birthAddress;

    private String address;

    private String mobile;

    private String idCode;

    private String updateTime;

    public User() {
        //do nothing;
    }

    public User(Long userId, String userName, Long orgId, String birthAddress, String address, String mobile, String idCode, String updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.orgId = orgId;
        this.birthAddress = birthAddress;
        this.address = address;
        this.mobile = mobile;
        this.idCode = idCode;
        this.updateTime = updateTime;
    }
}

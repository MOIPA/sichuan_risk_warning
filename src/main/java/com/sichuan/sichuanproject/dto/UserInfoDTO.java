package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class UserInfoDTO {
    private String uuid;
    private String orgId;
    private Integer userType;
    private String orgCode;
    private String orgShortName;
    private String orgFullName;
    private String orgInnerCode;
    private String desc;
    private String fax;
    private String tel;
    private String userName;
    private String firstName;
    private String lastName;
    private String nickName;
    private String trueName;
    private String email;
    private String mobile;
    private String relPerson;
    private String regFrom;
    private String createdDate;
    private String lastLogoutDate;
    private String lastLoginDate;
    private String regIP;
    private String loginTimes;
    private Boolean actived;
    private Integer accountType;
    private String groupName;
    private String corpName;
    private Integer corporateType;
    private Integer loginAccountType;
    private String creditID;
    private String identity;
}

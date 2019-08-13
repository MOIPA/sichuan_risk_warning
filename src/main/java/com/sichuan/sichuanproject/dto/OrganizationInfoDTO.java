package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class OrganizationInfoDTO {
    private Long orgId;
    private String orgCode;
    private String orgName;
    private String areaCode;
    private String shortName;
    private Long parentOrg;
    private Integer isDelete;
    private String updateTime;
    private Integer isParent;
    private String areaId;
}

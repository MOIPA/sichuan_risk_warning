package com.sichuan.sichuanproject.domain;

import io.swagger.models.auth.In;
import lombok.Data;


/**
 * @author
 */

@Data
public class Organization {
    private Long orgId;
    private String orgCode;
    private String orgName;
    private String areaCode;
    private String shortName;
    private Long parentOrg;
    private Integer isDelete;
    private String updateTime;
    private Integer isParent;

    public Organization() {
        //do nothing;
    }

    public Organization(Long orgId, String orgCode, String orgName, String areaCode, String shortName, Long parentOrg, Integer isDelete, String updateTime, Integer isParent) {
        this.orgId = orgId;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.areaCode = areaCode;
        this.shortName = shortName;
        this.parentOrg = parentOrg;
        this.isDelete = isDelete;
        this.updateTime = updateTime;
        this.isParent = isParent;
    }
}

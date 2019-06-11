package com.sichuan.sichuanproject.domain;

import com.sichuan.sichuanproject.form.WarningModelForm;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningModel {
    private Long id;

    private String name;

    private Integer type;

    private String orgCode;

    private String creatorId;

    private Timestamp createTime;

    private Integer status;

    public WarningModel warningModelByForm(WarningModelForm form) {
        WarningModel warningModel = new WarningModel();
        warningModel.setName(form.getName());
        warningModel.setType(form.getType());
        warningModel.setOrgCode(form.getOrgCode());
        warningModel.setCreatorId(form.getCreatorId());

        return warningModel;
    }
}

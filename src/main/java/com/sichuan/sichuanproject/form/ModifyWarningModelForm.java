package com.sichuan.sichuanproject.form;

import lombok.Data;

/**
 * @author
 */

@Data
public class ModifyWarningModelForm {
    private Long warningModelId;

    private String name;

    private Integer type;

    private String orgCode;
}

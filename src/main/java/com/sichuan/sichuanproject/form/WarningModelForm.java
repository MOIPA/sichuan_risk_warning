package com.sichuan.sichuanproject.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author
 */

@Data
public class WarningModelForm {

    @NotBlank(message = "模型名称不能为空")
    private String name;

    @NotNull(message = "类型不能为空")
    private Integer type;

    @NotBlank(message = "部门不能为空")
    private String orgCode;

    private String creatorId;

}

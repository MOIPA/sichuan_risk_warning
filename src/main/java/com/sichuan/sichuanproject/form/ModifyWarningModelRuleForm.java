package com.sichuan.sichuanproject.form;

import lombok.Data;

/**
 * @author
 */

@Data
public class ModifyWarningModelRuleForm {

    private Long warningModelId;

    private Double highRisk;

    private Double middleHighRisk;

    private Double middleRisk;

    private Double lowRisk;
}

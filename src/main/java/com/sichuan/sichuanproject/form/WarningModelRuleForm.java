package com.sichuan.sichuanproject.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningModelRuleForm {

    private Long warningModelId;

    private String domainId;

    private String keyWord;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp startTime;

    private Float highRiskValue;

    private Float middleHighRiskValue;

    private Float middleRiskValue;

    private Float lowRiskValue;

    private Float highRiskValueIncrement;

    private Float middleHighRiskValueIncrement;

    private Float middleRiskValueIncrement;

    private Float lowRiskValueIncrement;
}

package com.sichuan.sichuanproject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningModelRule {

    private Long warningModelId;

    private String domainId;

    private String keyWord;

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

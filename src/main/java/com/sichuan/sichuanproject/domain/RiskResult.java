package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class RiskResult {
    private Integer id;
    private String createdAt;
    private Float riskValue;
    private Long warningModelId;

}

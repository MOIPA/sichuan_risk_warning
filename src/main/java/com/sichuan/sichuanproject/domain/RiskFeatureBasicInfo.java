package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class RiskFeatureBasicInfo {
    private Long id;
    private String riskFeatureName;
    private String businessClassification;
    private String characteristicIndex;
    private String connectionRelation;
}

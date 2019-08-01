package com.sichuan.sichuanproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class StaRewiDTO {
    private String id;

    private String areaCode;

    private String areaName;

    private String deptCode;

    private String deptName;

    private String riskCount;

    private String riskLevel;

    private String riskField;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp FXYJXT;

    private String staData;

}

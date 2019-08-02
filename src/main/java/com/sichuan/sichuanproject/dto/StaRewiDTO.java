package com.sichuan.sichuanproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
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

    private String FXYJXT = "FXYJXT";

//    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private String staData;

}

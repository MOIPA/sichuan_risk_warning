package com.sichuan.sichuanproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningModelDTO {
    private Long id;

    private String name;

    private Integer type;

    private String orgName;

    private String creatorId;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp createTime;

    private Integer status;
}

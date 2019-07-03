package com.sichuan.sichuanproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningSignalVO {
    private String fxyjId;

    private String name;

    private String fxyjDomainId;

    private String fxyjAreaNumber;

    private String fxyjTitle;

    private String fxyjDesc;

    private String fxyjLevel;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp fxyjTime;

    private String fxyjModelId;

    private String fxyjDetailUrl;
}

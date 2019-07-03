package com.sichuan.sichuanproject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class Opinion {
    private String eventId;

    private String eventType;

    private String typeKeyWords;

    private String eventTitle;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp eventDate;

    private String eventAbstract;

    private String eventLevel;

    private String eventStatus;

    private String eventEmottonal;

    private String districtCode;

    private String url;

    private String source;

    private String domain;
}

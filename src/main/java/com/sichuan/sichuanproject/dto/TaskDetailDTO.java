package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.util.List;

/**
 * @author
 */

@Data
public class TaskDetailDTO {
    private String taskName;

    private String taskNumber;

    private String taskExplain;

    private String mark;

    private String matter;

    private String dept;

    private List<BackListDTO> backlist;

    private List<FeedListDTO> feedlist;
}

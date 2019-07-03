package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.util.List;


/**
 * @author
 */

@Data
public class AddTaskDTO {

    private String taskName;

    private String applicationCode;

    private String levelId;

    private String taskTimeLimit;

    private String classId;

    private String taskExplain;

    private String launchDepartmentCode;

    private String launchDepartmentName;

    private String createUserName;

    private List<AttachmentDTO> attachmentDTOList;

    private List<DistributeDepartmentDTO> distributeDepartmentDTOList;
}

package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.util.List;

/**
 * @author
 */

@Data
public class TaskDTO {
    private String taskName;
    private String taskCode;
    private String taskExplain;
    private String createTime;
    private String levelId;
    private String taskTimeLimit;
    private String sourceName;
    private String className;
    private String LaunchDepartmentName;
    private String CreateUserName;
    private List<String> attachment;
}

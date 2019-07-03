package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.util.List;

/**
 * @author
 */

@Data
public class TaskDetailDTO {

    private TaskDTO task;
    private List<TaskDepartmentRelationDTO> taskDepartmentRelation;
}

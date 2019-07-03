package com.sichuan.sichuanproject.form;

import lombok.Data;

/**
 * @author
 */

@Data
public class TaskStatusForm {
    private String taskCode;
    private Integer taskStatus;
    private String message;
}

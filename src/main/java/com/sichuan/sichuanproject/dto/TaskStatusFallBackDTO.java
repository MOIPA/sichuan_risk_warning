package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class TaskStatusFallBackDTO {
    private String taskCode;
    private String taskMessage;
    private Boolean stauts;
}

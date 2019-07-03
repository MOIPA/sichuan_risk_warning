package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class TaskDetailFallBackDTO {
    private String resultCode;
    private TaskDetailDTO resultData;
    private String resultMsg;
}

package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class AddTaskFallBackDTO {
    private String resultCode;
    private TaskNumberDTO resultData;
    private String resultMsg;
}

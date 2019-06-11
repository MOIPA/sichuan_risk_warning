package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class AddTaskFallBackDTO {
    private Integer resultCode;
    private TaskNumberDTO resultData;
    private String resultMsg;
}

package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.util.List;

/**
 * @author
 */

@Data
public class TaskClassifyInfoDTO {
    private Integer resultCode;
    private String resultMsg;
    private List<TaskClassifyDTO> resultData;
}

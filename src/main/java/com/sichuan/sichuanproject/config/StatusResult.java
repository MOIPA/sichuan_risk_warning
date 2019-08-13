package com.sichuan.sichuanproject.config;

import lombok.Data;

/**
 * @author
 */

@Data
public class StatusResult {
    /**
     * 状态码：0成功，其他为失败
     */
    private String status;

    public StatusResult(Integer status) {
        this.status = status+"";
    }
}

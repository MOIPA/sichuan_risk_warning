package com.sichuan.sichuanproject.config;

import lombok.Data;

/**
 * @author
 */

@Data
public class BaseResult {
    /**
     * 状态码：1成功，其他为失败
     */
    private int code;

    /**
     * 成功为success，其他为失败原因
     */
    private String message;

    /**
     * 数据结果集
     */
    public Object data;

    public BaseResult() {
        //do nothing;
    }

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

package com.sichuan.sichuanproject.domain;

import lombok.Data;

/**
 * @author
 */

@Data
public class Task {
    private String taskNumber;
    private String taskName;
    private String taskExplain;
    private String mark;
    private Integer status;

    public Task() {
        //do nothing;
    }

    public Task(String taskNumber, String taskName, String taskExplain, String mark, Integer status) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskExplain = taskExplain;
        this.mark = mark;
        this.status = status;
    }
}

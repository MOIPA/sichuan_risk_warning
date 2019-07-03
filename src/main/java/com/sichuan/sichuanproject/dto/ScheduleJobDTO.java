package com.sichuan.sichuanproject.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class ScheduleJobDTO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 任务名
     */
    private String jobName;
    /**
     * 任务组
     */
    private String jobGroup;
    /**
     * 要执行的方法的名称
     */
    private String methodName;
    /**
     * 要执行的方法所在的class路径
     */
    private String beanClass;
    /**
     * 定时任务状态，0表示正常，1表示停止
     */
    private Integer status;
    /**
     * 时间表达式
     */
    private String cronExpression;
    /**
     * 参数
     */
    private String params;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp modifyTime;

    public ScheduleJobDTO() {
        //do nothing;
    }

    public ScheduleJobDTO(Long id, String jobName, String jobGroup, String methodName, String beanClass, Integer status,
                       String cronExpression, String params, String remark, Timestamp createTime, Timestamp modifyTime) {
        this.id = id;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.methodName = methodName;
        this.beanClass = beanClass;
        this.status = status;
        this.cronExpression = cronExpression;
        this.params = params;
        this.remark = remark;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
}

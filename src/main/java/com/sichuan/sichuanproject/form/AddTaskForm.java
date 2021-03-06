package com.sichuan.sichuanproject.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author
 */

@Data
public class AddTaskForm {

    @NotBlank(message = "任务名称不能为空")
    private String taskName;

    private String levelId;

    private String taskTimeLimit;

    private String taskExplain;

    private String launchDepartmentCode;

    private String launchDepartmentName;

    private String createUserName;
}

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

    private String taskExplain;

    private String mark;

    private String markName;

    private List<String> matter;

    private List<String> dept;

    private List<String> deptId;
}

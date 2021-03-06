package com.sichuan.sichuanproject.service;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.Task;
import com.sichuan.sichuanproject.dto.TaskClassifyDTO;
import com.sichuan.sichuanproject.dto.TaskDetailDTO;
import com.sichuan.sichuanproject.dto.TaskStatusFallBackDTO;
import com.sichuan.sichuanproject.form.AddTaskForm;
import com.sichuan.sichuanproject.form.TaskStatusForm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface TaskService {

    /**
     * 获取任务分类
     *
     * @return
     */
    List<TaskClassifyDTO> getTaskClassify();

    /**
     *创建任务
     *
     * @param addTaskForm
     * @return
     */
    String createTask(AddTaskForm addTaskForm);

    /**
     * 获取任务详情
     *
     * @param taskCode
     * @return
     */
    TaskDetailDTO getTaskDetail(String taskCode);

    /**
     * 获取任务信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Task> getTasks(Integer pageNum, Integer pageSize);

    /**
     * 任务状态通知
     *
     * @param taskStatusForm
     * @return
     */
    TaskStatusFallBackDTO noticeTaskStatus(TaskStatusForm taskStatusForm);
}

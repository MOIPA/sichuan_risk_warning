package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.Task;
import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.form.AddTaskForm;
import com.sichuan.sichuanproject.form.TaskStatusForm;
import com.sichuan.sichuanproject.mapper.TaskMapper;
import com.sichuan.sichuanproject.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */

@Component
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TaskMapper taskMapper;

    static String taskServiceUrl = "http://59.225.206.13:8471/gateway/";

    @Override
    public List<TaskClassifyDTO> getTaskClassify() {
        List<TaskClassifyDTO> taskClassifyDTOList;
        TaskClassifyInfoDTO taskClassifyInfoDTO = restTemplate.getForObject(taskServiceUrl + "task/classify", TaskClassifyInfoDTO.class);
        taskClassifyDTOList = taskClassifyInfoDTO.getResultData();

        return taskClassifyDTOList;
    }

    @Override
    public String createTask(AddTaskForm addTaskForm) {
        String matter = null;
        String dept = null;
        String deptid = null;
        if (addTaskForm.getMatter() != null && !addTaskForm.getMatter().isEmpty()) {
            matter = String.join(",", addTaskForm.getMatter());
        }
        if (addTaskForm.getDept() !=null && !addTaskForm.getDept().isEmpty()) {
            dept = String.join(",", addTaskForm.getDept());
        }
        if (addTaskForm.getDeptId() !=null && !addTaskForm.getDeptId().isEmpty()) {
            deptid = String.join(",", addTaskForm.getDeptId());
        }
        String url = taskServiceUrl + "task/createTask?taskName="+ addTaskForm.getTaskName() +"&taskexplain="+addTaskForm.getTaskExplain()+"&mark="+addTaskForm.getMark()+"&matter="+matter+"&dept="+dept+"&deptid="+deptid;
        AddTaskFallBackDTO result = restTemplate.postForObject(url,"",AddTaskFallBackDTO.class);
        Task task = new Task(result.getResultData().getTaskNumber(), addTaskForm.getTaskName(), addTaskForm.getTaskExplain(), addTaskForm.getTaskName(), 0);
        taskMapper.insertTask(task);

        return result.getResultData().getTaskNumber();
    }

    @Override
    public TaskDetailDTO getTaskDetail(String taskNumber) {
        TaskDetailFallBackDTO taskDetailFallBackDTO = restTemplate.postForObject(taskServiceUrl + "task/taskDetail?taskNumber=" + taskNumber,"", TaskDetailFallBackDTO.class);

        return taskDetailFallBackDTO.getResultData();
    }

    @Override
    public PageInfo<Task> getTasks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Task> taskList = taskMapper.getTasks();
        PageInfo pageInfo = new PageInfo(taskList);

        return pageInfo;
    }

    @Override
    public TaskStatusFallBackDTO noticeTaskStatus(TaskStatusForm taskStatusForm) {
        TaskStatusFallBackDTO taskStatusFallBackDTO = new TaskStatusFallBackDTO();
        taskStatusFallBackDTO.setTaskNumber(taskStatusForm.getTaskNumber());
        int result = taskMapper.updateTask(taskStatusForm.getTaskNumber(), taskStatusForm.getStatus());
        if (result > 0) {
            taskStatusFallBackDTO.setMessage("成功");
        }else {
            taskStatusFallBackDTO.setMessage("失败");
        }

        return taskStatusFallBackDTO;
    }
}

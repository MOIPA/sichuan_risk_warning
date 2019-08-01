package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.Task;
import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.form.AddTaskForm;
import com.sichuan.sichuanproject.form.TaskStatusForm;
import com.sichuan.sichuanproject.mapper.primary.TaskMapper;
import com.sichuan.sichuanproject.service.TaskService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
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

    private static String taskServiceUrl = "http://59.225.206.13:8471/out/";

    @Override
    public List<TaskClassifyDTO> getTaskClassify() {
        List<TaskClassifyDTO> taskClassifyDTOList;
        TaskClassifyInfoDTO taskClassifyInfoDTO = restTemplate.getForObject(taskServiceUrl + "task/classify", TaskClassifyInfoDTO.class);
        taskClassifyDTOList = taskClassifyInfoDTO.getResultData();

        return taskClassifyDTOList;
    }

    @Override
    public String createTask(AddTaskForm addTaskForm) {

        String url = taskServiceUrl + "task/taskCreate/createTask";
        AddTaskDTO addTaskDTO = (AddTaskDTO) OrikaMapper.map(addTaskForm, AddTaskDTO.class);
        addTaskDTO.setApplicationCode("FXYJXT");
        addTaskDTO.setClassId("riskWarning");
        addTaskDTO.setAttachmentDTOList(new ArrayList<>());
        addTaskDTO.setDistributeDepartmentDTOList(new ArrayList<>());


        AddTaskFallBackDTO result = restTemplate.postForObject(url,addTaskDTO,AddTaskFallBackDTO.class);
        Task task = new Task(result.getResultData().getTaskCode(), addTaskForm.getTaskName(), addTaskForm.getTaskExplain(), addTaskForm.getTaskName(), 0);
        taskMapper.insertTask(task);

        return result.getResultData().getTaskCode();
    }

    @Override
    public TaskDetailDTO getTaskDetail(String taskCode) {
        TaskDetailFallBackDTO taskDetailFallBackDTO = restTemplate.postForObject(taskServiceUrl + "task/taskDetail/getTaskByDetail?taskCode=" + taskCode,"", TaskDetailFallBackDTO.class);

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
        taskStatusFallBackDTO.setTaskCode(taskStatusForm.getTaskCode());
        int result = taskMapper.updateTask(taskStatusForm.getTaskCode(), Integer.valueOf(taskStatusForm.getTaskStatus()));
        if (result > 0) {
            taskStatusFallBackDTO.setTaskMessage("成功");
            taskStatusFallBackDTO.setStauts(true);
        }else {
            taskStatusFallBackDTO.setTaskMessage("失败");
            taskStatusFallBackDTO.setStauts(false);
        }

        return taskStatusFallBackDTO;
    }
}

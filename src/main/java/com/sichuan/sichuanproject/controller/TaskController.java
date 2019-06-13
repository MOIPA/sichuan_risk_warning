package com.sichuan.sichuanproject.controller;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.Task;
import com.sichuan.sichuanproject.dto.TaskClassifyDTO;
import com.sichuan.sichuanproject.dto.TaskDetailDTO;
import com.sichuan.sichuanproject.form.AddTaskForm;
import com.sichuan.sichuanproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/risk-warning/task/classify", method = RequestMethod.GET)
    public List<TaskClassifyDTO> getTaskClassify() {
        return taskService.getTaskClassify();
    }

    @RequestMapping(value = "/risk-warning/task/add", method = RequestMethod.POST)
    public String createTask(@RequestBody AddTaskForm addTaskForm) {
        return taskService.createTask(addTaskForm);
    }

    @RequestMapping(value = "/risk-warning/task/detail", method = RequestMethod.GET)
    public TaskDetailDTO getTaskDetail(@RequestParam(value = "taskNumber") String taskNumber) {
        return taskService.getTaskDetail(taskNumber);
    }

    @RequestMapping(value = "/risk-warning/task/tasks", method = RequestMethod.GET)
    public PageInfo<Task> getTasks(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return taskService.getTasks(pageNum, pageSize);
    }
}

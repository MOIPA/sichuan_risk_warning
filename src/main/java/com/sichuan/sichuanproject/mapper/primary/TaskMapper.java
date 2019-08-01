package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface TaskMapper {

    /**
     * 新增任务
     *
     * @param task
     * @return
     */
    @Insert("insert into task_info(task_number,task_name,task_explain,mark,status) values(#{taskNumber},#{taskName},#{taskExplain},#{mark},#{status})")
    Integer insertTask(Task task);

    /**
     * 更新任务状态
     *
     * @param taskNumber
     * @param status
     * @return
     */
    @Update("update task_info set status=#{status} where task_number=#{taskNumber}")
    int updateTask(@Param(value = "taskNumber") String taskNumber, @Param(value = "status") Integer status);

    /**
     * 获取任务信息
     *
     * @return
     */
    @Select("select * from task_info")
    List<Task> getTasks();

}

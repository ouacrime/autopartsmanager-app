package com.ouacrimecoders.backoffice.autopartsmanager.dao;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface TaskDao extends JpaRepository<Task, Long>{

    @Query("SELECT new com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto(task.id, task.task, task.clientId) FROM Task task")
    List<TaskDto> findAllTaskDtos();

}

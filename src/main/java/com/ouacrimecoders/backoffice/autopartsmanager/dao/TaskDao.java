package com.ouacrimecoders.backoffice.autopartsmanager.dao;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Category;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TaskDao extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    @Query("SELECT new com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto(task.id, task.task, task.clientId,task.dateCreated,task.dateUpdated) FROM Task task")
    List<TaskDto> findAllTaskDtos();
    @Query("SELECT new com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto(task.id, task.task, task.clientId,task.dateCreated,task.dateUpdated) " +
            "FROM Task task " +
            "WHERE (:taskId IS NULL OR task.id = :taskId) " +
            "AND (:task IS NULL OR LOWER(task.task) LIKE LOWER(CONCAT('%', :task, '%'))) " +
            "AND (:clientId IS NULL OR task.clientId = :clientId) " +
            "ORDER BY task.id ASC")
    List<TaskDto> findAllTaskById(@Param("taskId") Long taskId,
                                  @Param("task") String taskName,
                                  @Param("clientId") Long clientId);


}

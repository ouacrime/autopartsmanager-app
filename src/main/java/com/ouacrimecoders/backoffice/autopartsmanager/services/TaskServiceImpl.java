package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.TaskDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.*;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.ClientOrder;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Task;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityAlreadyExistsException;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityServiceException;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.TaskMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService
{
    private final TaskDao taskDao;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        return taskDao.findAllTaskDtos();
    }
    public List<TaskDto> getTasksById(Long taskId, String taskName, Long clientId) {
        return taskDao.findAllTaskById(taskId, taskName, clientId);
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) throws IOException {
        try {
            taskDto.setId(null); // Ensure the ID is null for a new task
            Task savedTask = taskDao.save(taskMapper.dtoToModel(taskDto));
            return taskMapper.modelToDto(savedTask);
        } catch (Exception e) {
            throw new EntityServiceException("An error occurred while adding the Task.", e);
        }
    }

    @Override
    public TaskDto getTaskById(Long id) {
        List<TaskDto> taskDtoList = taskDao.findAllTaskById(id, null, null);
        if (!taskDtoList.isEmpty()) {
            return taskDtoList.get(0);
        } else {
            throw new EntityNotFoundException(String.format("The Task with the id %d is not found.", id));
        }
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        // Retrieve existing task
        TaskDto existingTaskDto = getTaskById(id);

        // Update task details
        existingTaskDto.setTask(taskDto.getTask());
        existingTaskDto.setClientId(taskDto.getClientId());

        // Save updated task
        Task updatedTask = taskDao.save(taskMapper.dtoToModel(existingTaskDto));
        return taskMapper.modelToDto(updatedTask);
    }

    @Override
    public ResponseDto deleteTaskById(Long id) {

        // Delete task from database
        taskDao.deleteById(id);

        return ResponseDto.builder()
                .message("Task successfully deleted.")
                .build();
    }


}

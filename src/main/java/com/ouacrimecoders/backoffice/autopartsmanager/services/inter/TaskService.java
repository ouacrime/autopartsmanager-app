package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.CategoryDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;

import java.io.IOException;
import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();
    TaskDto addTask(TaskDto taskDto) throws IOException;

    TaskDto getTaskById(Long id);


    TaskDto updateTask(Long id, TaskDto taskDto);

    ResponseDto deleteTaskById(Long id);




}

package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.TaskDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService
{
    private final TaskDao task;

    @Override
    public List<TaskDto> getAllTasks() {
        return task.findAllTaskDtos();
    }



}

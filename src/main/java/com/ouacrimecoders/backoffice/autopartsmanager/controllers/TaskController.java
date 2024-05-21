package com.ouacrimecoders.backoffice.autopartsmanager.controllers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Tasks")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class TaskController {
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks()
    {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }



}

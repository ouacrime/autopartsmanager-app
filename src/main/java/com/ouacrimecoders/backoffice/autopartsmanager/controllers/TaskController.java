package com.ouacrimecoders.backoffice.autopartsmanager.controllers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Tasks")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class TaskController {
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok().body(taskService.getTaskById(taskId));
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(
            @RequestBody TaskDto taskDto) throws IOException {
        return ResponseEntity.ok().body(taskService.addTask(taskDto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long taskId) {
        return ResponseEntity.ok().body(taskService.deleteTaskById(taskId));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask
            (@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok().body(taskService.updateTask(taskId, taskDto));
    }


}

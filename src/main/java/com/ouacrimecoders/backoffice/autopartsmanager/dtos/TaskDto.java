package com.ouacrimecoders.backoffice.autopartsmanager.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {

    private Long id;
    private String task;
    private Long clientId;


    public TaskDto(Long id, String task, Long clientId) {
        this.id = id;
        this.task = task;
        this.clientId = clientId;
    }



}

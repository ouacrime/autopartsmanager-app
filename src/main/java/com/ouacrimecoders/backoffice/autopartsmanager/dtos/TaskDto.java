package com.ouacrimecoders.backoffice.autopartsmanager.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
//@NoArgsConstructor
public class TaskDto implements Serializable {

    private Long id;
    private String task;
    private Long clientId;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;


    public TaskDto(){}

    public TaskDto(Long id, String task, Long clientId,LocalDate dateCreated,LocalDate dateUpdated) {
        this.id = id;
        this.task = task;
        this.clientId = clientId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }



}

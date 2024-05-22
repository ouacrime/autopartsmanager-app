package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.TaskDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Task;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface TaskMapper {

    TaskDto modelToDto(Task task);

    List<TaskDto> modelsToDtos(List<Task> taskList);

    Task dtoToModel(TaskDto taskDto);
}

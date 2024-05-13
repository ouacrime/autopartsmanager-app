package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.ClientStatus;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface ClientStatusMapper {
    ClientStatusDto modelToDto(ClientStatus clientStatus);

    List<ClientStatusDto> modelsToDtos(List<ClientStatus> clientStatusList);

    ClientStatus dtoToModel(ClientStatusDto clientStatusDto);
}

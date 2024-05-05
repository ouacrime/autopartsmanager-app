package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientOrderDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.ClientOrder;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface ClientOrderMapper {
    ClientOrderDto modelToDto(ClientOrder clientOrder);

    List<ClientOrderDto> modelsToDtos(List<ClientOrder> clientOrderList);

    ClientOrder dtoToModel(ClientOrderDto clientOrderDto);
}

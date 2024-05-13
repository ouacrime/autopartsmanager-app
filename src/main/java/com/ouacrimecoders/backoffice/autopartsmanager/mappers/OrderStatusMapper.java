package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.OrderStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.OrderStatus;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface OrderStatusMapper {
    OrderStatusDto modelToDto(OrderStatus orderStatus);

    List<OrderStatusDto> modelsToDtos(List<OrderStatus> orderStatusList);

    OrderStatus dtoToModel(OrderStatusDto OrderStatusDto);
}

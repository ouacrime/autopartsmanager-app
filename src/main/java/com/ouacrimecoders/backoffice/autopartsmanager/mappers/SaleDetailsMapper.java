package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDetailsDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.SaleDetails;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface SaleDetailsMapper {
    SaleDetailsDto modelToDto(SaleDetails saleDetails);

    List<SaleDetailsDto> modelsToDtos(List<SaleDetails> saleDetailsList);

    SaleDetails dtoToModel(SaleDetailsDto saleDetailsDto);
}

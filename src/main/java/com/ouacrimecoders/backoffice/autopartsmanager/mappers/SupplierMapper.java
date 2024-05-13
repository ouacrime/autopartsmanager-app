package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SupplierDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Supplier;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface SupplierMapper {
    SupplierDto modelToDto(Supplier supplier);

    List<SupplierDto> modelsToDtos(List<Supplier> supplierList);

    Supplier dtoToModel(SupplierDto supplierDto);

    void updateModelWithDto(SupplierDto dto, @MappingTarget Supplier entity);

}

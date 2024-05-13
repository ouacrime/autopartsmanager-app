package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageProductDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.PackageProduct;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface PackageProductMapper {
    PackageProductDto modelToDto(PackageProduct source);

    List<PackageProductDto> modelsToDtos(List<PackageProduct> sourceList);

    PackageProduct dtoToModel(PackageProductDto imageDto);
}

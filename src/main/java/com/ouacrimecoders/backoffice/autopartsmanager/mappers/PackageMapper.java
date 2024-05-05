package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface PackageMapper {
    PackageDto modelToDto(Package source);

    List<PackageDto> modelsToDtos(List<Package> sourceList);

    Package dtoToModel(PackageDto imageDto);
}

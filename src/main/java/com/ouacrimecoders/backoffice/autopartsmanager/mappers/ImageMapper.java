package com.ouacrimecoders.backoffice.autopartsmanager.mappers;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ImageDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Image;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Component
public interface ImageMapper {
    ImageDto modelToDto(Image image);

    List<ImageDto> modelsToDtos(List<Image> imageList);

    Image dtoToModel(ImageDto imageDto);
}

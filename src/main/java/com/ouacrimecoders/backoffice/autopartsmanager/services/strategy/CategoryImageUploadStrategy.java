package com.ouacrimecoders.backoffice.autopartsmanager.services.strategy;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.ImageDao;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Image;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityAlreadyExistsException;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ImageMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.strategy.inter.ImageUploadStrategy;
import com.ouacrimecoders.backoffice.autopartsmanager.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class CategoryImageUploadStrategy implements ImageUploadStrategy {

    private final ImageDao imageDao;
    private final ImageMapper imageMapper;

    @Override
    public void uploadImage(MultipartFile file, Long categoryId) throws IOException {
        String folderPath = Constants.IMAGE_FOLDER_PATH + "categories/category_" + categoryId + "/";
        String filePath = folderPath + file.getOriginalFilename();

        Optional<Image> existingImage = imageDao.findByFilePath(filePath);
        existingImage.ifPresent(image -> {
            throw new EntityAlreadyExistsException(String.format("This image with name %s already exists", file.getOriginalFilename()));
        });

        Image image = imageDao.save(
                Image.builder()
                        .name(file.getOriginalFilename())
                        .productId(null)
                        .categoryId(categoryId)
                        .type(file.getContentType())
                        .filePath(filePath).build());

        // Create the product's folder if it doesn't exist
        Path path = Paths.get(folderPath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        if (image != null) {
            file.transferTo(new File(filePath));
            //return "file uploaded successfully: " + filePath;
        } else {
            //return "Failed to save image entity.";
        }
    }
}

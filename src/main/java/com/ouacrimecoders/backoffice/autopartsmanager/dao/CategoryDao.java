package com.ouacrimecoders.backoffice.autopartsmanager.dao;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.CategoryDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    @Query("SELECT NEW com.ouacrimecoders.backoffice.autopartsmanager.dtos.CategoryDto(c.id, c.name, c.visbility, i.name, i.filePath) " +
            "FROM Category c " +
            "LEFT JOIN  Image i ON c.id = i.categoryId " +
            "WHERE (:categoryId IS NULL OR c.id = :categoryId) " +
            "AND (:visibility IS NULL OR c.visbility = :visibility) " +
            "AND (:categoryName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :categoryName, '%'))) order by c.id asc ")
    List<CategoryDto> findAllCategoryIdsAndNames(@Param("categoryId") Long categoryId,
                                                 @Param("categoryName") String categoryName,
                                                 @Param("visibility") String visibility
                                                 );

    boolean existsByName(String categoryName);
}

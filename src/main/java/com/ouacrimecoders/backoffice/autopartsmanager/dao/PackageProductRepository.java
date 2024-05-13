package com.ouacrimecoders.backoffice.autopartsmanager.dao;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageProductDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.PackageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageProductRepository extends JpaRepository<PackageProduct, Long>, JpaSpecificationExecutor<PackageProduct> {
@Query(value = "select new com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageProductDto(" +
        " packageProduct.id,packageProduct.packageId,packageProduct.productId,packageProduct.dateCreation," +
        "packageProduct.userCreation,packageProduct.dateUpdate,packageProduct.userUpdate)" +
        " from PackageProduct packageProduct " +
        "where (:id is null or packageProduct.id=:id ) " +
        "and (:productId is null or packageProduct.productId=:productId )"+
        "and (:packageId is null or packageProduct.packageId=:packageId )"
)
public List<PackageProductDto> getAllServiceOptionByQuery(
        @Param("id") Long id,
        @Param("packageId") Long packageId,
        @Param("productId") Long serviceOptionId
);
}

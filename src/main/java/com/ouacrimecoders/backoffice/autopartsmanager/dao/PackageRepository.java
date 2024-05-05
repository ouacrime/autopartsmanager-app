 package com.ouacrimecoders.backoffice.autopartsmanager.dao;

 import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageDto;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;

 import java.util.List;

 @Repository
public interface PackageRepository extends JpaRepository<Package, Long>, JpaSpecificationExecutor<Package> {
@Query(value = "select new com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageDto(" +
        "package.id ,package.name,package.description,package.dateCreation,package.userCreation," +
        "package.dateUpdate, package.userUpdate,package.price,package.active)" +
        " from Package package" +
         " where (:packageId is null or package.id=:packageId) " +
        " and (:active is null or package.active=:active) " +
        " and (:name is null or package.name like %:name% )")
     List<PackageDto> getAllPackageByQuery(
             @Param("packageId") Long packageId ,
             @Param("name") String  name,
             @Param("active") String  active

);
}

package com.ouacrimecoders.backoffice.autopartsmanager.dao;



import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDetailsDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailsDao extends JpaRepository<SaleDetails, Long>, JpaSpecificationExecutor<SaleDetails> {
    @Query(value = "select new com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDetailsDto(" +
            " saleDetails.id, saleDetails.productId, saleDetails.productQuantity, saleDetails.saleId, " +
            "saleDetails.dateCreation, saleDetails.dateUpdate)" +
            " FROM SaleDetails saleDetails " +
            " WHERE (:id IS NULL OR saleDetails.id = :id)" +
            "AND (:saleId IS NULL OR saleDetails.saleId = :saleId) ")
    List<SaleDetailsDto> getSaleDetailsByQuery(
            @Param("id") Long id,
            @Param("saleId") Long saleId
    );
}

package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.criteria.SaleDetailsCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDetailsDto;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;

import java.util.List;

public interface SaleDetailsService {
    List<SaleDetailsDto> findSaleDetailsByCriteria(SaleDetailsCriteria saleDetailsCriteria) throws EntityNotFoundException;

    SaleDetailsDto findSaleDetailsById(Long id) throws EntityNotFoundException;

    SaleDetailsDto persistSaleDetails(SaleDetailsDto saleDetailsDto) throws EntityNotFoundException;

    SaleDetailsDto updatesaleDetails(Long id, SaleDetailsDto saleDetailsDto) throws EntityNotFoundException;

    ResponseDto deleteSaleDetailsById(Long id) throws EntityNotFoundException;
}

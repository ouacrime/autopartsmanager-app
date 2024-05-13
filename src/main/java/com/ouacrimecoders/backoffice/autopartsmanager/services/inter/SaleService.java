package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.criteria.SaleCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDto;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;

import java.util.List;

public interface SaleService {
    public List<SaleDto> findsalesByCriteria(SaleCriteria saleCriteria) throws EntityNotFoundException;
    public SaleDto findsalesById(Long id) throws EntityNotFoundException;
    public SaleDto persistsales(SaleDto saleDto) throws EntityNotFoundException ;
    public SaleDto updatesales(Long id, SaleDto saleDto) throws EntityNotFoundException  ;
    public ResponseDto deletesalesById(Long id) throws EntityNotFoundException ;

    SaleDto modifySaleDtoStatusToAccepted(Long saleId);

    SaleDto modifySaleDtoStatusToReported(Long saleId);

    SaleDto modifySaleDtoStatusToCancelled(Long saleId);
}

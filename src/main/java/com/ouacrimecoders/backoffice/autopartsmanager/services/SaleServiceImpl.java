package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.criteria.SaleCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dao.SaleDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Sale;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.SaleMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.SaleService;
import com.ouacrimecoders.backoffice.autopartsmanager.utils.OrderStatusIds;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleDao saleDao;

    private final SaleMapper saleMapper;
    private final ProductServiceImpl productService;

    public List<SaleDto> findsalesByCriteria(SaleCriteria saleCriteria) throws EntityNotFoundException {
        return saleDao.getSalesByQuery(saleCriteria.getId(), saleCriteria.getSaleStatusId());
    }

    @Override
    public SaleDto findsalesById(Long id) throws EntityNotFoundException {
        SaleCriteria saleCriteria = new SaleCriteria();
        saleCriteria.setId(id);
        List<SaleDto> saleDtoList = findsalesByCriteria(saleCriteria);
        if (saleDtoList != null && !saleDtoList.isEmpty()) {
            return saleDtoList.get(0);
        } else {
            throw new EntityNotFoundException("The sale with the id " + id + "  is not found.");
        }
    }

    @Override
    public SaleDto persistsales(SaleDto saleDto) throws EntityNotFoundException {
        saleDto.setId(null);
        saleDto.setSaleStatusId(OrderStatusIds.IN_PROGRESS);
        return saleMapper.modelToDto(saleDao.save(saleMapper.dtoToModel(saleDto)));
    }

    @Override
    public SaleDto updatesales(Long id, SaleDto saleDto) throws EntityNotFoundException {
        SaleDto saleDto1 = findsalesById(id);
        saleDto1.setId(id);
        saleDto1.setDateUpdate(LocalDateTime.now());
        return saleMapper.modelToDto(saleDao.save(saleMapper.dtoToModel(saleDto1)));
    }

    @Override
    public ResponseDto deletesalesById(Long id) throws EntityNotFoundException {
        ResponseDto responseDto = new ResponseDto();
        findsalesById(id);
        // dans la supprission de vente si la vente est payer c'est bon si la vente est annuler il faut augmenter la quantite de produit
        //mais je prefere de metre des api pour l'annulation des produit
        saleDao.deleteById(id);
        responseDto.setMessage("Sale is successfully deleted!");
        return responseDto;
    }


    private Sale retrieveSaleById(Long saleId) {
        return saleDao.findById(saleId)
                .orElseThrow(() -> new RuntimeException(String.format("The sale with id %d not found.", saleId)));
    }

    @Override
    public SaleDto modifySaleDtoStatusToAccepted(Long saleId) {
        try {
            Sale sale = retrieveSaleById(saleId);
            sale.setSaleStatusId(OrderStatusIds.ACCEPTED);
            return saleMapper.modelToDto(saleDao.save(sale));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying sale status to accepted.", e);

        }
    }

    @Override
    public SaleDto modifySaleDtoStatusToReported(Long saleId) {
        try {
            Sale sale = retrieveSaleById(saleId);
            sale.setSaleStatusId(OrderStatusIds.REPORTED);
            return saleMapper.modelToDto(saleDao.save(sale));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying sale status to reported.", e);
        }
    }

    @Override
    public SaleDto modifySaleDtoStatusToCancelled(Long saleId) {
        try {
            Sale sale = retrieveSaleById(saleId);
            sale.setSaleStatusId(OrderStatusIds.CANELLED);
            return saleMapper.modelToDto(saleDao.save(sale));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying sale status to cancelled.", e);
        }
    }
}

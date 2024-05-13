package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.UpsellDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Upsell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;


public interface UpsellService {
    Page<Upsell> getUpsells(Pageable pageable);
    // Method to search Upsells by productId
    Page<UpsellDto> searchUpsellsByProductId(Long productId, Pageable pageable);

    // Method to search Upsells by packageId
    Page<UpsellDto> searchUpsellsByPackageId(Long packageId, Pageable pageable);

    UpsellDto getUpsellById(Long id);

    UpsellDto addUpsell(UpsellDto upsellDto) throws IOException;

    UpsellDto updateUpsell(Long id, UpsellDto upsellDto);

    ResponseDto deleteUpsellById(Long id);
}

package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SupplierProductDto;

import java.io.IOException;
import java.util.List;

public interface SupplierProductService {
    List<SupplierProductDto> getAllSupplierProduct();

    SupplierProductDto getSupplierProductById(Long id);
    SupplierProductDto getSupplierProductBySupplierId(Long supplierId);

    SupplierProductDto addSupplierProduct(SupplierProductDto supplierProductDto) throws IOException;

    SupplierProductDto updateSupplierProduct(Long id, SupplierProductDto supplierProductDto);

    ResponseDto deleteSupplierProductById(Long id);
}

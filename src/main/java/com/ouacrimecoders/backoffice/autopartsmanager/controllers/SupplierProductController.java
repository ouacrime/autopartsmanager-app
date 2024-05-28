package com.ouacrimecoders.backoffice.autopartsmanager.controllers;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SupplierProductDto;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.SupplierProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/supplierProducts")
@RequiredArgsConstructor
public class SupplierProductController {
    private final SupplierProductService supplierProductService;

    @GetMapping
    public ResponseEntity<List<SupplierProductDto>> getSupplierProducts() {

        return ResponseEntity.ok().body(supplierProductService.getAllSupplierProduct());
    }

    @GetMapping("/{supplierProductId}")
    public ResponseEntity<SupplierProductDto> getSupplierProductById(@PathVariable Long supplierProductId) {
        return ResponseEntity.ok().body(supplierProductService.getSupplierProductById(supplierProductId));
    }

    @GetMapping("/by-supplier/{supplierId}")
    public ResponseEntity<SupplierProductDto> getSupplierProductBySupplierId(@PathVariable Long supplierId) {
        return ResponseEntity.ok().body(supplierProductService.getSupplierProductBySupplierId(supplierId));
    }

    @PostMapping
    public ResponseEntity<SupplierProductDto> addSupplierProduct(
            @RequestBody SupplierProductDto supplierProductDto) throws IOException {
        return ResponseEntity.ok().body(supplierProductService.addSupplierProduct(supplierProductDto));
    }


    @PutMapping("/{supplierProductId}")
    public ResponseEntity<SupplierProductDto> updateSupplierProduct(@PathVariable Long supplierProductId, @RequestBody SupplierProductDto supplierProductDto) {
        return ResponseEntity.ok().body(supplierProductService.updateSupplierProduct(supplierProductId, supplierProductDto));
    }

    @DeleteMapping("/{supplierProductId}")
    public ResponseEntity<?> deleteSupplierProductById(@PathVariable Long supplierProductId) {
        return ResponseEntity.ok().body(supplierProductService.deleteSupplierProductById(supplierProductId));
    }
}

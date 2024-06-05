package com.ouacrimecoders.backoffice.autopartsmanager.controllers;

import com.ouacrimecoders.backoffice.autopartsmanager.criteria.SaleCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SaleDto;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:58213", allowCredentials = "true")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<?> findSalesByCriteria(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "saleStatusId", required = false) Long saleStatusId
    ) throws EntityNotFoundException {
        SaleCriteria salesCriteria = SaleCriteria.builder().
                id(id).
                saleStatusId(saleStatusId).
                build();

        return ResponseEntity.ok(saleService.findsalesByCriteria(salesCriteria));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findSalesById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(saleService.findsalesById(id));
    }

    @PostMapping
    public ResponseEntity<?> persistSales(@RequestBody SaleDto salesDto) throws EntityNotFoundException {
        return ResponseEntity.ok(saleService.persistsales(salesDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateSales(@PathVariable Long id, @RequestBody SaleDto salesDto) throws EntityNotFoundException {
        return ResponseEntity.ok(saleService.updatesales(id, salesDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSalesById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(saleService.deletesalesById(id));
    }

    @PatchMapping("/{saleId}/accepted")
    public ResponseEntity<SaleDto> modifySaleStatusToAccepted(@PathVariable Long saleId) throws EntityNotFoundException {
        SaleDto updatedSale = saleService.modifySaleDtoStatusToAccepted(saleId);
        return ResponseEntity.ok(updatedSale);
    }

    @PatchMapping("/{saleId}/reported")
    public ResponseEntity<SaleDto> modifySaleStatusToReported(@PathVariable Long saleId) throws EntityNotFoundException {
        SaleDto updatedSale = saleService.modifySaleDtoStatusToReported(saleId);
        return ResponseEntity.ok(updatedSale);
    }

    @PatchMapping("/{saleId}/cancelled")
    public ResponseEntity<SaleDto> modifySaleStatusToCancelled(@PathVariable Long saleId) throws EntityNotFoundException {
        SaleDto updatedSale = saleService.modifySaleDtoStatusToCancelled(saleId);
        return ResponseEntity.ok(updatedSale);
    }


}


package com.ouacrimecoders.backoffice.autopartsmanager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierProductDto implements Serializable {
    private Long id;
    private Long productId;
    private Long supplierId;
    private Double price;
    private Integer quantity;
}

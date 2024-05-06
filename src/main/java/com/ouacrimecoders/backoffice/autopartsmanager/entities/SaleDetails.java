package com.ouacrimecoders.backoffice.autopartsmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "sale_id")
    private Long saleId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "package_id")
    private Long packageId;
    @Column(name = "package_quantity")
    private Long packageQuantity;
    @Column(name = "product_quantity")
    private Long productQuantity;

    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Product  product;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Sale  sale;

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Packagee pPackage;
}

package com.ouacrimecoders.backoffice.autopartsmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENT_ORDER_ID")
    private Long clientOrderId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    private Double price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ORDER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private ClientOrder clientOrder;
}

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
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String address;
    private String phone;
    private String email;
    private String saleStatus;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private Double totalPrice;
    @Column(name = "SALE_STATUS_ID")
    private Long saleStatusId;

    @ManyToOne
    @JoinColumn(name = "SALE_STATUS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private OrderStatus orderStatus;
}

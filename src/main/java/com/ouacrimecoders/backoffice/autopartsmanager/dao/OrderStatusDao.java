package com.ouacrimecoders.backoffice.autopartsmanager.dao;

import com.ouacrimecoders.backoffice.autopartsmanager.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusDao extends JpaRepository<OrderStatus, Long> {
}

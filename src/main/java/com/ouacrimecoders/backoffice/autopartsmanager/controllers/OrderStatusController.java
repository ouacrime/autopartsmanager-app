package com.ouacrimecoders.backoffice.autopartsmanager.controllers;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.OrderStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.OrderStatusMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderStatuses")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:58213", allowCredentials = "true")
public class OrderStatusController {
    private OrderStatusService orderStatusService;
    private OrderStatusMapper orderStatusMapper;

    @GetMapping
    public ResponseEntity<List<OrderStatusDto>> getOrderStatuses(
    ) {
        return ResponseEntity.ok().body(orderStatusService.getOrderStatus());
    }
}

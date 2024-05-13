package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.OrderStatusDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.OrderStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.OrderStatusMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusDao orderStatusDao;
    private final OrderStatusMapper orderStatusMapper;

    @Override
    public List<OrderStatusDto> getOrderStatus() {
        return orderStatusMapper.modelsToDtos(orderStatusDao.findAll());
    }
}

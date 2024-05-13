package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.OrderStatusDto;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatusDto> getOrderStatus();

}

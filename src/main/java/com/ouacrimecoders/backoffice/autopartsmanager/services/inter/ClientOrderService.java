package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientOrderDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface ClientOrderService {
    List<ClientOrderDto> getClientOrdersByQuery(Long orderId, Long clientId, Long orderStatusId, LocalDateTime dateCreation, LocalDateTime dateUpdate);

    ClientOrderDto getClientOrderById(Long id);

    ClientOrderDto addClientOrder(ClientOrderDto clientOrderDto) throws IOException;

    ClientOrderDto updateClientOrder(Long id, ClientOrderDto clientOrderDto);

    ResponseDto deleteClientOrderById(Long id);

    ClientOrderDto modifyClientOrderDtoStatusToAccepted(Long clientOrderId);

    ClientOrderDto modifyClientOrderDtoStatusToReported(Long clientOrderId);

    ClientOrderDto modifyClientOrderDtoStatusToCancelled(Long clientOrderId);
}

package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.ClientOrderDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientOrderDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.ClientOrder;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ClientOrderMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.ClientOrderService;
import com.ouacrimecoders.backoffice.autopartsmanager.utils.OrderStatusIds;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientOrderServiceImpl implements ClientOrderService {
    private final ClientOrderDao clientOrderDao;
    private final ClientOrderMapper clientOrderMapper;

    @Override
    public List<ClientOrderDto> getClientOrdersByQuery(Long orderId, Long clientId, Long orderStatusId, LocalDateTime dateCreation, LocalDateTime dateUpdate) {
        return clientOrderDao.findAllClientOrders(orderId, clientId, dateCreation, dateUpdate, orderStatusId);
    }

    @Override
    public ClientOrderDto getClientOrderById(Long id) {
        List<ClientOrderDto> clientOrderDtoList = clientOrderDao.findAllClientOrders(id, null, null, null, null);
        return clientOrderDtoList.stream()
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("The clientOrder with the id %d is not found.", id)));
    }

    @Override
    public ClientOrderDto addClientOrder(ClientOrderDto clientOrderDto) throws IOException {
        clientOrderDto.setId(null);
        clientOrderDto.setClientOrderStatusId(OrderStatusIds.IN_PROGRESS);
        return clientOrderMapper.modelToDto(clientOrderDao.save(clientOrderMapper.dtoToModel(clientOrderDto)));
    }

    @Override
    public ClientOrderDto updateClientOrder(Long id, ClientOrderDto clientOrderDto) {
        ClientOrderDto oldClientOrderDto = getClientOrderById(id);
        clientOrderDto.setId(oldClientOrderDto.getId());
        ClientOrder updatedClientOrder = clientOrderDao.save(clientOrderMapper.dtoToModel(clientOrderDto));
        return clientOrderMapper.modelToDto(updatedClientOrder);
    }

    @Override
    public ResponseDto deleteClientOrderById(Long id) {
        getClientOrderById(id);
        clientOrderDao.deleteById(id);
        return ResponseDto.builder()
                .message("ClientOrder successfully deleted.")
                .build();
    }

    private ClientOrder retrieveClientOrderById(Long clientOrderId) {
        return clientOrderDao.findById(clientOrderId)
                .orElseThrow(() -> new RuntimeException(String.format("The clientOrder with id %d not found.", clientOrderId)));
    }

    @Override
    public ClientOrderDto modifyClientOrderDtoStatusToAccepted(Long clientOrderId) {
        try {
            ClientOrder clientOrder = retrieveClientOrderById(clientOrderId);
            clientOrder.setClientOrderStatusId(OrderStatusIds.ACCEPTED);
            return clientOrderMapper.modelToDto(clientOrderDao.save(clientOrder));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying clientOrder status to accepted.", e);

        }
    }

    @Override
    public ClientOrderDto modifyClientOrderDtoStatusToReported(Long clientOrderId) {
        try {
            ClientOrder clientOrder = retrieveClientOrderById(clientOrderId);
            clientOrder.setClientOrderStatusId(OrderStatusIds.REPORTED);
            return clientOrderMapper.modelToDto(clientOrderDao.save(clientOrder));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying clientOrder status to reported.", e);
        }
    }

    @Override
    public ClientOrderDto modifyClientOrderDtoStatusToCancelled(Long clientOrderId) {
        try {
            ClientOrder clientOrder = retrieveClientOrderById(clientOrderId);
            clientOrder.setClientOrderStatusId(OrderStatusIds.CANELLED);
            return clientOrderMapper.modelToDto(clientOrderDao.save(clientOrder));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while modifying clientOrder status to cancelled.", e);
        }
    }
}

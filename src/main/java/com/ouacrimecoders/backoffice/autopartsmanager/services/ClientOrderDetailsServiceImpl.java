package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.ClientOrderDetailsDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientOrderDetailsDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ClientOrderDetailsMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.ClientOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientOrderDetailsServiceImpl implements ClientOrderDetailsService {
    private final ClientOrderDetailsDao clientOrderDetailsDao;
    private final ClientOrderDetailsMapper clientOrderDetailsMapper;

    @Override
    public List<ClientOrderDetailsDto> getClientOrderDetailsByQuery(Long orderId) {
        return clientOrderDetailsDao.findAllClientOrderDetails(orderId);
    }

    @Override
    public ClientOrderDetailsDto addClientOrderDetails(ClientOrderDetailsDto clientOrderDetailsDto) throws IOException {
        clientOrderDetailsDto.setId(null);
        return clientOrderDetailsMapper.modelToDto(clientOrderDetailsDao.save(clientOrderDetailsMapper.dtoToModel(clientOrderDetailsDto)));
    }

    @Override
    public ResponseDto deleteClientOrderDetailsById(Long id) {
        clientOrderDetailsDao.deleteById(id);
        return ResponseDto.builder()
                .message("ClientOrderDetailsController successfully deleted.")
                .build();
    }
}

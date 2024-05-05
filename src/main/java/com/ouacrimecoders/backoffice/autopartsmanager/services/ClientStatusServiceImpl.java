package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.ClientStatusDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ClientStatusMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.ClientStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientStatusServiceImpl implements ClientStatusService {
    private final ClientStatusDao clientStatusDao;
    private final ClientStatusMapper clientStatusMapper;

    @Override
    public List<ClientStatusDto> getClientStatus() {
        return clientStatusMapper.modelsToDtos(clientStatusDao.findAll());
    }
}

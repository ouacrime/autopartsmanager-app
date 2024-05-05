package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;


import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientStatusDto;

import java.util.List;

public interface ClientStatusService {
    List<ClientStatusDto> getClientStatus();

}

package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientOrderDetailsDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;

import java.io.IOException;
import java.util.List;

public interface ClientOrderDetailsService {
    List<ClientOrderDetailsDto> getClientOrderDetailsByQuery(Long orderId);

    ClientOrderDetailsDto addClientOrderDetails(ClientOrderDetailsDto clientOrderDetailsDto) throws IOException;

    ResponseDto deleteClientOrderDetailsById(Long id);
}

package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    List<ClientDto> getClientsByQuery(Long clientId, String firstName, String lastName, String email, String phoneNumber, Long statusId);

    ClientDto getClientById(Long id);

    ClientDto addClient(ClientDto clientDto, String token) throws IOException;

    ClientDto updateClient(Long id, ClientDto clientDto);

    ResponseDto deleteClientById(Long id, String token);
}

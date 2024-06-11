package com.ouacrimecoders.backoffice.autopartsmanager.services;


import com.ouacrimecoders.backoffice.autopartsmanager.dao.ClientDao;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SecurityUserDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Client;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Role;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityAlreadyExistsException;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ClientMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.ClientService;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.SecurityUsersProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final ClientMapper clientMapper;
    private final SecurityUsersProviderService securityUsersProviderService;
    @Value("${myKeycloak.client.default-role-id}")
    private String defaultRoleId;
    @Value("${myKeycloak.client.default-role-name}")
    private String defaultRoleName;

    @Override
    public List<ClientDto> getClientsByQuery(Long clientId, String firstName, String lastName,
                                             String email, String phoneNumber, Long statusId) {
        return clientDao.findAllClients(clientId, firstName, lastName, email, phoneNumber, statusId);
    }

    @Override
    public ClientDto getClientById(Long id) {
        List<ClientDto> clientDtoList = clientDao.findAllClients(id, null, null, null, null, null);
        return clientDtoList.stream()
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("The client with the id %d is not found.", id)));
    }

    @Override
    public ClientDto addClient(ClientDto clientDto, String token) throws IOException {
        if (clientDao.existsByEmailAndPhoneNumber(clientDto.getEmail(), clientDto.getPhoneNumber())) {
            throw new EntityAlreadyExistsException(String.format("The client with the email %s and phone number is already exists", clientDto.getEmail(), clientDto.getPhoneNumber()));
        }
        clientDto.setId(null);
        // Save client in database
        ClientDto savedClientDto = clientMapper.modelToDto(clientDao.save(clientMapper.dtoToModel(clientDto)));

        createKeycloakUser(clientDto, token);

        // Return the saved client DTO
        return savedClientDto;
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        ClientDto oldClientDto = getClientById(id);
        clientDto.setId(oldClientDto.getId());
        Client updatedClient = clientDao.save(clientMapper.dtoToModel(clientDto));
        return clientMapper.modelToDto(updatedClient);
    }

    @Override
    public ResponseDto deleteClientById(Long id, String token) {
        ClientDto clientDto = getClientById(id);
        token = "null";
        SecurityUserDto securityUserDto = securityUsersProviderService.getUserByUsername(clientDto.getEmail(), token);
         //Delete client from Keycloak
        securityUsersProviderService.deleteUserById(securityUserDto.getId(), token);

        // Delete client from database
        clientDao.deleteById(id);

        return ResponseDto.builder()
                .message("Client successfully deleted.")
                .build();

    }

    // Helper method to create a user in Keycloak
    private SecurityUserDto createKeycloakUser(ClientDto clientDto, String token) {
        SecurityUserDto user = new SecurityUserDto();
        user.setUsername(clientDto.getEmail()); // Use email as username
        user.setFirstName(clientDto.getFirstName());
        user.setLastName(clientDto.getLastName());
        user.setEnabled(true); // Enable user by default

        user = securityUsersProviderService.addUser(user, token);
        // Assign default role to client (default role is client you have to specify it in yml or properties file)
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder()
                .id(defaultRoleId)
                .name(defaultRoleName)
                .build());
        securityUsersProviderService.assignRoleToUser(user.getId(), roles, token);

        // Add user to Keycloak
        return user;
    }
}

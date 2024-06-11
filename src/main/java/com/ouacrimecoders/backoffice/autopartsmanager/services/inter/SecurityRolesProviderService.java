package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Role;

import java.util.List;

public interface SecurityRolesProviderService {
    List<Role> getAllRoles(String accessToken);

    Role getRoleByName(String name, String token);

    Role addRole(Role role, String token);

    ResponseDto deleteRoleByName(String name, String token);

}

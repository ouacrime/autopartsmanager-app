package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.LoginResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.SecurityUserDto;
import com.ouacrimecoders.backoffice.autopartsmanager.entities.Role;

import java.util.List;

public interface SecurityUsersProviderService {
    List<SecurityUserDto> getAllUsers(String accessToken);

    SecurityUserDto getUserByUsername(String username, String token);

    SecurityUserDto getUserById(String id, String token);

    SecurityUserDto addUser(SecurityUserDto user, String token);

    ResponseDto updateUser(SecurityUserDto user, String id, String token);

    ResponseDto deleteUserById(String id, String token);

    LoginResponseDto login(String grantType, String clientId, String username, String password);

    ResponseDto logout(String token, String clientId, String refreshToken);

    ResponseDto assignRoleToUser(String userId, List<Role> roles, String token);
}

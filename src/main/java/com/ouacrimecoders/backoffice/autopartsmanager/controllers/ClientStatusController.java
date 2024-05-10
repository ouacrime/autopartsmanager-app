package com.ouacrimecoders.backoffice.autopartsmanager.controllers;

import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ClientStatusDto;
import com.ouacrimecoders.backoffice.autopartsmanager.mappers.ClientStatusMapper;
import com.ouacrimecoders.backoffice.autopartsmanager.services.inter.ClientStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientStatuses")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:58213", allowCredentials = "true")
public class ClientStatusController {
    private ClientStatusService clientStatusService;
    private ClientStatusMapper clientStatusMapper;

    @GetMapping
    public ResponseEntity<List<ClientStatusDto>> getClientStatuses(
    ) {
        return ResponseEntity.ok().body(clientStatusService.getClientStatus());
    }
}

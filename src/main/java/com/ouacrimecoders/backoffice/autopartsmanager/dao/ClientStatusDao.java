package com.ouacrimecoders.backoffice.autopartsmanager.dao;

import com.ouacrimecoders.backoffice.autopartsmanager.entities.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientStatusDao extends JpaRepository<ClientStatus, Long> {
}

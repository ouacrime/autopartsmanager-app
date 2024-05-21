package com.ouacrimecoders.backoffice.autopartsmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Task  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TASK")
    private String task;

    @Column(name = "CLIENT_ID")
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Client client;

}

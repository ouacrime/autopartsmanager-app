package com.ouacrimecoders.backoffice.autopartsmanager.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate dateCreated;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate dateUpdated;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Client client;

}

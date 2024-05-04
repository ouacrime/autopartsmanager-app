package com.ouacrimecoders.backoffice.autopartsmanager.entities.another;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long employeeId;
        private String name;
        private String username;
        private String password;

}

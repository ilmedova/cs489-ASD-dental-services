package org.example.dentalmanagement.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long patientId;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Address> addressList = new ArrayList<>();
}

package org.example.dentalmanagement.entity.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long addressId;
    private String city;
    private String street;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}

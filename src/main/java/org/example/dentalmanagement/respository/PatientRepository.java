package org.example.dentalmanagement.respository;

import org.example.dentalmanagement.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByOrderByLastNameAsc();
    List<Patient> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}

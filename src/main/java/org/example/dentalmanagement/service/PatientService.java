package org.example.dentalmanagement.service;

import org.example.dentalmanagement.entity.dto.PatientDTO;
import org.example.dentalmanagement.entity.dto.PatientRequestDTO;
import org.example.dentalmanagement.entity.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public List<PatientDTO> getAllPatients();
    public PatientDTO getPatientById(Long id) ;
    public PatientDTO addPatient(PatientRequestDTO patientRequestDTO);
    public PatientDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO);
    public void deletePatient(Long id);
    public List<PatientDTO> searchPatients(String searchString);
}

package org.example.dentalmanagement.service.impl;

import org.example.dentalmanagement.entity.dto.PatientDTO;
import org.example.dentalmanagement.entity.dto.PatientRequestDTO;
import org.example.dentalmanagement.entity.model.Patient;
import org.example.dentalmanagement.exceptions.ResourceNotFoundException;
import org.example.dentalmanagement.respository.PatientRepository;
import org.example.dentalmanagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAllByOrderByLastNameAsc();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
        return modelMapper.map(patient, PatientDTO.class);
    }

    public PatientDTO addPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = modelMapper.map(patientRequestDTO, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }

    public PatientDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));

        modelMapper.map(patientRequestDTO, existingPatient); // Updates existingPatient with fields from patientRequestDTO
        Patient updatedPatient = patientRepository.save(existingPatient);
        return modelMapper.map(updatedPatient, PatientDTO.class);
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
        patientRepository.delete(patient);
    }

    public List<PatientDTO> searchPatients(String searchString) {
        List<Patient> patients = patientRepository.findByFirstNameContainingOrLastNameContaining(searchString, searchString);
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
}

package org.example.dentalmanagement.controller;

import org.example.dentalmanagement.entity.dto.AddressDTO;
import org.example.dentalmanagement.entity.dto.PatientDTO;
import org.example.dentalmanagement.entity.dto.PatientRequestDTO;
import org.example.dentalmanagement.service.AddressService;
import org.example.dentalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/get/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/register")
    public PatientDTO registerPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.addPatient(patientRequestDTO);
    }

    @PutMapping("/update/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.updatePatient(id, patientRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/search/{searchString}")
    public List<PatientDTO> searchPatients(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }
}

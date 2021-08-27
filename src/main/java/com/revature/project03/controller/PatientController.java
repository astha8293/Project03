package com.revature.project03.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project03.entity.Patient;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.repository.PatientRepository;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")

public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
   
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Integer patientId)
        throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(patientId)
          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
        return ResponseEntity.ok().body(patient);
    }
    
    @PostMapping("/patients")
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Integer patientId,
         @Valid @RequestBody Patient patientDetails) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

        patient.setEmail_id(patientDetails.getEmail_id());
        patient.setLastName(patientDetails.getLastName());
        patient.setFirstName(patientDetails.getFirstName());
        patient.setAge(patientDetails.getAge());
        patient.setAddress(patientDetails.getAddress());
        patient.setGender(patientDetails.getGender());
        patient.setMobileNo(patientDetails.getMobileNo());
        final Patient updatedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/patients/{id}")
    public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Integer patientId)
         throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(patientId)
       .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

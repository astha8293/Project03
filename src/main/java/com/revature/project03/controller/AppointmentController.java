package com.revature.project03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project03.entity.Appointment;
import com.revature.project03.entity.Family;
import com.revature.project03.entity.Patient;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.repository.AppointmentRepositry;
import com.revature.project03.repository.FamilyRepository;
import com.revature.project03.repository.PatientRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentRepositry appointmentRepositry;
	
	@Autowired
	private PatientRepository patientRepository;
     
//	@PostMapping("{patientid}/family/addmember")
//	public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable(value = "patientid") Integer patientId) throws ResourceNotFoundException {
//		Patient patient = patientRepository.findById(patientId)
//		          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
//		familyMember.setPatient(patient);
//		return familyRepository.save(familyMember);
//	}
	
	@PostMapping("/{patientid}/add")
	public  Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable(value = "patientid") Integer patientId) throws ResourceNotFoundException {
		Patient patient = patientRepository.findById(patientId)
		          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		appointment.setPatient(patient);
		return appointmentRepositry.save(appointment);
	}
	
	
}

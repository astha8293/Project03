package com.revature.project03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.project03.entity.Appointment;
import com.revature.project03.entity.Family;
import com.revature.project03.entity.Patient;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.repository.AppointmentRepositry;
import com.revature.project03.repository.FamilyRepository;
import com.revature.project03.repository.PatientRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepositry appointmentRepositry;	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public Appointment createAppointment(Appointment appointment, int patientId) throws ResourceNotFoundException {
		Patient patient = patientRepository.findById(patientId)
		          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		appointment.setPatient(patient);
		return appointmentRepositry.save(appointment);
	}

}

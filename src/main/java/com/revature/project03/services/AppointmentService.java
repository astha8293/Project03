package com.revature.project03.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.project03.entity.Appointment;
import com.revature.project03.entity.Family;
import com.revature.project03.entity.Patient;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.repository.AppointmentRepositry;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepositry appointmentRepository;	
	@Autowired
	private PatientService patientservice;
	
	
	public Appointment createAppointment(Appointment appointment, int patientId) throws ResourceNotFoundException {
		Patient patient =patientservice.getPatientById(patientId);
		appointment.setPatient(patient);
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getAppointmentByPatientId(int patientId) throws ResourceNotFoundException {
		
		Patient patient =patientservice.getPatientById(patientId);
		List<Appointment> appointment=patient.getAppointment();	
		return appointment;
	}
	
	public List<Appointment> getAppointmentByFamilyId(int familyId) throws ResourceNotFoundException {
		
		Family family =patientservice.getFamilyMemberById(familyId);
		List<Appointment> appointment=family.getAppointment();
		// use getAppointmentByDate(Appointment appt) to get current appointment
		return appointment;
	}

	public Appointment getAppointmentByDate(Appointment appt) {
		Appointment appointment = appointmentRepository.findByapplicationDate(appt.getApplicationDate());
//		          .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + date));
		return appointment;
	}

}

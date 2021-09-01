package com.revature.project03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project03.entity.Appointment;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.services.AppointmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
     
	@PostMapping("/{patientid}/book")
	public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable(value = "patientid") Integer patientId) throws ResourceNotFoundException {
		
		return appointmentService.createAppointment(appointment, patientId);
	}
	
	
}

package com.revature.project03.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project03.entity.Appointment;

public interface AppointmentRepositry extends JpaRepository<Appointment, Integer>{
	
	public Appointment findByapplicationDate(Date date);
}

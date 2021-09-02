package com.revature.project03.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Appointment_table")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_generator")
	@SequenceGenerator(name="app_generator", sequenceName = "app_seq")
	private Long id;

	private int applicationId;
	
	private Date applicationDate;
	private String purpose;
	private String availability;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="p_id")
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="family_id")
	private Family member;
	
	
	
//	@OneToMany(cascade= CascadeType.ALL,mappedBy="doctor")
//	@ManyToOne
//	@JoinColumn(name="doctorId")
//	@Column(name="doctor")
//	private Doctor doctor;
	
     

	
//	@ManyToMany
//	@Column(name="family")
//	private List<Family> family=new ArrayList<Family>();
	
//	@ManyToOne
//	@JoinColumn(name = "rId")
//	private Receptionist receptionist;
	
	
}


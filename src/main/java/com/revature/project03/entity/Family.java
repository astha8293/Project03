package com.revature.project03.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Family")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Max(8)
	private int family_id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String mobileNo;
	private String address;
	private String email_id;
	
	@ManyToOne
	@JoinColumn(name="p_id")
	private Patient patient;
}

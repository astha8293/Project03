package com.revature.project03.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int p_id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private String mobileNo;
	private String address;
	private String email_id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "patient")
	private List<Family> members=new ArrayList<>();


	
}

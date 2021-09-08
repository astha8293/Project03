
	package com.revature.project03;

	import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.junit.jupiter.MockitoExtension;
	import org.springframework.http.MediaType;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.MvcResult;
	import org.springframework.test.web.servlet.RequestBuilder;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;

	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.revature.project03.controller.AppointmentController;
import com.revature.project03.controller.DoctorController;
import com.revature.project03.controller.LoginController;
import com.revature.project03.controller.PatientController;
import com.revature.project03.entities.Admin;
import com.revature.project03.entities.Appointment;
	import com.revature.project03.entities.Doctor;
	import com.revature.project03.entities.Family;
import com.revature.project03.entities.LoginRoute;
import com.revature.project03.entities.Patient;
import com.revature.project03.entities.Prescriptions;
import com.revature.project03.model.Login;
import com.revature.project03.model.Status;
import com.revature.project03.service.AdminService;
import com.revature.project03.service.AppointmentService;
import com.revature.project03.service.DoctorService;
import com.revature.project03.service.LoginRouteService;
import com.revature.project03.service.PatientService;
import com.revature.project03.service.PrescriptionService;

	@ExtendWith(MockitoExtension.class)
	public class DoctorControllerTest{

		@InjectMocks
		DoctorController doctorController;
		
		//@InjectMocks
		//AdminController adminController;
		
		@Mock
		DoctorService doctorService;
		
		@InjectMocks
		LoginController loginController;
		
		@Mock
		LoginRouteService loginrouteservice;
		
		//@Mock
		//AppointmentService appointmentService;
		
		private MockMvc mockDoctorMvc, mockMvc, mockMvc1;
		private ObjectMapper mapper;
		
		@BeforeEach
		public void init() {
			mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
			mockMvc1 = MockMvcBuilders.standaloneSetup(loginController).build();
			mapper = new ObjectMapper();
		}

		@Test
		public void testGetDoctors() throws Exception {
			
			Doctor member=new Doctor();
			member.setDoctorId(4);
			member.setFirstName("Tester");
			
			
			Mockito.when(
				doctorService.getDoctorById(Mockito.anyInt())
			).thenReturn(member);

//			String postData = "{"
//					+ "    \"doctorId\": 2,"
//					+ "    \"firstName\": \"Sree\","
//					+ "    \"lastName\": \"K\","
//					+ "    \"email\": 21,"
//					+ "    \"phno\": null,"
//					+ "    \"fees\": \"8529638527\","
//					+ "    \"designation\": \"Hyderabad\","
//					+ "    \"specialization\": \"sree@gmail.com\","
//					+ "		\"doctorAvailability\":pending \","
//					+ "		\"password\":sree123 \","
//					+ "}";
			
			// Send course as body to /students/Student1/courses
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.get("/doctorController/doctorById/14");
//					.accept(MediaType.APPLICATION_JSON).content(getData)
//					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			Doctor actualResponse = mapper.readValue(result.getResponse().getContentAsString(), Doctor.class);
			assertEquals(member, actualResponse);
		}
		
		@Test
		public void testGetDoctorsbyemail() throws Exception {
			
			Doctor member=new Doctor();
			member.setDoctorId(4);
			member.setFirstName("Tester");
			
			
			Mockito.when(
				doctorService.getDoctorByEmail(Mockito.any())
			).thenReturn(member);

//			String postData = "{"
//					+ "    \"doctorId\": 2,"
//					+ "    \"firstName\": \"Sree\","
//					+ "    \"lastName\": \"K\","
//					+ "    \"email\": 21,"
//					+ "    \"phno\": null,"
//					+ "    \"fees\": \"8529638527\","
//					+ "    \"designation\": \"Hyderabad\","
//					+ "    \"specialization\": \"sree@gmail.com\","
//					+ "		\"doctorAvailability\":pending \","
//					+ "		\"password\":sree123 \","
//					+ "}";
			
			// Send course as body to /students/Student1/courses
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.get("/doctorController/doctorByEmail/astha.pandya12@gmail.com");
//					.accept(MediaType.APPLICATION_JSON).content(getData)
//					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			Doctor actualResponse = mapper.readValue(result.getResponse().getContentAsString(), Doctor.class);
			assertEquals(member, actualResponse);
		}
		
//		@Test
//		public void testloginfordoctor() throws Exception {
//			
//			LoginRoute member=new LoginRoute();
//			member.setRouteId(2);
//			member.setRole("Doctor");
//			
//
//			Status status = new Status();
//			status.setStat(true);
//			
//			
//			
//			Mockito.when(
//				loginrouteservice.findbyEmail(Mockito.anyString())
//			).thenReturn(member);
//
//			String postData = "{"
//					+ "    \"email\": \"sreekamalcoc17@gmail.com\","
//					+ "    \"password\": \"Y8b)*oU9FY\","
//					+ "}";
//			
//			// Send course as body to /students/Student1/courses
//			RequestBuilder requestBuilder = MockMvcRequestBuilders
//					.post("/loginController/login")
//					.accept(MediaType.APPLICATION_JSON).content(postData)
//					.contentType(MediaType.APPLICATION_JSON);
//
//			MvcResult result = mockMvc1.perform(requestBuilder).andReturn();
//			Status actualResponse = mapper.readValue(result.getResponse().getContentAsString(),Status.class);
//			assertEquals(member, actualResponse);
//		}
	}
	
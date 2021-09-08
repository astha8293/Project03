
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
import com.revature.project03.controller.PatientController;
	import com.revature.project03.entities.Appointment;
	import com.revature.project03.entities.Doctor;
	import com.revature.project03.entities.Family;
	import com.revature.project03.entities.Patient;
	import com.revature.project03.service.AppointmentService;
import com.revature.project03.service.DoctorService;
import com.revature.project03.service.PatientService;

	@ExtendWith(MockitoExtension.class)
	public class DoctorControllerTest{

		@InjectMocks
		DoctorController doctorController;
		
		//@InjectMocks
		//AdminController adminController;
		
		@Mock
		DoctorService doctorService;
		
		//@Mock
		//AppointmentService appointmentService;
		
		private MockMvc mockDoctorMvc, mockMvc;
		private ObjectMapper mapper;
		
		@BeforeEach
		public void init() {
			mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
			//mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
			mapper = new ObjectMapper();
		}

		@Test
		public void testAddDoctors() throws Exception {
			
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
	}
	
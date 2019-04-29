package com.patientintake;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import patientintake.ClinicCalendar;
import patientintake.Doctor;
import patientintake.PatientAppointment;

class ClinicCalendarTest {

	@Test
	void testAddAppointment()
	{
		ClinicCalendar clinicCal = new ClinicCalendar();
		String patientFirstName = "Manish", patientLastName = "Chowdhary", doctorKey = "avery",
			   dateTime = "04/30/2019 2:00 pm";
		clinicCal.addAppointment(patientFirstName, patientLastName, doctorKey, dateTime);
		List<PatientAppointment> list = clinicCal.getAppointments();
		assertNotNull(list);
		assertEquals(1, list.size());
		
		PatientAppointment app = list.get(0);
		assertEquals(patientFirstName, app.getPatientFirstName());
		assertEquals(patientLastName, app.getPatientLastName());
		assertEquals(doctorKey, app.getDoctor().toString());
		
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
	            DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
		
		assertEquals(localDateTime, app.getAppointmentDateTime());
	}

	@Test
	public void testPatientHasAppointments()
	{
		ClinicCalendar clinicCal = new ClinicCalendar();
		String patientFirstName = "Manish", patientLastName = "Chowdhary", doctorKey = "avery",
			   dateTime = "04/29/2019 2:00 pm";
		clinicCal.addAppointment(patientFirstName, patientLastName, doctorKey, dateTime);
		
		PatientAppointment patient = new PatientAppointment(patientFirstName, patientLastName,
				LocalDateTime.parse(dateTime.toUpperCase(),
			            DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US)) , Doctor.avery);
		
		assertTrue(clinicCal.hasAppointment(patient));
	}
	
	@Test
	public void testPatientHasNoAppointments()
	{
		ClinicCalendar clinicCal = new ClinicCalendar();
		String patientFirstName = "Manish", patientLastName = "Chowdhary", doctorKey = "avery",
			   dateTime = "04/28/2019 2:00 pm";
		clinicCal.addAppointment(patientFirstName, patientLastName, doctorKey, dateTime);
		
		PatientAppointment patient = new PatientAppointment(patientFirstName, patientLastName,
				LocalDateTime.parse(dateTime.toUpperCase(),
			            DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US)) , Doctor.avery);
		
		assertFalse(clinicCal.hasAppointment(patient));
	}
}

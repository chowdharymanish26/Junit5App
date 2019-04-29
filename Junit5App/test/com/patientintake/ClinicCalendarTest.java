package com.patientintake;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import patientintake.ClinicCalendar;
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

}

package it.contrader.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDTO {
	
	private Long idcalendar;
	private Date date;
	private String checkin;
	private String checkout;
	private EmployeesDTO employee;
}

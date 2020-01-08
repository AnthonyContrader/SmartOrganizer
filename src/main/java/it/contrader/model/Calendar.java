package it.contrader.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcalendar;
	
	private Date date;
	private String checkin;
	private String checkout;
	private String employee;
	
}

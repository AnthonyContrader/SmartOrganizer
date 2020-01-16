package it.contrader.model;

import javax.persistence.Entity;

import java.sql.Date;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long numberbill;
	private Date date;
	private String customer;
    private Float price;
	
	@OneToOne
	private Location location;
	}
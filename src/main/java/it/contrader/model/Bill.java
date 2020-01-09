package it.contrader.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbill;

	@Column(unique = true)
	private Long numberbill;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
	
	private String customer;

	private Float price;
	
	private String location;
	}
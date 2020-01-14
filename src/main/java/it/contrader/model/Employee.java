package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemployee;
	
	@Column(unique = true)
	private String name;
	
	private String surname;
	
	private String fiscalcode;
	
	private String position;
	
	private String worksector;
	
	private String numberofregistration;
	
	private String workgroup;
}

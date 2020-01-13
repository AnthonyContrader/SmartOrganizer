package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employees {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemployee;

	@Column(unique = true)
	
	private String name;

	private String surname;
	
	private String fiscalcode;
	
	private String worksector;
	
	private String position;
	
	private String numberofregistration;
	
	// private String workgroup;

	@ManyToOne
	@JoinColumn(name="idworkgroup")
	private Workgroup workgroup;

}

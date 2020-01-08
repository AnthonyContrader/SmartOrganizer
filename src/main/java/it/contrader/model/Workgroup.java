package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Workgroup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idworkgroup;
	
	@Column(unique=true)
	private String name;
	private String members;
	private String responsible;
	private String work;
}

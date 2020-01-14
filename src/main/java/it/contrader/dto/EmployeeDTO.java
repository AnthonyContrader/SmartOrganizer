package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idemployee")
public class EmployeeDTO {

	private Long idemployee;
	
	private String name;
	
	private String surname;
	
	private String fiscalcode;
	
	private String position;
	
	private String worksector;
	
	private String numberofregistration;
	
	private String workgroup;

}

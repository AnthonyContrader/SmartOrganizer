package it.contrader.dto;

import it.contrader.model.Workgroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeesDTO {

	private Long idemployee;

	private String name;

	private String surname;
	
	private String fiscalcode;
	
	private String worksector;
	
	private String position;
	
	private String numberofregistration;
	
	
	private WorkgroupDTO workgroupDTO;
	// private String workgroup;


}
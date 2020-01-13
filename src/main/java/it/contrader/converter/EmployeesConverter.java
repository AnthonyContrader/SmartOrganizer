package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.EmployeesDTO;

import it.contrader.model.Employees;

@Component
public class EmployeesConverter extends AbstractConverter<Employees, EmployeesDTO> {

	@Autowired
	private WorkgroupConverter converter;
	
	@Override
	public Employees toEntity(EmployeesDTO employeesDTO) {
		Employees employees = null;
		if (employeesDTO != null) 
		{
			employees = new Employees();
			employees.setIdemployee(employeesDTO.getIdemployee());
			employees.setFiscalcode(employeesDTO.getFiscalcode());
			employees.setName(employeesDTO.getName());
			employees.setNumberofregistration(employeesDTO.getNumberofregistration());
			employees.setPosition(employeesDTO.getPosition());
			employees.setSurname(employeesDTO.getSurname());
			employees.setWorksector(employeesDTO.getWorksector());
			if(employeesDTO.getWorkgroupDTO()!=null) {
				employees.setWorkgroup(converter.toEntity(employeesDTO.getWorkgroupDTO()));
			}
		}
		return employees;
	}

	@Override
	public EmployeesDTO toDTO(Employees employees) {
		EmployeesDTO employeesDTO = null;
		if (employees != null) 
		{
			employeesDTO = new EmployeesDTO();
			employeesDTO.setIdemployee(employees.getIdemployee());
			employeesDTO.setFiscalcode(employees.getFiscalcode());
			employeesDTO.setName(employees.getName());
			employeesDTO.setNumberofregistration(employees.getNumberofregistration());
			employeesDTO.setPosition(employees.getPosition());
			employeesDTO.setSurname(employees.getSurname());
			employeesDTO.setWorksector(employees.getWorksector());
			if(employees.getWorkgroup()!=null)
			{
				employeesDTO.setWorkgroupDTO(converter.toDTO(employees.getWorkgroup()));
			}
					
					// employees.getName(), employees.getSurname(), employees.getFiscalcode(), employees.getWorksector(), employees.getPosition(), employees.getNumberofregistration(), employees.getWorkgroup());

		}
		return employeesDTO;
	}
}
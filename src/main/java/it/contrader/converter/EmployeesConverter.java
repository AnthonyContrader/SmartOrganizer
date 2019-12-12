package it.contrader.converter;



import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Employees;

public class EmployeesConverter {
	
	public EmployeesDTO toDTO(Employees employees) {
		EmployeesDTO employeesDTO = new EmployeesDTO(employees.getIdemployee(), employees.getName(), employees.getSurname(), employees.getFiscalcode(), employees.getWorksector(), employees.getPosition(), employees.getNumberofregistration());
		return employeesDTO;
	}
	
	public Employees toEntity(EmployeesDTO employeesDTO) {
		Employees employees = new Employees(employeesDTO.getIdemployee(), employeesDTO.getName(), employeesDTO.getSurname(), employeesDTO.getFiscalcode(), employeesDTO.getWorksector(), employeesDTO.getPosition(), employeesDTO.getNumberofregistration());
		return employees;
	}
	
	public List<EmployeesDTO> toDTOList(List<Employees> employeesList){
		List<EmployeesDTO> employeesDTOList = new ArrayList<EmployeesDTO>();
		
		for(Employees employees : employeesList) {
			employeesDTOList.add(toDTO(employees));
		}
		
		return employeesDTOList;
	}
}

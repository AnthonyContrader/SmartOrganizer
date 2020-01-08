package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.EmployeesDTO;

import it.contrader.model.Employees;

@Component
public class EmployeesConverter extends AbstractConverter<Employees, EmployeesDTO> {

	@Override
	public Employees toEntity(EmployeesDTO employeesDTO) {
		Employees employees = null;
		if (employeesDTO != null) {
			employees = new Employees(employeesDTO.getIdemployee(), employeesDTO.getName(), employeesDTO.getSurname(), employeesDTO.getFiscalcode(), employeesDTO.getWorksector(), employeesDTO.getPosition(), employeesDTO.getNumberofregistration());
		}
		return employees;
	}

	@Override
	public EmployeesDTO toDTO(Employees employees) {
		EmployeesDTO employeesDTO = null;
		if (employees != null) {
			employeesDTO = new EmployeesDTO(employees.getIdemployee(), employees.getName(), employees.getSurname(), employees.getFiscalcode(), employees.getWorksector(), employees.getPosition(), employees.getNumberofregistration());

		}
		return employeesDTO;
	}
}
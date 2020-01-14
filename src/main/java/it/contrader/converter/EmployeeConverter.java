package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.EmployeeDTO;

import it.contrader.model.Employee;

@Component
public class EmployeeConverter extends AbstractConverter<Employee,EmployeeDTO> {

	@Override
	public Employee toEntity(EmployeeDTO employeeDTO) {
		Employee employee = null;
		if (employeeDTO != null) {
			employee = new Employee(employeeDTO.getIdemployee(),employeeDTO.getName(),employeeDTO.getSurname(),employeeDTO.getFiscalcode(),employeeDTO.getPosition(),employeeDTO.getWorksector(),employeeDTO.getNumberofregistration(),employeeDTO.getWorkgroup());			
		}
		return employee;
	}

	@Override
	public EmployeeDTO toDTO(Employee employee) {
		EmployeeDTO employeeDTO = null;
		if (employee != null) {
			employeeDTO = new EmployeeDTO(employee.getIdemployee(),employee.getName(),employee.getSurname(),employee.getFiscalcode(),employee.getPosition(),employee.getWorksector(),employee.getNumberofregistration(),employee.getWorkgroup());
			
		}
		return employeeDTO;
	}
}
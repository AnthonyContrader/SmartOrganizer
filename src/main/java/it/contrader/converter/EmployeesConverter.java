package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmployeesDTO;
//import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Employees;
/*
 * 
 * @author Vittorio, De Santis 
 *
 */
public class EmployeesConverter   {
	
	/**
	 * Crea un oggetto di tipo EmployeesDTO e lo riempie con i campi del parametro employees di tipo Employees.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public EmployeesDTO toDTO(Employees employees) {
		EmployeesDTO employeesDTO = new EmployeesDTO(employees.getIdEmployee(), employees.getName(), employees.getSurname(), employees.getFiscalCode(), employees.getWorkSector(), employees.getPosition(), employees.getNumberOfRegistration());
		return employeesDTO;
	}

	/**
	 * Crea un oggetto di tipo Employees e lo riempie con i campi del parametro employees di tipo EmployeesDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Employees toEntity(EmployeesDTO employeesDTO) {
		Employees employees = new Employees(employeesDTO.getIdEmployee(), employeesDTO.getName(), employeesDTO.getSurname(), employeesDTO.getFiscalCode(), employeesDTO.getWorkSector(), employeesDTO.getPosition(), employeesDTO.getNumberOfRegistration());
		return employees;
	}
	
	/**
	 * Metodo per convertire le liste di Employees.
	 */
	public List<EmployeesDTO> toDTOList(List<Employees> employeesList) {
		//Crea una lista vuota.
		List<EmployeesDTO> employeesDTOList = new ArrayList<EmployeesDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Employees employees : employeesList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			employeesDTOList.add(toDTO(employees));
		}
		return employeesDTOList;
	}

	
	
}

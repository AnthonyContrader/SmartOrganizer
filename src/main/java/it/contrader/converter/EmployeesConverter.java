package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Employees;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe EmployeesConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class EmployeesConverter  implements Converter<Employees, EmployeesDTO> {
	
	/**
	 * Crea un oggetto di tipo EmployeesDTO e lo riempie con i campi del parametro user di tipo Employees.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public EmployeesDTO toDTO(Employees employees) {
		EmployeesDTO employeesDTO = new EmployeesDTO(employees.getIdemployee(), employees.getName(), employees.getSurname(), employees.getFiscalcode(), employees.getWorksector(), employees.getPosition(), employees.getNumberofregistration());
		return employeesDTO;
	}

	/**
	 * Crea un oggetto di tipo Employees e lo riempie con i campi del parametro employees di tipo EmployeesDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Employees toEntity(EmployeesDTO employeesDTO) {
		Employees employees = new Employees(employeesDTO.getIdemployee(), employeesDTO.getName(), employeesDTO.getSurname(), employeesDTO.getFiscalcode(), employeesDTO.getWorksector(), employeesDTO.getPosition(), employeesDTO.getNumberofregistration());
		return employees;
	}
	
	/**
	 * Metodo per convertire le liste di Employees.
	 */
	@Override
	public List<EmployeesDTO> toDTOList(List<Employees> employeesList) {
		//Crea una lista vuota.
		List<EmployeesDTO> employeesDTOList = new ArrayList<EmployeesDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Employees employees : employeesList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			employeesDTOList.add(toDTO(employees));
		}
		return employeesDTOList;
	}

	
	
}

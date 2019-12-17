package it.contrader.service;

import it.contrader.converter.EmployeesConverter;
import it.contrader.dao.EmployeesDAO;
import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Employees;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class EmployeesService extends AbstractService<Employees, EmployeesDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public EmployeesService(){
		this.dao = new EmployeesDAO();
		this.converter = new EmployeesConverter();
	}
	

}

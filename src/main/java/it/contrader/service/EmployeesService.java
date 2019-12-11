package it.contrader.service;

import java.util.List;


import it.contrader.converter.EmployeesConverter;
import it.contrader.dao.EmployeesDAO;
import it.contrader.dto.EmployeesDTO;

/**
 * 
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class EmployeesService {
	
	private EmployeesDAO employeesDAO;
	private EmployeesConverter employeesConverter;
	
	//Istanzio DAO  e Converter specifici.
	public EmployeesService(){
		this.employeesDAO = new EmployeesDAO();
		this.employeesConverter = new EmployeesConverter();
	}
	

	public List<EmployeesDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return employeesConverter.toDTOList(employeesDAO.getAll());
	}


	public EmployeesDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return employeesConverter.toDTO(employeesDAO.read(id));
	}


	public boolean insert(EmployeesDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return employeesDAO.insert(employeesConverter.toEntity(dto));
	}


	public boolean update(EmployeesDTO dto) {
		// Converte un employeesDTO in entità e lo passa all' employeesDAO per la modifica
		return employeesDAO.update(employeesConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return employeesDAO.delete(id);
	}
	

}

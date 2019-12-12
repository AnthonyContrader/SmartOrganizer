package it.contrader.service;

import java.util.List;

import it.contrader.converter.EmployeesConverter;
import it.contrader.dao.EmployeesDAO;
import it.contrader.dto.EmployeesDTO;

public class EmployeesService {
	
	private EmployeesDAO employeesDAO;
	private EmployeesConverter employeesConverter;
	
	public EmployeesService() {
		this.employeesDAO = new EmployeesDAO();
		this.employeesConverter = new EmployeesConverter();
	}
	
	public List<EmployeesDTO> getAll(){
		return employeesConverter.toDTOList(employeesDAO.getAll());
	}
	
	public EmployeesDTO read(int idemployee) {
		return employeesConverter.toDTO(employeesDAO.read(idemployee));
	}
	
	public boolean insert(EmployeesDTO dto) {
		return employeesDAO.insert(employeesConverter.toEntity(dto));
	}
	
	public boolean update(EmployeesDTO dto) {
		return employeesDAO.update(employeesConverter.toEntity(dto));
	}
	
	public boolean delete(int idemployee) {
		return employeesDAO.delete(idemployee);
	}
	
}

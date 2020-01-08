package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.EmployeesConverter;
import it.contrader.dao.EmployeesRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.EmployeesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Employees;

@Service
public class EmployeesService extends AbstractService<Employees, EmployeesDTO> {

	@Autowired
	private EmployeesConverter converter;
	@Autowired
	private EmployeesRepository repository;

	
	

}
package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.EmployeesConverter;
import it.contrader.converter.WorkgroupConverter;
import it.contrader.dao.EmployeesRepository;
import it.contrader.dto.CalendarDTO;
import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Employees;

@Service
public class EmployeesService extends AbstractService<Employees, EmployeesDTO> {

	@Autowired
	private EmployeesConverter converter;
	@Autowired
	private EmployeesRepository repository;
	


	
	

}
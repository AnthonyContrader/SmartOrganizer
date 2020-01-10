package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.pattern.Converter;
import it.contrader.converter.CalendarConverter;
import it.contrader.converter.EmployeesConverter;
import it.contrader.dao.CalendarRepository;
import it.contrader.dto.CalendarDTO;
import it.contrader.dto.EmployeesDTO;
import it.contrader.model.Calendar;

@Service
@SuppressWarnings(value = { "unused" })
public class CalendarService extends AbstractService<Calendar, CalendarDTO> {
	
	@Autowired
	private CalendarConverter converter;
	
	@Autowired
	private CalendarRepository repository;
	
	@Autowired
	private EmployeesService service;
	
	@Autowired
	private EmployeesConverter conv;
	
	public List<CalendarDTO> findAllByEmployee(Long employee){
		return converter.toDTOList(repository.findAllByEmployee(conv.toEntity(service.read(employee))));
	}
}

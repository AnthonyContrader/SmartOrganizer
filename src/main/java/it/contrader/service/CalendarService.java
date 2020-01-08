package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CalendarConverter;
import it.contrader.dao.CalendarRepository;
import it.contrader.dto.CalendarDTO;
import it.contrader.model.Calendar;

@Service
@SuppressWarnings(value = { "unused" })
public class CalendarService extends AbstractService<Calendar, CalendarDTO> {
	
	@Autowired
	private CalendarConverter converter;
	
	@Autowired
	private CalendarRepository repository;
}

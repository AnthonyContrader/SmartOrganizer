package it.contrader.service;

import it.contrader.converter.CalendarConverter;
import it.contrader.dao.CalendarDAO;
import it.contrader.dto.CalendarDTO;
import it.contrader.model.Calendar;

public class CalendarService extends AbstractService<Calendar, CalendarDTO> {
	
	public CalendarService() {
		this.dao = new CalendarDAO();
		this.converter = new CalendarConverter();
	}
}

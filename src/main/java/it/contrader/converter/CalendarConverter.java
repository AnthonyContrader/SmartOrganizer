package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CalendarDTO;
import it.contrader.model.Calendar;

public class CalendarConverter implements Converter<Calendar, CalendarDTO> {

	@Override
	public CalendarDTO toDTO(Calendar calendar) {
		CalendarDTO calendarDTO = new CalendarDTO(calendar.getIdcalendar(), calendar.getDate(), calendar.getCheckin(), calendar.getCheckout(), calendar.getEmployee());
		return calendarDTO;
	}

	@Override
	public Calendar toEntity(CalendarDTO calendarDTO) {
		Calendar calendar = new Calendar(calendarDTO.getIdcalendar(), calendarDTO.getDate(), calendarDTO.getCheckin(), calendarDTO.getCheckout(), calendarDTO.getEmployee());
		return calendar;
	}

	@Override
	public List<CalendarDTO> toDTOList(List<Calendar> calendarList){
		List<CalendarDTO> calendarDTOList = new ArrayList<CalendarDTO>();
		
		for(Calendar calendar : calendarList) {
			calendarDTOList.add(toDTO(calendar));
		}
		return calendarDTOList;
	}
}

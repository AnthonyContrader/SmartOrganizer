package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CalendarDTO;
import it.contrader.model.Calendar;

@Component
public class CalendarConverter extends AbstractConverter<Calendar, CalendarDTO> {

	@Override
	public Calendar toEntity(CalendarDTO calendarDTO) {
		Calendar calendar = null;
		if(calendarDTO != null) {
			calendar = new Calendar(calendarDTO.getIdcalendar(), calendarDTO.getDate(), calendarDTO.getCheckin(), calendarDTO.getCheckout(), calendarDTO.getEmployee());
		}
		return calendar;
	}

	@Override
	public CalendarDTO toDTO(Calendar calendar) {
		CalendarDTO calendarDTO = null;
		if (calendar != null) {
			calendarDTO = new CalendarDTO(calendar.getIdcalendar(), calendar.getDate(), calendar.getCheckin(), calendar.getCheckout(), calendar.getEmployee());
		}
		return calendarDTO;
	}

}

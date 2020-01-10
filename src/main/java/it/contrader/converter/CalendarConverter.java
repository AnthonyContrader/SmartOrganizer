package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CalendarDTO;
import it.contrader.model.Calendar;

@Component
public class CalendarConverter extends AbstractConverter<Calendar, CalendarDTO> {

	@Autowired
	EmployeesConverter converter;
	
	@Override
	public Calendar toEntity(CalendarDTO calendarDTO) {
		Calendar calendar = null;
		if(calendarDTO != null) {
			calendar = new Calendar();
			calendar.setIdcalendar(calendarDTO.getIdcalendar());
			calendar.setCheckin(calendarDTO.getCheckin());
			calendar.setCheckout(calendarDTO.getCheckout());
			calendar.setDate(calendarDTO.getDate());
			if(calendarDTO.getEmployee() != null) {
				calendar.setEmployee(converter.toEntity(calendarDTO.getEmployee()));
			}
		}
		return calendar;
	}

	@Override
	public CalendarDTO toDTO(Calendar calendar) {
		CalendarDTO calendarDTO = null;
		if (calendar != null) {
			calendarDTO = new CalendarDTO();
			calendarDTO.setIdcalendar(calendar.getIdcalendar());
			calendarDTO.setCheckin(calendar.getCheckin());
			calendarDTO.setCheckout(calendar.getCheckout());
			calendarDTO.setDate(calendar.getDate());
			if(calendar.getEmployee() != null) {
				calendarDTO.setEmployee(converter.toDTO(calendar.getEmployee()));
			}
		}
		return calendarDTO;
	}

}

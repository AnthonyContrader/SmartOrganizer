package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.CalendarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Calendar and its DTO CalendarDTO.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface CalendarMapper extends EntityMapper<CalendarDTO, Calendar> {

    @Mapping(source = "employee.id", target = "employeeId")
    CalendarDTO toDto(Calendar calendar);

    @Mapping(source = "employeeId", target = "employee")
    Calendar toEntity(CalendarDTO calendarDTO);

    default Calendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        Calendar calendar = new Calendar();
        calendar.setId(id);
        return calendar;
    }
}

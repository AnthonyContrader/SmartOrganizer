package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CalendarDTO;
import it.contrader.service.CalendarService;

@RestController
@RequestMapping("/calendar")
@CrossOrigin(origins = "http://localhost:4200")
public class CalendarController extends AbstractController<CalendarDTO> {
	
	@Autowired
	private CalendarService calendarService;
}

package it.contrader.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CalendarDTO;
import it.contrader.dto.EmployeesDTO;
import it.contrader.service.CalendarService;
import it.contrader.service.EmployeesService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private CalendarService service;
	
	@Autowired
	private EmployeesService serviceEmp;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/calendar/calendars";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idcalendar") Long idcalendar) {
		service.delete(idcalendar);
		setAll(request);
		return "/calendar/calendars";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idcalendar") Long idcalendar) {
		request.getSession().setAttribute("dto", service.read(idcalendar));
		return "/calendar/updatecalendar";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idcalendar") Long idcalendar, @RequestParam("date") Date date, @RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout, @RequestParam("employee") Long employee ) {
		CalendarDTO dto = new CalendarDTO();
		dto.setIdcalendar(idcalendar);
		dto.setDate(date);
		dto.setCheckin(checkin);
		dto.setCheckout(checkout);
		EmployeesDTO emp = serviceEmp.read(employee);
		dto.setEmployee(emp);
		service.update(dto);
		setAll(request);
		return "/calendar/calendars";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("date") Date date, @RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout, @RequestParam("employee") Long employee ) {
		CalendarDTO dto = new CalendarDTO();
		dto.setDate(date);
		dto.setCheckin(checkin);
		dto.setCheckout(checkout);
		EmployeesDTO emp = serviceEmp.read(employee);
		dto.setEmployee(emp);
		service.insert(dto);
		setAll(request);
		return "/calendar/calendars";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idcalendar") Long idcalendar) {
		request.getSession().setAttribute("dto", service.read(idcalendar));
		return "/calendar/readcalendar";
	}
	
	@GetMapping("/filter")
	public String filterByEmployee(HttpServletRequest request, @RequestParam("employee") Long employee) {
		request.getSession().setAttribute("filteredlist", service.findAllByEmployee(employee));
		return "/calendar/filteredbyemployee";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

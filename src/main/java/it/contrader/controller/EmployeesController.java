package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EmployeesDTO;
import it.contrader.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService service;

	

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "employees/employeess";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idemployee") Long idemployee) {
		service.delete(idemployee);
		setAll(request);
		return "employees/employeess";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idemployee") Long idemployee) {
		request.getSession().setAttribute("dto", service.read(idemployee));
		return "employees/updateemployees";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idemployee") Long idemployee, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("fiscalcode") String fiscalcode, @RequestParam("worksector") String worksector, @RequestParam("position") String position, @RequestParam("numberofregistration") String numberofregistration) {
        EmployeesDTO dto = new EmployeesDTO();
		dto.setIdemployee(idemployee);
		dto.setName(name);
		dto.setSurname(surname);
		dto.setFiscalcode(fiscalcode);
		dto.setWorksector(worksector);
		dto.setPosition(position);
		dto.setNumberofregistration(numberofregistration);
		service.update(dto);
		setAll(request);
		return "employees/employeess";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("fiscalcode") String fiscalcode, @RequestParam("worksector") String worksector, @RequestParam("position") String position, @RequestParam("numberofregistration") String numberofregistration) {
		EmployeesDTO dto = new EmployeesDTO();
		dto.setName(name);
		dto.setSurname(surname);
		dto.setFiscalcode(fiscalcode);
		dto.setWorksector(worksector);
		dto.setPosition(position);
		dto.setNumberofregistration(numberofregistration);
		service.insert(dto);
		setAll(request);
		return "employees/employeess";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idemployee") Long idemployee) {
		request.getSession().setAttribute("dto", service.read(idemployee));
		return "employees/reademployees";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

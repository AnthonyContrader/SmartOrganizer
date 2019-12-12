package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EmployeesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EmployeesService;

public class EmployeesUserController implements Controller {

	private EmployeesService employeesService;
	
	public EmployeesUserController() {
		this.employeesService = new EmployeesService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
	
		
		switch(mode) {
	
		case "EMPLOYEESLIST":
			List<EmployeesDTO> employeessDTO = employeesService.getAll();
			request.put("employeess", employeessDTO);
			MainDispatcher.getInstance().callView("EmployeesUser", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("EmployeesUser", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
			
	}
}
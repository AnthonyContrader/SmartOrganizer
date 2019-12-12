package it.contrader.view.employees;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeesReadView extends AbstractView {

	private int idemployee;
	private Request request;
	private final String mode = "READ";

	public EmployeesReadView() {
		
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			EmployeesDTO employees = (EmployeesDTO) request.get("employees");
			System.out.println(employees);
			MainDispatcher.getInstance().callView("Employees", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del dipendente:");
		idemployee = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idemployee", idemployee);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employees", "doControl", request);
	}

}

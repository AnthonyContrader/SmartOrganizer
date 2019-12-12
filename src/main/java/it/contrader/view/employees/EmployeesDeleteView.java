package it.contrader.view.employees;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeesDeleteView extends AbstractView {

	private Request request;

	private int idemployee;
	private final String mode = "DELETE";
	
	public EmployeesDeleteView() {
		
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Employees", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id del dipendente:");
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

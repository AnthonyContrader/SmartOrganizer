package it.contrader.view.employees;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeesInsertView extends AbstractView {

	private Request request;

	private String name;
	private String surname;
	private String fiscalcode;
	private String worksector;
	private String position;
	private String numberofregistration;
	
	private final String mode = "INSERT";

	
	public EmployeesInsertView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
		System.out.println("Inserimento andato a buon fine.\n");
		MainDispatcher.getInstance().callView("Employees", null);
	}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci nome del dipendente:");
		name = getInput();
		System.out.println("Inserisci cognome del dipendente:");
		surname = getInput();
		System.out.println("Inserisci codice fiscale:");
		fiscalcode = getInput();
		System.out.println("Inserisci settore di lavoro:");
		worksector = getInput();
		System.out.println("Inserisci la posizione lavorativa:");
		position = getInput();
		System.out.println("Inserisci il numero di matricola:");
		numberofregistration = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("surname", surname);
		request.put("fiscalcode", fiscalcode);
		request.put("worksector", worksector);
		request.put("position", position);
		request.put("numberofregistration", numberofregistration);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Employees", "doControl", request);
	}

}

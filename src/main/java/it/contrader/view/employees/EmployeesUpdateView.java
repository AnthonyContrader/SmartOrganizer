package it.contrader.view.employees;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EmployeesUpdateView extends AbstractView {

	private Request request;

	private int idemployee;
	private String name;
	private String surname;
	private String fiscalcode;
	private String worksector;
	private String position;
	private String numberofregistration;
	private final String mode = "UPDATE";
	
	public EmployeesUpdateView() {
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Employees", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del dipendente:");
			idemployee = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del dipendente:");
			name = getInput();
			System.out.println("Inserisci cognome del dipendente:");
			surname = getInput();
			System.out.println("Inserisci codice fiscale del dipendente:");
			fiscalcode = getInput();
			System.out.println("Inserisci settore lavorativo del dipendente:");
			worksector = getInput();
			System.out.println("Inserisci posizione lavorativa del dipendente:");
			position = getInput();
			System.out.println("Inserisci numero di matricola del dipendente:");
			numberofregistration = getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idemployee", idemployee);
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

package it.contrader.view.location;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class LocationInsertView extends AbstractView {

	private Request request;

	private String address;
	private String city;
	private String typeoflocation;
	private String worktype;
	
	private final String mode = "INSERT";

	
	public LocationInsertView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
		System.out.println("Inserimento andato a buon fine.\n");
		MainDispatcher.getInstance().callView("Location", null);
	}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l' indirizzo");
		address = getInput();
		System.out.println("Inserisci la città:");
		city = getInput();
		System.out.println("inserisci il tipo di luogo");
		typeoflocation = getInput();
		System.out.println("inserisci il tipo di lavoro");
		worktype= getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("address", address);
		request.put("city", city);
		request.put("typeoflocation", typeoflocation);
		request.put("worktype", worktype);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Location", "doControl", request);
	}

}

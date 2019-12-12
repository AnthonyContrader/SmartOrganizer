package it.contrader.view.location;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class LocationDeleteView extends AbstractView {

	private Request request;

	private int idlocation;
	private final String mode = "DELETE";
	
	public LocationDeleteView() {
		
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Location", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id della location:");
		idlocation = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idlocation", idlocation);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Location", "doControl", request);
	}

}

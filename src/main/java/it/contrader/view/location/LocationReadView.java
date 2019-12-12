package it.contrader.view.location;

import it.contrader.controller.Request;
import it.contrader.dto.LocationDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class LocationReadView extends AbstractView {

	private int idlocation;
	private Request request;
	private final String mode = "READ";

	public LocationReadView() {
		
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			LocationDTO location = (LocationDTO) request.get("location");
			System.out.println(location);
			MainDispatcher.getInstance().callView("Location", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della location:");
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

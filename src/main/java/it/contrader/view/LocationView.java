package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.LocationDTO;
import it.contrader.main.MainDispatcher;

public class LocationView extends AbstractView{

	private Request request;
	private String choice;

	public LocationView() {
	}
	
	
	@Override
	public void showResults(Request request) {

		if (request != null) {
			System.out.println("\n------------------- Gestione luogo di lavoro ----------------\n");
			System.out.println("ID\tAddress\tCity\tType of location, worktype");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<LocationDTO> locations = (List<LocationDTO>) request.get("locations");
			for (LocationDTO l: locations)
				System.out.println(l);
			System.out.println();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Location", "doControl", this.request);
	}

}

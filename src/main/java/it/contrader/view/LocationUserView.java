package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.LocationDTO;
import it.contrader.main.MainDispatcher;

public class LocationUserView extends AbstractView{
	private Request request;
	private String choice;
	
	public LocationUserView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n----------------- Gestione località ---------------\n");
			System.out.println("ID\tindirizzo\tcittà\ttipo di località\ttipo di lavoro");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<LocationDTO> locations = (List<LocationDTO>) request.get("locations");
			for(LocationDTO l : locations)
				System.out.println(l);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[B]ack [E]sci");

		this.choice = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("LocationUser", "doControl", this.request);
		
	}
}

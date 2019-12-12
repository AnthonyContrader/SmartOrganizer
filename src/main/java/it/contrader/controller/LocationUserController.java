package it.contrader.controller;

import java.util.List;

import it.contrader.dto.LocationDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LocationService;

public class LocationUserController implements Controller {

	private LocationService locationService;
	
	public LocationUserController() {
		this.locationService = new LocationService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
	
		
		switch(mode) {
	
		case "LOCATIONLIST":
			List<LocationDTO> locationsDTO = locationService.getAll();
			request.put("locations", locationsDTO);
			MainDispatcher.getInstance().callView("LocationUser", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
			
	}
}


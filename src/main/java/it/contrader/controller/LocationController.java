package it.contrader.controller;

import java.util.List;

import it.contrader.dto.LocationDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LocationService;


public class LocationController implements Controller{

	private static String sub_package = "location.";
	private LocationService locationService;
	
	public LocationController() {
		this.locationService=new LocationService();
	}
	
	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idlocation;
		String 	address,
				city,
				typeoflocation,
				worktype;
		
		switch(mode) {
		//il commento seguente � preso da usercontroller
		//Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		
		case "READ":
			idlocation= Integer.parseInt(request.get("idlocation").toString());
			LocationDTO locationDTO = locationService.read(idlocation);
			request.put("location", locationDTO);
			MainDispatcher.getInstance().callView(sub_package + "LocationRead", request);
			break;
	
		case "INSERT":
			address = request.get("address").toString();
			city = request.get("city").toString();
			typeoflocation = request.get("typeoflocation").toString();
			worktype=request.get("worktype").toString();
			
			//costruisce l'oggetto location da inserire
			LocationDTO locationtoinsert = new LocationDTO(address, city, typeoflocation, worktype);
			//invoca il service
			locationService.insert(locationtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "LocationInsert", request);
			break;
			
			// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idlocation = Integer.parseInt(request.get("idlocation").toString());
			//Qui chiama il service
			locationService.delete(idlocation);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LocationDelete", request);
			break;
		
		case "UPDATE":
			idlocation = Integer.parseInt(request.get("idlocation").toString());
			
			address = request.get("address").toString();
			city = request.get("city").toString();
			typeoflocation = request.get("typeoflocation").toString();
			worktype=request.get("worktype").toString();
			
			LocationDTO locationtoupdate = new LocationDTO(address, city, typeoflocation, worktype);
			locationtoupdate.setIdlocation(idlocation);
			locationService.update(locationtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "LocationUpdate", request);
			break;
			
		case "LOCATIONLIST":
			List<LocationDTO> locationsDTO = locationService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("locations", locationsDTO);
			MainDispatcher.getInstance().callView("Location", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "LocationRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "LocationInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "LocationUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "LocationDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null); //---------- ATTENZIONE HOME ADMIN NON C'ENTRA NULLA-----------//
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			
			
		
		}//fine switch getchoice
			default:
				MainDispatcher.getInstance().callView("Login", null);
		}//fine switch
	}//fine override docontrol

}//fine classe

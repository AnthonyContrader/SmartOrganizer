package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		System.out.println("\n-----Benvenuto in Gestione Utenti!-----");

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU USER------------\n");
		System.out.println(" Seleziona cosa vuoi gestire:");
	    System.out.println("[U]Lista Utenti [D]Lista Dipendenti [L]Lista Località [T]Tools [E]sci");
		choice = this.getInput();

	}

	@Override



		public void submit() {    
	    	//crea una nuova Request (vedi classe Request)
	    	request = new Request();
	        switch (choice) {
	        case "u":
	        	this.request.put("mode", "USERLIST");
	        	MainDispatcher.getInstance().callAction("User", "doControl", request);
	        	break;
	 
	        case "e":
	        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
	        	break;
	        	
	        case "d":
	        	this.request.put("mode", "EMPLOYEESLIST");
	        	MainDispatcher.getInstance().callAction("Employees", "doControl", request);
	        	break;
	        	
	        case "t":
	        	this.request.put("mode", "TOOLLIST");
	        	MainDispatcher.getInstance().callAction("ToolUser", "doControl", request); // Aggiunto lista per la view (Angelo)
	        	break;
	        	
	        case "l":
	        	this.request.put("mode", "LOCATIONLIST");
	        	MainDispatcher.getInstance().callAction("LocationUser", "doControl", request); //Aggiunto lista per la view (Ivan)
	        	break;
	        default:
	        	
	            request.put("choice", choice);
	        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
	        }
}
}
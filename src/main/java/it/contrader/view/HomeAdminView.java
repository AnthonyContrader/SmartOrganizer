/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non � nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SMART ORGANIZER "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU SMART ORGANIZER------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]Utenti [D]Dipendenti [T]Tools [L]Location [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() � definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sar� diversa) che invia ai controller tramite il
     * Dispatcher
     */
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
        	request.put("mode", "EMPLOYEESLIST");
        	MainDispatcher.getInstance().callAction("Employees", "doControl", request);
        	break;
        	
        case "t":
        	request.put("mode", "TOOLLIST");
        	MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", request); // Aggiunto lista per la view (Angelo)
        	break;
        	
        case "l":
        	request.put("mode", "LOCATIONLIST");
        	MainDispatcher.getInstance().callAction("Location", "doControl", request); //Aggiunto lista per la view (Ivan)
        break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}

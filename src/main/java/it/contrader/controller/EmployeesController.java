package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EmployeesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EmployeesService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class EmployeesController implements Controller {

	/**
	 * definisce il pacchetto di vista employees.
	 */
	private static String sub_package = "employees.";
	
	private EmployeesService employeesService;
	/**
	 * Costruisce un oggetto di tipo EmployeesService per poterne usare i metodi
	 */
	public EmployeesController() {
		this.employeesService = new EmployeesService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idemployee;
		String name;
		String surname;
		String fiscalCode;
		String workSector;
		String position;
		String numberOfRegistration;

		switch (mode) {
		
		// Arriva qui dalla EmployeesReadView. Invoca il Service con il parametro id e invia alla EmployeesReadView un employee da mostrare 
		case "READ":
			idemployee = Integer.parseInt(request.get("id employee").toString());
			EmployeesDTO employeesDTO = employeesService.read(idemployee);
			request.put("employee", employeesDTO);
			MainDispatcher.getInstance().callView(sub_package + "EmployeeRead", request);
			break;
		
		// Arriva qui dalla EmployeesInsertView. Estrae i parametri da inserire e chiama il service per inserire un employee con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			fiscalCode = request.get("fiscal code").toString();
			workSector = request.get("work sector").toString();
			position = request.get("position").toString();
			numberOfRegistration = request.get("number of registration").toString();
			
			//costruisce l'oggetto employees da inserire
			EmployeesDTO employeestoinsert = new EmployeesDTO(name, surname, fiscalCode, workSector, position, numberOfRegistration);
			//invoca il service
			employeesService.insert(employeestoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "EmployeesInsert", request);
			break;
		
		// Arriva qui dalla EmployeesDeleteView. Estrae l'id del dipendente da cancellare e lo passa al Service
		case "DELETE":
			idemployee = Integer.parseInt(request.get("id employee").toString());
			//Qui chiama il service
			employeesService.delete(idemployee);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeesDelete", request);
			break;
		
		// Arriva qui dalla EmployeesUpdateView
		case "UPDATE":
			idemployee = Integer.parseInt(request.get("idemployee").toString());
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			fiscalCode = request.get("fiscal code").toString();
			workSector = request.get("work sector").toString();
			position = request.get("position").toString();
			numberOfRegistration = request.get("number of registration").toString();
			EmployeesDTO employeestoupdate = new EmployeesDTO(name, surname, fiscalCode, workSector, position, numberOfRegistration);
			employeestoupdate.setIdEmployee(idemployee);
			employeesService.update(employeestoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EmployeesUpdate", request);
			break;
			
		//Arriva qui dalla EmployeesView Invoca il Service e invia alla EmployeesView il risultato da mostrare 
		case "EMPLOYEESLIST":
			List<EmployeesDTO> EmployeessDTO = employeesService.getAll();
			//Impacchetta la request con la lista degli employees
			request.put("employees", EmployeessDTO);
			MainDispatcher.getInstance().callView("Employees", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "EmployeesRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "EmployeesInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "EmployeesUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "EmployeesDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}

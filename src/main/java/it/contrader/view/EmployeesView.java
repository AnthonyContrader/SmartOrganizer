package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeesDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class EmployeesView extends AbstractView {

	private Request request;
	private String choice;

	public EmployeesView() {
		
	}

	/**
	 * Mostra la lista dipendenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione dipendenti ----------------\n");
			System.out.println("ID Employee\tName\tSurname\tFiscal Code\tWork Sector\tPosition\tNumber Of Registration");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<EmployeesDTO> employeess = (List<EmployeesDTO>) request.get("employees");
			for (EmployeesDTO e: employeess)
				System.out.println(e);
			System.out.println();
		}
	}

	/**
	 * Chiede al dipendente un input (lettera da tastiera) per la choice (vedi EmployeesController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo EmployeesController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Employees", "doControl", this.request);
	}

}

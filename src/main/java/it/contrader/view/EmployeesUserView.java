package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EmployeesDTO;
import it.contrader.main.MainDispatcher;

public class EmployeesUserView extends AbstractView{
	private Request request;
	private String choice;
	
	public EmployeesUserView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n----------------- Gestione dipendenti ---------------\n");
			System.out.println("IDemployee\tNome Dipendente\tCognome Dipendente\tCodice Fiscale\tSettore di Lavoro\tPosizione Lavorativa\tNumero di Matricola");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<EmployeesDTO> employeess = (List<EmployeesDTO>) request.get("employeess");
			for(EmployeesDTO e : employeess)
				System.out.println(e);
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
		MainDispatcher.getInstance().callAction("EmployeesUser", "doControl", this.request);
		
	}
}

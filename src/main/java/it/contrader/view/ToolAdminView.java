package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ToolDTO;
import it.contrader.main.MainDispatcher;

public class ToolAdminView extends AbstractView {

	private Request request;
	private String choice;
	
	public ToolAdminView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n----------------- Gestione strumenti ---------------\n");
			System.out.println("IDtool\tNome Strumento\tMateria Prima");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ToolDTO> tools = (List<ToolDTO>) request.get("tools");
			for(ToolDTO t : tools)
				System.out.println(t);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", this.request);
		
	}

}

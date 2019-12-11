package it.contrader.view.tool;

import it.contrader.controller.Request;
import it.contrader.dto.ToolDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ToolReadView extends AbstractView {

	private int idtools;
	private Request request;
	private final String mode = "READ";

	public ToolReadView() {
		
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ToolDTO tool = (ToolDTO) request.get("tool");
			System.out.println(tool);
			MainDispatcher.getInstance().callView("Tool", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dello strumento:");
		idtools = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request.put("idtools", idtools);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Tool", "doControl", request);
	}

}

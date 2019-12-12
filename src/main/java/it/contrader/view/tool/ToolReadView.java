package it.contrader.view.tool;

import it.contrader.controller.Request;
import it.contrader.dto.ToolDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ToolReadView extends AbstractView {

	private int idtool;
	private Request request;
	private final String mode = "READ";

	public ToolReadView() {
		
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ToolDTO tool = (ToolDTO) request.get("tool");
			System.out.println(tool);
			MainDispatcher.getInstance().callView("ToolAdmin", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dello strumento:");
		idtool = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtool", idtool);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", request);
	}

}

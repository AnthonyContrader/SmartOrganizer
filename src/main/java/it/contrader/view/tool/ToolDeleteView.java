package it.contrader.view.tool;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ToolDeleteView extends AbstractView {

	private Request request;

	private int idtools;
	private final String mode = "DELETE";
	
	public ToolDeleteView() {
		
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("ToolAdmin", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id dello strumento:");
		idtools = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtools", idtools);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", request);
	}

}

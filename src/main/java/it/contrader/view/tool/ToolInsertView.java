package it.contrader.view.tool;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ToolInsertView extends AbstractView {

	private Request request;

	private String toolname;
	private String rawmaterial;
	
	private final String mode = "INSERT";

	
	public ToolInsertView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
		System.out.println("Inserimento andato a buon fine.\n");
		MainDispatcher.getInstance().callView("ToolAdmin", null);
	}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci nome dello strumento:");
		toolname = getInput();
		System.out.println("Inserisci la materia prima:");
		rawmaterial = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("toolname", toolname);
		request.put("rawmaterial", rawmaterial);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", request);
	}

}

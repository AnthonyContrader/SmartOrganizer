package it.contrader.view.tool;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ToolUpdateView extends AbstractView {

	private Request request;

	private int idtools;
	private String toolsname;
	private String rawmaterial;
	private final String mode = "UPDATE";
	
	public ToolUpdateView() {
	}
	
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Tool", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dello strumento:");
			idtools = Integer.parseInt(getInput());
			System.out.println("Inserisci nome dello strumento:");
			toolsname = getInput();
			System.out.println("Inserisci la materia prima:");
			rawmaterial = getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtools", idtools);
		request.put("toolsname", toolsname);
		request.put("rawmaterial", rawmaterial);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("ToolAdmin", "doControl", request);
	}

}

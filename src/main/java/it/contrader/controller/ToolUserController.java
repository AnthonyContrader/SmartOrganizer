package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ToolDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ToolService;

public class ToolUserController implements Controller {

	private ToolService toolService;
	
	public ToolUserController() {
		this.toolService = new ToolService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
	
		
		switch(mode) {
	
		case "TOOLLIST":
			List<ToolDTO> toolsDTO = toolService.getAll();
			request.put("tools", toolsDTO);
			MainDispatcher.getInstance().callView("ToolUser", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
			
	}
}


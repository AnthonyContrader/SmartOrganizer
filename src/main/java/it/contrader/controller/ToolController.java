package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ToolDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ToolService;

public class ToolController implements Controller {

	private static String sub_package = "tool.";
	private ToolService toolService;
	
	public ToolController() {
		this.toolService = new ToolService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
	
		int idtools;
		String toolname;
		String rawmaterial;
		
		switch(mode) {
		case "READ":
			idtools = Integer.parseInt(request.get("idtools").toString());
			ToolDTO toolDTO = toolService.read(idtools);
			request.put("tool", toolDTO);
			MainDispatcher.getInstance().callView(sub_package+"ToolRead", request);
			break;
			
		case "INSERT":
			toolname = request.get("toolsname").toString();
			rawmaterial = request.get("rawmaterial").toString();
			
			ToolDTO tooltoinsert = new ToolDTO(toolname, rawmaterial);
			toolService.insert(tooltoinsert);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package+"ToolInsert", request);
			break;
			
		case "DELETE":
			idtools = Integer.parseInt(request.get("idtools").toString());
			
			toolService.delete(idtools);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package+"ToolDelete", request);
			break;
			
		case "UPDATE":
			idtools = Integer.parseInt(request.get("idtools").toString());
			toolname = request.get("toolsname").toString();
			rawmaterial = request.get("rawmaterial").toString();
			ToolDTO tooltoupdate = new ToolDTO(toolname, rawmaterial);
			tooltoupdate.setIdtool(idtools);
			toolService.update(tooltoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package+"ToolUpdate", request);
			break;
		
		case "TOOLLIST":
			List<ToolDTO> toolsDTO = toolService.getAll();
			request.put("tools", toolsDTO);
			MainDispatcher.getInstance().callView("Tool", request);
			break;
			
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package+"ToolRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package+"ToolInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ToolUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ToolDelete", null);
				break;
			
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeTools", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
			
	}
}


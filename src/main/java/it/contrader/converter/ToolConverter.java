package it.contrader.converter;



import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

public class ToolConverter {
	
	public ToolDTO toDTO(Tool tool) {
		ToolDTO toolDTO = new ToolDTO(tool.getIdtool(), tool.getToolname(), tool.getRawmaterial());
		return toolDTO;
	}
	
	public Tool toEntity(ToolDTO toolDTO) {
		Tool tool = new Tool(toolDTO.getIdtool(), toolDTO.getToolname(), toolDTO.getRawmaterial());
		return tool;
	}
	
	public List<ToolDTO> toDTOList(List<Tool> toolList){
		List<ToolDTO> toolDTOList = new ArrayList<ToolDTO>();
		
		for(Tool tool : toolList) {
			toolDTOList.add(toDTO(tool));
		}
		
		return toolDTOList;
	}
}

package it.contrader.converter;

import org.springframework.stereotype.Component;


import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;


@Component
public class ToolConverter extends AbstractConverter<Tool, ToolDTO> {

	@Override
	public Tool toEntity(ToolDTO toolDTO) {
		Tool tool = null;
		if (toolDTO != null) {
			tool = new Tool(toolDTO.getIdtool(), toolDTO.getToolname(), toolDTO.getRawmaterial());
		}
		return tool;
	}

	@Override
	public ToolDTO toDTO(Tool tool) {
		ToolDTO toolDTO = null;
		if (tool != null) {
			toolDTO = new ToolDTO(tool.getIdtool(), tool.getToolname(), tool.getRawmaterial());
		}
		return toolDTO;
	}

}

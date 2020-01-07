package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ToolDTO {

	private Long idtool;
	private String toolname;
	private String rawmaterial;
	
}

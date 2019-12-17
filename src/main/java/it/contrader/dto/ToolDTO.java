package it.contrader.dto;

public class ToolDTO implements DTO{

	private int idtool;
	private String toolname;
	private String rawmaterial;
	
	public ToolDTO() {
		
	}
	
	public ToolDTO(String toolname, String rawmaterial) {
		this.toolname=toolname;
		this.rawmaterial=rawmaterial;
	}
	
	public ToolDTO(int idtool,String toolname, String rawmaterial) {
		this.idtool=idtool;
		this.toolname=toolname;
		this.rawmaterial=rawmaterial;
	}

	public int getIdtool() {
		return idtool;
	}
	public void setIdtool(int idtool) {
		this.idtool = idtool;
	}

	
	public String getToolname() {
		return toolname;
	}
	public void setToolname(String toolname) {
		this.toolname = toolname;
	}

	
	public String getRawmaterial() {
		return rawmaterial;
	}
	public void setRawmaterial(String rawmaterial) {
		this.rawmaterial = rawmaterial;
	}

	@Override
	public String toString() {
		return idtool + "\t\t" + toolname + "\t\t" + rawmaterial;
	}
}

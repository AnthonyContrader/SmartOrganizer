package it.contrader.model;

public class Tools {
	
	private int idtools;
	private String toolsname;
	private String rawmaterial;
	
	public Tools() {
		
	}
	
	public Tools(String toolsname, String rawmaterial) {
		this.toolsname=toolsname;
		this.rawmaterial=rawmaterial;
	}
	
	public Tools(int idtools,String toolsname, String rawmaterial) {
		this.idtools=idtools;
		this.toolsname=toolsname;
		this.rawmaterial=rawmaterial;
	}

	public int getIdtools() {
		return idtools;
	}
	public void setIdtools(int idtools) {
		this.idtools = idtools;
	}

	
	public String getToolsname() {
		return toolsname;
	}
	public void setToolsname(String toolsname) {
		this.toolsname = toolsname;
	}

	
	public String getRawmaterial() {
		return rawmaterial;
	}
	public void setRawmaterial(String rawmaterial) {
		this.rawmaterial = rawmaterial;
	}

	@Override
	public String toString() {
		return idtools + "\t" + toolsname + "\t\t" + rawmaterial;
	}
}

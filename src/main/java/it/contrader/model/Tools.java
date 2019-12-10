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
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Tools other = (Tools)o;
		if(idtools != other.idtools)
			return false;
		if(toolsname == null) {
			if(other.toolsname!=null)
				return false;
		}else if(!toolsname.equals(other.toolsname))
				return false;
		if(rawmaterial == null) {
			if(other.rawmaterial!=null)
				return false;
		}else if(!rawmaterial.equals(other.rawmaterial))
				return false;
		
		return true;
	}
}

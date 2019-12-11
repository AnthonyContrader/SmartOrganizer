package it.contrader.model;

public class Tool {
	
	private int idtool;
	private String toolname;
	private String rawmaterial;
	
	public Tool() {
		
	}
	
	public Tool(String toolname, String rawmaterial) {
		this.toolname=toolname;
		this.rawmaterial=rawmaterial;
	}
	
	public Tool(int idtool,String toolname, String rawmaterial) {
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
		return idtool + "\t" + toolname + "\t\t" + rawmaterial;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Tool other = (Tool)obj;
		if(idtool != other.getIdtool())
			return false;
		if(toolname == null) {
			if(other.toolname != null)
				return false;
		}else if(!toolname.equals(other.toolname))
					return false;
		if(rawmaterial == null) {
			if(other.rawmaterial != null)
				return false;
		}else if(!rawmaterial.equals(other.rawmaterial))
					return false;
		return true;
	}
}

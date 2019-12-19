package it.contrader.model;

public class Workgroup {
	
	private int idworkgroup;
	private String name;
	private String members;
	private String responsible;
	private String work;
	public Workgroup() {
		
	}
	public Workgroup(String name, String members, String responsible, String work) {
		super();
		this.name = name;
		this.members = members;
		this.responsible = responsible;
		this.work = work;
	}
	public Workgroup(int idworkgroup, String name, String members, String responsible, String work) {
		super();
		this.idworkgroup = idworkgroup;
		this.name = name;
		this.members = members;
		this.responsible = responsible;
		this.work = work;
	}
	
	
	public int getIdworkgroup() {
		return idworkgroup;
	}
	public void setIdworkgroup(int idworkgroup) {
		this.idworkgroup = idworkgroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	@Override
	public String toString() {
		return idworkgroup + "\t"  + name + "\t\t" + members + "\t\t" + responsible + "\t\t" + work ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workgroup other = (Workgroup) obj;
		if (idworkgroup != other.idworkgroup)
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (responsible == null) {
			if (other.responsible != null)
				return false;
		} else if (!responsible.equals(other.responsible))
			return false;
		if (work == null) {
			if (other.work != null)
				return false;
		} else if (!work.equals(other.work))
			return false;
		return true;
	}
	
	

}

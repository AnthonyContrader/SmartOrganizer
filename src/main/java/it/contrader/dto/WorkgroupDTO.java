package it.contrader.dto;

public class WorkgroupDTO implements DTO
{
	private int idworkgroup;
	private String name;
	private String members;
	private String responsible;
	private String work;
	public WorkgroupDTO() {
		
	}
	public WorkgroupDTO(String name, String members, String responsible, String work) {
		super();
		this.name = name;
		this.members = members;
		this.responsible = responsible;
		this.work = work;
	}
	public WorkgroupDTO(int idworkgroup, String name, String members, String responsible, String work) {
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
		return  idworkgroup +"\t"  + name + "\t\t" + members + "\t\t" + responsible + "\t\t" + work;
	}
	
}//fine classe

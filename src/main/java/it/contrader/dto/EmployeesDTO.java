package it.contrader.dto;

public class EmployeesDTO {

	private int idemployee;
	private String name;
	private String surname;
	private String fiscalcode;
	private String worksector;
	private String position;
	private String numberofregistration;
	
	public EmployeesDTO() {
		
	}
	
	public EmployeesDTO(String name, String surname, String fiscalcode, String worksector, String position, String numberofregistration) {
		this.name=name;
		this.surname=surname;
		this.fiscalcode=fiscalcode;
		this.worksector=worksector;
		this.position=position;
		this.numberofregistration=numberofregistration;
	}
	
	public EmployeesDTO(int idemployee,String name, String surname, String fiscalcode, String worksector, String position, String numberofregistration) {
		this.idemployee=idemployee;
		this.name=name;
		this.surname=surname;
		this.fiscalcode=fiscalcode;
		this.worksector=worksector;
		this.position=position;
		this.numberofregistration=numberofregistration;
	}

	

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFiscalcode() {
		return fiscalcode;
	}

	public void setFiscalcode(String fiscalcode) {
		this.fiscalcode = fiscalcode;
	}

	public String getWorksector() {
		return worksector;
	}

	public void setWorksector(String worksector) {
		this.worksector = worksector;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNumberofregistration() {
		return numberofregistration;
	}

	public void setNumberofregistration(String numberofregistration) {
		this.numberofregistration = numberofregistration;
	}

	@Override
	public String toString() {
		return idemployee + "\t" + name + "\t" + surname + "\t" + fiscalcode + "\t" + worksector + "\t" + position + "\t" + numberofregistration + "\t";
	}
}

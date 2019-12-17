package it.contrader.model;

public class Employees {

	private int idemployee;

	private String name;
	
	private String surname;
	
	private String fiscalcode;
	
	private String worksector;
	
	private String position;
	
	private String numberofregistration;

	public Employees() {
		
	}

	public Employees (String name, String surname, String fiscalcode, String worksector, String position, String numberofregistration) {
		this.name = name;
		this.surname = surname;
		this.fiscalcode = fiscalcode;
		this.worksector = worksector;
		this.position = position;
		this.numberofregistration = numberofregistration;
	}

	public Employees (int idemployee, String name, String surname, String fiscalcode, String worksector, String position, String numberofregistration) {
		this.idemployee = idemployee;
		this.name = name;
		this.surname = surname;
		this.fiscalcode = fiscalcode;
		this.worksector = worksector;
		this.position = position;
		this.numberofregistration = numberofregistration;
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
//Metodo per il confronto degli oggetti
	@Override
	public String toString() {
		return idemployee + "\t" + name + "\t" + surname + "\t" + fiscalcode + "\t" + worksector + "\t" + position + "\t" + numberofregistration;
		
	}
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Employees other = (Employees)obj;
		if(idemployee != other.getIdemployee())
			return false;
		if(name == null) {
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name))
					return false;
		if(surname == null) {
			if(other.surname != null)
				return false;
		}else if(!surname.equals(other.surname))
					return false;
		if(fiscalcode == null) {
			if(other.fiscalcode != null)
				return false;
		}else if(!fiscalcode.equals(other.fiscalcode))
					return false;
		if(worksector == null) {
			if(other.worksector != null)
				return false;
		}else if(!worksector.equals(other.worksector))
					return false;
		if(position == null) {
			if(other.position != null)
				return false;
		}else if(!position.equals(other.position))
					return false;
		if(numberofregistration == null) {
			if(other.numberofregistration != null)
				return false;
		}else if(!numberofregistration.equals(other.numberofregistration))
					return false;
		return true;
	}


	
}

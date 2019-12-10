package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Employees {

	/**
	 * Qui sotto definisco gli attributi di Employees. 
	 */
	private int idEmployee;

	private String name;
	
	private String surname;
	
	private String fiscalCode;
	
	private String workSector;
	
	private String position;
	
	private String numberOfRegistration;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con sei parametri per costrire oggetti di tipo Employees
	 */
	public Employees() {
		
	}

	public Employees (String name, String surname, String fiscalCode, String workSector, String position, String numberOfRegistration) {
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
		this.workSector = workSector;
		this.position = position;
		this.numberOfRegistration = numberOfRegistration;
	}

	public Employees (int idEmployee, String name, String surname, String fiscalCode, String workSector, String position, String numberOfRegistration) {
		this.idEmployee = idEmployee;
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
		this.workSector = workSector;
		this.position = position;
		this.numberOfRegistration = numberOfRegistration;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Employees
	 */
	
	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
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

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getWorkSector() {
		return workSector;
	}

	public void setWorkSector(String workSector) {
		this.workSector = workSector;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNumberOfRegistration() {
		return numberOfRegistration;
	}

	public void setNumberOfRegistration(String numberOfRegistration) {
		this.numberOfRegistration = numberOfRegistration;
	}
/*Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}*/
}

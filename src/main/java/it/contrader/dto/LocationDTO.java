package it.contrader.dto;

public class LocationDTO {

	private int idlocation;
	private String 	adress,
					city,
					typeoflocation,
					worktype;
	
	
	public LocationDTO() {
		super();
	}


	public LocationDTO(String adress, String city, String typeoflocation, String worktype) {
		super();
		this.adress = adress;
		this.city = city;
		this.typeoflocation = typeoflocation;
		this.worktype = worktype;
	}


	public LocationDTO(int idlocation, String adress, String city, String typeoflocation, String worktype) {
		super();
		this.idlocation = idlocation;
		this.adress = adress;
		this.city = city;
		this.typeoflocation = typeoflocation;
		this.worktype = worktype;
	}


	public int getIdlocation() {
		return idlocation;
	}


	public void setIdlocation(int idlocation) {
		this.idlocation = idlocation;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getTypeoflocation() {
		return typeoflocation;
	}


	public void setTypeoflocation(String typeoflocation) {
		this.typeoflocation = typeoflocation;
	}


	public String getWorktype() {
		return worktype;
	}


	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}


	@Override
	public String toString() {
		return  idlocation + "\t" + adress +  "\t\t" + city +  "\t\t"
				+ typeoflocation +  "\t\t" + worktype;
	}
	
	
	
	
}//Fine Classe

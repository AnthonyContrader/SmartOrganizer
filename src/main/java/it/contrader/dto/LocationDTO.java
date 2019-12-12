package it.contrader.dto;

public class LocationDTO {

	private int idlocation;
	private String 	address,
					city,
					typeoflocation,
					worktype;
	
	
	public LocationDTO() {
		
	}


	public LocationDTO(String address, String city, String typeoflocation, String worktype) {
		
		this.address = address;
		this.city = city;
		this.typeoflocation = typeoflocation;
		this.worktype = worktype;
	}


	public LocationDTO(int idlocation, String address, String city, String typeoflocation, String worktype) {
		
		this.idlocation = idlocation;
		this.address = address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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
		return  idlocation + "\t" + address +  "\t\t" + city +  "\t\t"
				+ typeoflocation +  "\t\t" + worktype;
	}
	
	
	
	
}//Fine Classe

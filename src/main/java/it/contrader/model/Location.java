package it.contrader.model;

public class Location {
	private int idlocation;
	private String 	address,
					city,
					typeoflocation,
					worktype;
	
	public Location() {}

	public Location(String address, String city, String typeoflocation, String worktype) {
		
		this.address = address;
		this.city = city;
		this.typeoflocation = typeoflocation;
		this.worktype = worktype;
	}

	public Location(int idlocation, String address, String city, String typeoflocation, String worktype) {
	
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
		return idlocation + "\t"+ address + "\t" + city + "\t" + typeoflocation + "\t" + worktype;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (idlocation != other.idlocation)
			return false;
		if (typeoflocation == null) {
			if (other.typeoflocation != null)
				return false;
		} else if (!typeoflocation.equals(other.typeoflocation))
			return false;
		if (worktype == null) {
			if (other.worktype != null)
				return false;
		} else if (!worktype.equals(other.worktype))
			return false;
		return true;
	}
	
	
	
	//ci riserviamo di implementare il metodo equals in futuro se servirà
	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if
//	}
	
	
	
	}//fine classe
	

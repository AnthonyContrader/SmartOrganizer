package it.contrader.model;

public class Location {
	private int idlocation;
	private String 	adress,
					city,
					typeoflocation,
					worktype;
	
	public Location() {}

	public Location(String adress, String city, String typeoflocation, String worktype) {
		super();
		this.adress = adress;
		this.city = city;
		this.typeoflocation = typeoflocation;
		this.worktype = worktype;
	}

	public Location(int idlocation, String adress, String city, String typeoflocation, String worktype) {
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
		return idlocation + "\t"+ adress + "\t" + city + "\t" + typeoflocation + "\t" + worktype;
	}
	
	
	
	//ci riserviamo di implementare il metodo equals in futuro se servirà
	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if
//	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (idlocation != other.idlocation)
			return false;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
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
	
	
	}//fine classe
	

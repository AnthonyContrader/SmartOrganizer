package it.contrader.model;

import java.sql.Date;

public class Bill {

	private int idbill;

	private int numberbill;
	
	public Date date;
	
	private String customer;
	
	private float price;
	
	private String location;

	public Bill() {
		
	}

	public Bill (int numberbill, Date date, String customer, float price, String location) {
		this.numberbill = numberbill;
		this.date = date;
		this.customer = customer;
		this.price = price;
		this.location = location;
	}

	public Bill (int idbill, int numberbill, Date date, String customer, float price, String location) {
		this.idbill = idbill;
		this.numberbill = numberbill;
		this.date = date;
		this.customer = customer;
		this.price = price;
		this.location = location;
	}
	
	public int getIdbill() {
		return idbill;
	}

	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

	public int getNumberbill() {
		return numberbill;
	}

	public void setNumberbill(int numberbill) {
		this.numberbill = numberbill;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
//Metodo per il confronto degli oggetti
	@Override
	public String toString() {
		return idbill + "\t" + numberbill + "\t" + date + "\t" + price + "\t" + customer + "\t" + location;
		
	}
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Bill other = (Bill)obj;
		if(idbill != other.getIdbill())
			return false;
		if(numberbill != other.numberbill) {
				return false;
		}else if(numberbill==(other.numberbill))
					return false;
		if(date == null) {
			if(other.date != null)
				return false;
		}else if(!date.equals(other.date))
					return false;
		if(price != other.price) {
				return false;
		}else if(price ==(other.price))
					return false;
		if(customer == null) {
			if(other.customer != null)
				return false;
		}else if(!customer.equals(other.customer))
					return false;
		if(location == null) {
			if(other.location != null)
				return false;
		}else if(!location.equals(other.location))
					return false;
		return true;
	}


	
}

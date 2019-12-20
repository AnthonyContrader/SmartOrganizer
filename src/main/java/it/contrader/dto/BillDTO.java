package it.contrader.dto;

import java.sql.Date;

public class BillDTO {

	private int idbill;
	private int numberbill;
	private Date date;
	private String customer;
	private Float price;
	private String location;
	
	public BillDTO() {
		
	}
	
	public BillDTO(int numberbill, Date date, String customer, Float price, String location) {
		this.numberbill = numberbill;
		this.date = date;
		this.customer = customer;
		this.price = price;
		this.location = location;
	}
	
	public BillDTO(int idbill,int numberbill, Date date, String customer, Float price, String location) {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return idbill + "\t" + numberbill + "\t" + date + "\t" + customer + "\t" + price + "\t" + location + "\t";
	}
}

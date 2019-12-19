package it.contrader.dto;

import java.sql.Date;

public class CalendarDTO implements DTO {

	private int idcalendar;
	private Date date;
	private String checkin;
	private String checkout;
	private String employee;
	
	public CalendarDTO() {
		
	}

	public CalendarDTO(Date date, String checkin, String checkout, String employee) {
		this.date = date;
		this.checkin = checkin;
		this.checkout = checkout;
		this.employee = employee;
	}
	
	public CalendarDTO(int idcalendar, Date date, String checkin, String checkout, String employee) {
		this.idcalendar = idcalendar;
		this.date = date;
		this.checkin = checkin;
		this.checkout = checkout;
		this.employee = employee;
	}

	public int getIdcalendar() {
		return idcalendar;
	}
	public void setIdcalendar(int idcalendar) {
		this.idcalendar = idcalendar;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	
	public String toString() {
		return  idcalendar + "\t"  + date.toString() +"\t\t" + checkin + "\t\t" + checkout +"\t\t"+employee;
	}
}

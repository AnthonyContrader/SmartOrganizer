package it.contrader.model;

import java.sql.Date;

public class Calendar {

	private int idcalendar;
	private Date date;
	private String checkin;
	private String checkout;
	private String employee;
	
	public Calendar() {
		
	}

	public Calendar(Date date, String checkin, String checkout, String employee) {
		this.date = date;
		this.checkin = checkin;
		this.checkout = checkout;
		this.employee = employee;
	}
	
	public Calendar(int idcalendar, Date date, String checkin, String checkout, String employee) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if(getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		if (idcalendar != other.idcalendar) 
			return false;
		if (checkin == null) {
			if (other.checkin != null) 
				return false;
		} else if (!checkin.equals(other.checkin)) 
			return false;
		if (checkout == null) {
			if (other.checkout != null) 
				return false;
		} else if (!checkout.equals(other.checkout))
			return false;
		if (date == null) {
			if (other.date != null) 
				return false;
		} else if (!date.equals(other.date)) 
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}
}

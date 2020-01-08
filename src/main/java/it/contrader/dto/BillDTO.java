package it.contrader.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BillDTO {

	private Long idbill;

	private Long numberbill;
	
	private Date date;
	
	private String customer;
	
	private Float price;
	
	private String location;


}
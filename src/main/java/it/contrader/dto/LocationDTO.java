package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationDTO {

	private Long id;

	private String address;

	private String city;

	private String typeoflocation;
	
	private String worktype;


}

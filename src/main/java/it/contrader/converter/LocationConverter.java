package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.LocationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Location;
import it.contrader.model.User;

public class LocationConverter {

	public LocationDTO toDTO(Location location) {
		
		LocationDTO locationDTO = new LocationDTO(location.getIdlocation(), location.getAdress(), location.getCity(), location.getTypeoflocation(), location.getWorktype());
			return locationDTO;
	}//fine LocationDTO
	
	public Location toEntity(LocationDTO locationDTO) {
		Location location = new Location(locationDTO.getIdlocation(), locationDTO.getAdress(), locationDTO.getCity(), locationDTO.getTypeoflocation(), locationDTO.getWorktype());
		return location;
	}//fine entity
	
	public List<LocationDTO> toDTOList(List<Location> locationList) {
		//Crea una lista vuota.
		List<LocationDTO> locationDTOList = new ArrayList<LocationDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Location location : locationList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			
			//userDTOList.add(toDTO(user));
			locationDTOList.add(toDTO(location));
		}
		return locationDTOList;
	}
} //fine classe

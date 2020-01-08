package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.LocationDTO;

import it.contrader.model.Location;


@Component
public class LocationConverter extends AbstractConverter<Location, LocationDTO> {

	@Override
	public Location toEntity(LocationDTO locationDTO) {
		Location location = null;
		if (locationDTO != null) {
			location = new Location(locationDTO.getId(), locationDTO.getAddress(), locationDTO.getCity(), locationDTO.getTypeoflocation(), locationDTO.getWorktype());
		}
		return location;
	}

	@Override
	public LocationDTO toDTO(Location location) {
		LocationDTO locationDTO = null;
		if (location != null) {
			locationDTO = new LocationDTO(location.getId(), location.getAddress(),location.getCity(),location.getTypeoflocation(),location.getWorktype());

		}
		return locationDTO;
	}


	
}
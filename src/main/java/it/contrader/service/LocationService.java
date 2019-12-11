package it.contrader.service;

import java.util.List;

import it.contrader.converter.LocationConverter;
import it.contrader.dao.LocationDAO;
import it.contrader.dto.LocationDTO;
import it.contrader.dto.UserDTO;

public class LocationService {

	private LocationDAO locationDAO;
	private LocationConverter locationConverter;
	
	public LocationService() {
		this.locationDAO = new LocationDAO();
		this.locationConverter = new LocationConverter();
		}
	
	public List<LocationDTO> getAll(){
		return locationConverter.toDTOList(locationDAO.getALL());
	}
	
	public LocationDTO read(int idlocation) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return locationConverter.toDTO(locationDAO.read(idlocation));
	}
	
	public boolean insert(LocationDTO dto) {
		return locationDAO.insert(locationConverter.toEntity(dto));
	}
	
	public boolean update(LocationDTO dto) {
		return locationDAO.update(locationConverter.toEntity(dto));
	}
	
	public boolean delete(int idlocation)
	{
		return locationDAO.delete(idlocation);
	}
}//fine classe

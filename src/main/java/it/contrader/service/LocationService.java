package it.contrader.service;

import it.contrader.converter.LocationConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.LocationDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.LocationDTO;

import it.contrader.model.Location;


public class LocationService extends AbstractService<Location, LocationDTO>{
	public LocationService(){
		this.dao = new LocationDAO();
		this.converter = new LocationConverter();
	}
}

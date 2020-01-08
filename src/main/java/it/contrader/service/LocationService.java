package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.LocationConverter;

import it.contrader.dao.LocationRepository;

import it.contrader.dto.LocationDTO;

import it.contrader.model.Location;


@Service
public class LocationService extends AbstractService<Location, LocationDTO> {

	@Autowired
	private LocationConverter converter;
	@Autowired
	private LocationRepository repository;



}

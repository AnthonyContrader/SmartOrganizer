package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.BillConverter;
import it.contrader.dao.BillRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.BillDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Bill;

@Service
@SuppressWarnings(value = { "unused" })
public class BillService extends AbstractService<Bill, BillDTO> {

	@Autowired
	private BillConverter converter;
	@Autowired
	private BillRepository repository;

	
	

}
package it.contrader.service;

import it.contrader.converter.BillConverter;
import it.contrader.dao.BillDAO;
import it.contrader.dto.BillDTO;
import it.contrader.model.Bill;


public class BillService extends AbstractService<Bill, BillDTO> {
	
	public BillService(){
		this.dao = new BillDAO();
		this.converter = new BillConverter();
	}
	

}

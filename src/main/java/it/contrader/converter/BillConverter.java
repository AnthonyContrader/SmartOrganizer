package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BillDTO;
import it.contrader.model.Bill;


public class BillConverter  implements Converter<Bill, BillDTO> {
	
	@Override
	public BillDTO toDTO(Bill bill) {
		BillDTO billDTO = new BillDTO(bill.getIdbill(), bill.getNumberbill(), bill.getDate() , bill.getCustomer(), bill.getPrice(), bill.getLocation());
		return billDTO;
	}

	@Override
	public Bill toEntity(BillDTO billDTO) {
		Bill bill = new Bill(billDTO.getIdbill(), billDTO.getNumberbill(), billDTO.getDate(), billDTO.getCustomer(), billDTO.getPrice(), billDTO.getLocation());
		return bill;
	}
	
	@Override
	public List<BillDTO> toDTOList(List<Bill> billlist) {
		
		List<BillDTO> billDTOList = new ArrayList<BillDTO>();
		
		for(Bill bill : billlist) {
			billDTOList.add(toDTO(bill));
		}
		return billDTOList;
	}

	
	
}

package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.BillDTO;

import it.contrader.model.Bill;

@Component
public class BillConverter extends AbstractConverter<Bill, BillDTO> {

	@Override
	public Bill toEntity(BillDTO billDTO) {
		Bill bill = null;
		if (billDTO != null) {
			bill = new Bill(billDTO.getIdbill(), billDTO.getNumberbill(), billDTO.getDate(), billDTO.getCustomer(), billDTO.getPrice(), billDTO.getLocation());
		}
		return bill;
	}

	@Override
	public BillDTO toDTO(Bill bill) {
		BillDTO billDTO = null;
		if (bill != null) {
			billDTO = new BillDTO(bill.getIdbill(), bill.getNumberbill(), bill.getDate(), bill.getCustomer(), bill.getPrice(), bill.getLocation());

		}
		return billDTO;
	}
}
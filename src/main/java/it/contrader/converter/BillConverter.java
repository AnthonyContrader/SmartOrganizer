package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.BillDTO;
import it.contrader.model.Bill;

@Component
public class BillConverter extends AbstractConverter<Bill,BillDTO> {

@Autowired
 private LocationConverter converter;

 @Override
	public Bill toEntity(BillDTO billDTO) {
		Bill bill = null;
		if (billDTO != null) {
			bill = new Bill();		
			bill.setId(billDTO.getId());
			bill.setCustomer(billDTO.getCustomer());
			bill.setDate(billDTO.getDate());
			if(billDTO.getLocation()!= null) {
				bill.setLocation(converter.toEntity(billDTO.getLocation()));
			}
			
			bill.setNumberbill(billDTO.getNumberbill());
			bill.setPrice(billDTO.getPrice());
		
		}
		return bill;
	}

	@Override
	public BillDTO toDTO(Bill bill) {
		BillDTO billDTO = null;
		if (bill != null) {
			billDTO = new BillDTO();
			billDTO.setId(bill.getId());
			billDTO.setCustomer(bill.getCustomer());
			billDTO.setDate(bill.getDate());
			if(bill.getLocation()!= null) {
				billDTO.setLocation(converter.toDTO(bill.getLocation()));
			}
			billDTO.setNumberbill(bill.getNumberbill());
			billDTO.setPrice(bill.getPrice());
			
			
		}
		return billDTO;
	}
}
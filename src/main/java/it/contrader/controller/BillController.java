package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.BillDTO;
import it.contrader.service.BillService;


@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController extends AbstractController<BillDTO> {

	@Autowired
	private BillService billService;
	
}
package it.contrader.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.BillDTO;
import it.contrader.service.BillService;

@Controller
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService service;

	

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "bill/bills";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idbill") Long idbill) {
		service.delete(idbill);
		setAll(request);
		return "bill/bills";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idbill") Long idbill) {
		request.getSession().setAttribute("dto", service.read(idbill));
		return "bill/updatebill";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idbill") Long idbill, @RequestParam("numberbill") Long numberbill,
			@RequestParam("date") Date date, @RequestParam("customer") String customer, @RequestParam("price") Float price, @RequestParam("location") String location) {
        BillDTO dto = new BillDTO();
		dto.setIdbill(idbill);
		dto.setNumberbill(numberbill);
		dto.setDate(date);
		dto.setCustomer(customer);
		dto.setPrice(price);
		dto.setLocation(location);
		service.update(dto);
		setAll(request);
		return "bill/bills";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("numberbill") Long numberbill,
			@RequestParam("date") Date date, @RequestParam("customer") String customer, @RequestParam("price") Float price, @RequestParam("location") String location) {
		BillDTO dto = new BillDTO();
		dto.setNumberbill(numberbill);
		dto.setDate(date);
		dto.setCustomer(customer);
		dto.setPrice(price);
		dto.setLocation(location);
		service.insert(dto);
		setAll(request);
		return "bill/bills";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idbill") Long idbill) {
		request.getSession().setAttribute("dto", service.read(idbill));
		return "bill/readbill";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.service.WorkgroupService;

@RestController
@RequestMapping("/workgroup")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkgroupController extends AbstractController<WorkgroupDTO>{
	
	@Autowired
	private WorkgroupService workgroupservice;

}

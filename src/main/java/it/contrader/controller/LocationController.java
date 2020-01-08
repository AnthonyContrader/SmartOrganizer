package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.LocationDTO;

import it.contrader.service.LocationService;



@Controller
@RequestMapping("/location")

public class LocationController {

@Autowired
private LocationService service;

	
@GetMapping("/getall")
public String getAll(HttpServletRequest request) {
	setAll(request);
	return "location/locations";
}	

@GetMapping("/delete")
public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
	service.delete(id);
	setAll(request);
	return "location/locations";
}

@GetMapping("/preupdate")
public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "location/updatelocation";
}

@PostMapping("/update")
public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("address") String address,
		@RequestParam("city") String city, @RequestParam("typeoflocation") String typeoflocation, @RequestParam("worktype") String worktype) {

	LocationDTO dto = new LocationDTO();
	dto.setId(id);
	dto.setAddress(address);
	dto.setCity(city);
	dto.setTypeoflocation(typeoflocation);
	dto.setWorktype(worktype);
	service.update(dto);
	setAll(request);
	return "location/locations";

}

@PostMapping("/insert")
public String insert(HttpServletRequest request, @RequestParam("address") String address,
		@RequestParam("city") String city, @RequestParam("typeoflocation") String typeoflocation, @RequestParam("worktype") String worktype) {
	LocationDTO dto = new LocationDTO();
	dto.setAddress(address);
	dto.setCity(city);
	dto.setTypeoflocation(typeoflocation);
	dto.setWorktype(worktype);
	service.insert(dto);
	setAll(request);
	return "location/locations";
}

@GetMapping("/read")
public String read(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "location/readlocation";
}

@GetMapping("/logout")
public String logout(HttpServletRequest request) {
	request.getSession().invalidate();
	return "index";
}

private void setAll(HttpServletRequest request) {
	request.getSession().setAttribute("list", service.getAll());
}
	
}//fine classe LocationController

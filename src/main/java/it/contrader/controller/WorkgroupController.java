package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.service.WorkgroupService;

@Controller
@RequestMapping("/workgroup")


public class WorkgroupController {

	@Autowired
private WorkgroupService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request)
	{
		setAll(request);
		return "workgroup/workgroups";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idworkgroup") Long idworkgroup) {
		service.delete(idworkgroup);
		setAll(request);
		return "workgroup/workgroups";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request,@RequestParam("idworkgroup") Long idworkgroup)
	{
		request.getSession().setAttribute("dto", service.read(idworkgroup));
		return "workgroup/updateworkgroup";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idworkgroup") Long idworkgroup,@RequestParam("name")String name, @RequestParam("responsible") String responsible, @RequestParam("work") String work) {
		WorkgroupDTO dto = new WorkgroupDTO();
		dto.setIdworkgroup(idworkgroup);
		dto.setName(name);
		dto.setResponsible(responsible);
		dto.setWork(work);
		service.update(dto);
		setAll(request);
		return "workgroup/workgroups";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("responsible") String responsible, @RequestParam("work") String work)
	{
		WorkgroupDTO dto= new WorkgroupDTO();
		dto.setName(name);
		dto.setResponsible(responsible);
		dto.setWork(work);
		service.insert(dto);
		setAll(request);
		
		return "workgroup/workgroups";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request,@RequestParam("idworkgroup") Long idworkgroup) {
		request.getSession().setAttribute("dto", service.read(idworkgroup));
		return "workgroup/readworkgroup";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
}//fine classe

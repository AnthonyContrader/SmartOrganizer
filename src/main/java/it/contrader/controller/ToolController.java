package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ToolDTO;
import it.contrader.service.ToolService;

@Controller
@RequestMapping("/tool")
public class ToolController {
	
	@Autowired
	private ToolService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/tool/tools";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idtool") Long idtool) {
		service.delete(idtool);
		setAll(request);
		return "/tool/tools";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idtool") Long idtool) {
		request.getSession().setAttribute("dto", service.read(idtool));
		return "/tool/updatetool";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idtool") Long idtool, @RequestParam("toolname") String toolname,
			@RequestParam("rawmaterial") String rawmaterial) {
		ToolDTO dto = new ToolDTO();
		dto.setIdtool(idtool);
		dto.setToolname(toolname);
		dto.setRawmaterial(rawmaterial);
		service.update(dto);
		setAll(request);
		return "/tool/tools";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("toolname") String toolname,
			@RequestParam("rawmaterial") String rawmaterial) {
		ToolDTO dto = new ToolDTO();
		dto.setToolname(toolname);
		dto.setRawmaterial(rawmaterial);
		service.insert(dto);
		setAll(request);
		return "/tool/tools";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idtool") Long idtool) {
		request.getSession().setAttribute("dto", service.read(idtool));
		return "/tool/readtool";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

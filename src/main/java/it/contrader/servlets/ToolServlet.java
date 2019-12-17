package it.contrader.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ToolDTO;
import it.contrader.service.Service;
import it.contrader.service.ToolService;

public class ToolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ToolServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ToolDTO> service = new ToolService();
		List<ToolDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ToolDTO> service = new ToolService();
		String mode = request.getParameter("mode");
		ToolDTO dto;
		int idtool;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		case "TOOLLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
			
		case "READ":
			idtool = Integer.parseInt(request.getParameter("idtool"));
			dto = service.read(idtool);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null) 
				getServletContext().getRequestDispatcher("/tool/readtool.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/tool/updatetool.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String toolname = request.getParameter("toolname").toString();
			String rawmaterial = request.getParameter("rawmaterial").toString();
			dto = new ToolDTO(toolname,rawmaterial);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			toolname = request.getParameter("toolname").toString();
			rawmaterial = request.getParameter("rawmaterial").toString();
			idtool = Integer.parseInt(request.getParameter("idtool"));
			dto = new ToolDTO(idtool, toolname, rawmaterial);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			idtool = Integer.parseInt(request.getParameter("idtool"));
			ans = service.delete(idtool);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
		}
	}
}

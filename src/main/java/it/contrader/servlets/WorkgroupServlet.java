package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.WorkgroupDTO;
import it.contrader.service.WorkgroupService;
import it.contrader.service.Service;

public class WorkgroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkgroupServlet() {}
	
	public void updateList(HttpServletRequest request)
	{
		Service<WorkgroupDTO> service = new WorkgroupService();
		List<WorkgroupDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Service<WorkgroupDTO> service = new WorkgroupService();
		String mode = request.getParameter("mode");
		WorkgroupDTO dto;
		int idworkgroup;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "WORKGROUPLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/workgroup/workgroupmanager.jsp").forward(request, response);
			break;
			
		case "READ":
			idworkgroup = Integer.parseInt(request.getParameter("idworkgroup"));
			dto = service.read(idworkgroup);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update")==null){
				getServletContext().getRequestDispatcher("/workgroup/readworkgroup.jsp").forward(request, response);
			}
			
			else getServletContext().getRequestDispatcher("/workgroup/updateworkgroup.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			
			String name = request.getParameter("name").toString();
			String members = request.getParameter("members").toString();
			String responsible = request.getParameter("responsible").toString();
			String work = request.getParameter("work").toString();
			dto= new WorkgroupDTO(name, members, responsible, work);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/workgroup/workgroupmanager.jsp").forward(request, response);
		break;
		
		
		case "UPDATE":
			name = request.getParameter("name").toString();
			members = request.getParameter("members").toString();
			responsible = request.getParameter("responsible").toString();
			work = request.getParameter("work").toString();
			idworkgroup = Integer.parseInt(request.getParameter("idworkgroup"));
			dto = new WorkgroupDTO(idworkgroup, name, members, responsible, work);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/workgroup/workgroupmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			idworkgroup = Integer.parseInt(request.getParameter("idworkgroup"));
			ans = service.delete(idworkgroup);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/workgroup/workgroupmanager.jsp").forward(request, response);
			break;	
			
			
		}//fine switch
	}//fine service
	
	
}//fine classe

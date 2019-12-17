package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.EmployeesDTO;
import it.contrader.service.Service;
import it.contrader.service.EmployeesService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeesServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EmployeesDTO> service = new EmployeesService();
		List<EmployeesDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EmployeesDTO> service = new EmployeesService();
		String mode = request.getParameter("mode");
		EmployeesDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "EMPLOYEESLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/employees/employeesmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/employees/reademployees.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/employees/updateemployees.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String surname = request.getParameter("surname").toString();
			String fiscalcode = request.getParameter("fiscalcode").toString();
			String worksector = request.getParameter("worksector").toString();
			String position = request.getParameter("position").toString();
			String numberofregistration = request.getParameter("numberofregistration").toString();
			dto = new EmployeesDTO (name,surname,fiscalcode, worksector, position, numberofregistration);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/employees/employeesmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			fiscalcode = request.getParameter("fiscalcode");
			worksector = request.getParameter("worksector");
			position = request.getParameter("position");
			numberofregistration = request.getParameter("numberofregistration");
			id = Integer.parseInt(request.getParameter("idemployee"));
			dto = new EmployeesDTO (id,name, surname, fiscalcode, worksector, position, numberofregistration);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/employees/employeesmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/employees/employeesmanager.jsp").forward(request, response);
			break;
		}
	}
}
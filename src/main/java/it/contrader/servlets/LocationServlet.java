package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.LocationDTO;
import it.contrader.service.LocationService;
import it.contrader.service.Service;

public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocationServlet() {}
	
	public void updateList(HttpServletRequest request)
	{
		Service<LocationDTO> service = new LocationService();
		List<LocationDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Service<LocationDTO> service = new LocationService();
		String mode = request.getParameter("mode");
		LocationDTO dto;
		int idlocation;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "LOCATIONLIST":
			updateList(request);
			boolean usermode = Boolean.parseBoolean((request.getParameter("usermode")));
			if(!usermode)
				getServletContext().getRequestDispatcher("/location/locationmanager.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/location/locationmanager2.jsp").forward(request, response);
			break;
			
		case "READ":
			idlocation = Integer.parseInt(request.getParameter("idlocation"));
			dto = service.read(idlocation);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update")==null){
				getServletContext().getRequestDispatcher("/location/readlocation.jsp").forward(request, response);
			}
			
			else getServletContext().getRequestDispatcher("/location/updatelocation.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			
			String address = request.getParameter("address").toString();
			String city = request.getParameter("city").toString();
			String typeoflocation = request.getParameter("typeoflocation").toString();
			String worktype = request.getParameter("worktype").toString();
			dto= new LocationDTO(address, city, typeoflocation, worktype);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/location/locationmanager.jsp").forward(request, response);
		break;
		
		
		case "UPDATE":
			address = request.getParameter("address").toString();
			city = request.getParameter("city").toString();
			typeoflocation = request.getParameter("typeoflocation").toString();
			worktype = request.getParameter("worktype").toString();
			idlocation = Integer.parseInt(request.getParameter("idlocation"));
			dto = new LocationDTO(idlocation, address, city, typeoflocation, worktype);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/location/locationmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			idlocation = Integer.parseInt(request.getParameter("idlocation"));
			ans = service.delete(idlocation);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/location/locationmanager.jsp").forward(request, response);
			break;	
			
			
		}//fine switch
	}//fine service
	
	
}//fine classe

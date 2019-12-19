package it.contrader.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CalendarDTO;
import it.contrader.service.CalendarService;
import it.contrader.service.Service;

public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CalendarServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CalendarDTO> service = new CalendarService();
		List<CalendarDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<CalendarDTO> service = new CalendarService();
		String mode = request.getParameter("mode");
		CalendarDTO dto;
		int idcalendar;
		boolean ans;
		
		switch(mode.toUpperCase()) {
		case "CALENDARLIST":
			updateList(request);
			boolean usermode = Boolean.parseBoolean(request.getParameter("usermode"));
			if(!usermode)
				getServletContext().getRequestDispatcher("/calendar/calendarmanager.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/calendar/calendarmanager2.jsp").forward(request, response);
			break;
			
		case "READ":
			idcalendar = Integer.parseInt(request.getParameter("idcalendar"));
			dto = service.read(idcalendar);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null)
				getServletContext().getRequestDispatcher("/calendar/readcalendar.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/calendar/updatecalendar.jsp").forward(request, response);
			break;
			
		case "INSERT":
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date time = null;
			try {
				time = sdf.parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
			String employee = request.getParameter("employee");
			Date date = new Date(time.getTime());
			dto = new CalendarDTO(date, checkin, checkout, employee);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/calendar/calendarmanager.jsp").forward(request, response);
			break;
		
		case "UPDATE":
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			time = null;
			try {
				time = sdf.parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			date = new Date(time.getTime());
			checkin = request.getParameter("checkin");
			checkout = request.getParameter("checkout");
			employee = request.getParameter("employee");
			idcalendar = Integer.parseInt(request.getParameter("idcalendar"));
			dto = new CalendarDTO(idcalendar, date, checkin, checkout, employee);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/calendar/calendarmanager.jsp").forward(request, response);
			break;
		
		case "DELETE":
			idcalendar = Integer.parseInt(request.getParameter("idcalendar"));
			ans = service.delete(idcalendar);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/calendar/calendarmanager.jsp").forward(request, response);
			break;
		}
	}
}

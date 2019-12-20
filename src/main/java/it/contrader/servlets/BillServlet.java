package it.contrader.servlets;


import java.util.List;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.BillDTO;
import it.contrader.service.Service;
import it.contrader.service.BillService;

public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BillServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<BillDTO> service = new BillService();
		List<BillDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<BillDTO> service = new BillService();
		String mode = request.getParameter("mode");
		BillDTO dto;
		int idbill;
		boolean ans;
		switch (mode.toUpperCase()) {

		case "BILLLIST":
			updateList(request);
			boolean usermode = Boolean.parseBoolean((request.getParameter("usermode")));
			if(!usermode)
				getServletContext().getRequestDispatcher("/bill/billmanager.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/bill/billmanager2.jsp").forward(request, response);
			break;

		case "READ":
			idbill = Integer.parseInt(request.getParameter("idbill"));
			dto = service.read(idbill);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/bill/readbill.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/bill/updatebill.jsp").forward(request, response);
			
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
			Date date = new Date(time.getTime());
			int numberbill = Integer.parseInt(request.getParameter("numberbill"));
			String customer = request.getParameter("customer").toString();
			float price = Float.parseFloat(request.getParameter("price").toString());
			String location = request.getParameter("location").toString();
			dto = new BillDTO (numberbill,date,customer, price, location);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/bill/billmanager.jsp").forward(request, response);
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
			numberbill = Integer.parseInt(request.getParameter("numberbill"));
			customer = request.getParameter("customer").toString();
			price = Float.parseFloat(request.getParameter("price").toString());
			location = request.getParameter("location").toString();
			idbill = Integer.parseInt(request.getParameter("idbill"));
			dto = new BillDTO (idbill,numberbill, date, customer, price, location);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/bill/billmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idbill = Integer.parseInt(request.getParameter("idbill"));
			ans = service.delete(idbill);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/bill/billmanager.jsp").forward(request, response);
			break;
		}
	}
}
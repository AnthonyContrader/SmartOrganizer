package it.contrader.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Calendar;
import it.contrader.utils.ConnectionSingleton;

public class CalendarDAO implements DAO<Calendar>{

	private final String QUERY_ALL="SELECT * FROM calendar";
	private final String QUERY_CREATE="INSERT INTO calendar (date, checkin, checkout, employees) VALUES (?, ?, ?, ?)";
	private final String QUERY_READ="SELECT * FROM calendar WHERE idcalendar=?";
	private final String QUERY_UPDATE="UPDATE calendar SET date=?, checkin=? ,checkout=? ,employees=? WHERE idcalendar=?";
	private final String QUERY_DELETE="DELETE FROM calendar WHERE idcalendar=?";
	
	public CalendarDAO() {
		
	}
	
	
	@Override
	public List<Calendar> getAll() {
		List<Calendar> calendarsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Calendar calendar;
			while(resultSet.next()) {
				int idcalendar = resultSet.getInt("idcalendar");
				Date date = resultSet.getDate("date");
				String checkin = resultSet.getString("checkin");
				String checkout = resultSet.getString("checkout");
				String employee = resultSet.getString("employees");
				calendar = new Calendar(idcalendar, date, checkin, checkout, employee);
				calendar.setIdcalendar(idcalendar);
				calendarsList.add(calendar);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return calendarsList;
	}
	
	@Override
	public boolean insert(Calendar calendarToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setDate(1, calendarToInsert.getDate());
			preparedStatement.setString(2, calendarToInsert.getCheckin());
			preparedStatement.setString(3, calendarToInsert.getCheckout());
			preparedStatement.setString(4, calendarToInsert.getEmployee());
			preparedStatement.execute();
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}

	@Override
	public Calendar read(int idcalendar) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idcalendar);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Date date = new Date(resultSet.getDate("date").getTime());
			String checkin = resultSet.getString("checkin");
			String checkout = resultSet.getString("checkout");
			String employee = resultSet.getString("employees");
			
			Calendar calendar = new Calendar(date, checkin, checkout, employee);
			calendar.setIdcalendar(resultSet.getInt("idcalendar"));
			return calendar;
		}
		catch(SQLException e) {
			return null;
		}
	}

	@Override
	public boolean update(Calendar calendarToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(calendarToUpdate.getIdcalendar() == 0)
			return false;
		
		Calendar calendarRead = read(calendarToUpdate.getIdcalendar());
		if(!calendarRead.equals(calendarToUpdate)) {
			try {
				if(calendarToUpdate.getDate() == null || calendarToUpdate.getDate().toString().equals("")) {
					calendarToUpdate.setDate(calendarRead.getDate());
				}
				
				if(calendarToUpdate.getCheckin() == null || calendarToUpdate.getCheckin().equals("")) {
					calendarToUpdate.setCheckin(calendarRead.getCheckin());
				}
				
				if(calendarToUpdate.getCheckout() == null || calendarToUpdate.getCheckout().equals("")) {
					calendarToUpdate.setCheckout(calendarRead.getCheckout());
				}
				
				if(calendarToUpdate.getEmployee() == null || calendarToUpdate.getEmployee().equals("")) {
					calendarToUpdate.setCheckout(calendarRead.getEmployee());
				}
				
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setDate(1, calendarToUpdate.getDate());
				preparedStatement.setString(2, calendarToUpdate.getCheckin());
				preparedStatement.setString(3, calendarToUpdate.getCheckout());
				preparedStatement.setString(4, calendarToUpdate.getEmployee());
				preparedStatement.setInt(5, calendarToUpdate.getIdcalendar());
				int a = preparedStatement.executeUpdate();
				if(a > 0)
					return true;
				else
					return false;
			}
			catch(SQLException e) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(int idcalendar) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idcalendar);
			int n = preparedStatement.executeUpdate();
			if(n != 0)
				return true;
		}
		catch(SQLException e) {
		}
		
		return false;
	}

}

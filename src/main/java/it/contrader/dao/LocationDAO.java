package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Location;


public class LocationDAO {
	private final String QUERY_ALL = "SELECT * FROM location";
	private final String QUERY_CREATE = "INSERT INTO location (address, city, typeoflocation, worktype) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM location WHERE idlocation=?";
	private final String QUERY_UPDATE = "UPDATE location SET address=?, city=?, typeoflocation=?,worktype=? WHERE idlocation=?";
	private final String QUERY_DELETE = "DELETE FROM location WHERE idlocation=?";

	public LocationDAO() {
		
	}
	
	public List<Location> getALL(){
		List<Location> locationList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Location location;
			while(resultSet.next()) {
				int idlocation = resultSet.getInt("idlocation");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String typeoflocation = resultSet.getString("typeoflocation");
				String worktype = resultSet.getString("worktype");
				
				location= new Location(address, city, typeoflocation, worktype);
				location.setIdlocation(idlocation);
				locationList.add(location);
						
			}//fine while
			
		
		
		}//fine try  statement
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("errore in LocationDAO controlla le query connection e result");
			System.out.println("se non trovi l'errore bestemmia");
			e.printStackTrace();
		}//fine Catch statement
	return locationList;
	}//fine getall
	
	public boolean insert(Location locationToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, locationToInsert.getAddress());
			preparedStatement.setString(2, locationToInsert.getCity());
			preparedStatement.setString(3, locationToInsert.getTypeoflocation());
			preparedStatement.setString(4, locationToInsert.getWorktype());
			preparedStatement.execute();
			return true;
		
		} //fine try statement
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\"errore in LocationDAO metodo insert controlla le query connection e result\"");
			return false;
		}//fine catch statement
		
		
	}//fine insert
	
	public Location read(int idlocation) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idlocation);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String address, city, typeoflocation,worktype;

			address = resultSet.getString("address");
			city = resultSet.getString("city");
			typeoflocation = resultSet.getString("typeoflocation");
			worktype = resultSet.getString("worktype");
			
			Location location = new Location(address, city, typeoflocation, worktype);
			location.setIdlocation(resultSet.getInt("idlocation"));

			return location;
		}
		//fine try read
		catch (SQLException e) {
			System.out.println("\"errore in LocationDAO metodo read prova 1 controlla le: query, connection,  result etc \"");
			return null;
		}
			
		}//read
	
	public boolean update(Location locationToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(locationToUpdate.getIdlocation()==0)
			return false;
		
		Location locationRead = read(locationToUpdate.getIdlocation());
		
		//-------------------ATTENZIONE DEVO IMPLEMENTARE EQUALS IN LOCATION MODEL-------------------------------//
		
		if(!locationRead.equals(locationToUpdate))
		{
			try {
			if (locationToUpdate.getAddress() == null || locationToUpdate.getAddress().equals("")) 
			{
				locationToUpdate.setAddress(locationRead.getAddress());
			}
			if (locationToUpdate.getCity() == null || locationToUpdate.getCity().equals("")) 
			{
				locationToUpdate.setCity(locationRead.getCity());
			}
			if (locationToUpdate.getTypeoflocation() == null || locationToUpdate.getTypeoflocation().equals("")) 
			{
				locationToUpdate.setTypeoflocation(locationRead.getTypeoflocation());
			}
			if (locationToUpdate.getWorktype() == null || locationToUpdate.getWorktype().equals("")) 
			{
				locationToUpdate.setWorktype(locationRead.getWorktype());
			}
//update user
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, locationToUpdate.getAddress());
			preparedStatement.setString(2, locationToUpdate.getCity());
			preparedStatement.setString(3, locationToUpdate.getTypeoflocation());
			preparedStatement.setString(4, locationToUpdate.getWorktype());
			preparedStatement.setInt(5, locationToUpdate.getIdlocation());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
			
			}catch (SQLException e) {
				return false;
			}
		}
		return false;
		
	}//update
	
	public boolean delete(int idlocation) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idlocation);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
} //fine classe

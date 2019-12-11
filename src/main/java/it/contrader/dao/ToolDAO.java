package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Tool;

public class ToolDAO {

	private final String QUERY_ALL="SELECT * FROM tools";
	private final String QUERY_CREATE="INSERT INTO tools (toolsname, rawmaterial) VALUES (?, ?)";
	private final String QUERY_READ="SELECT * FROM tools WHERE idtools=?";
	private final String QUERY_UPDATE="UPDATE tools SET toolsname=?, rawmaterial=? WHERE idtools=?";
	private final String QUERY_DELETE="DELETE FROM tools WHERE idtools=?";
	
	public ToolDAO() {
		
	}
	
	public List<Tool> getAll(){
		List<Tool> toolsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tool tool;
			while (resultSet.next()) {
				int idtools = resultSet.getInt("idtools");
				String toolsname = resultSet.getString("toolsname");
				String rawmaterial = resultSet.getString("rawmaterial");
				tool = new Tool(toolsname, rawmaterial);
				tool.setIdtool(idtools);
				toolsList.add(tool);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();;
		}
		return toolsList;
	}
	
	public boolean insert(Tool toolToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, toolToInsert.getToolname());
			preparedStatement.setString(2, toolToInsert.getRawmaterial());
			preparedStatement.execute();
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}
	
	public Tool read(int idtool) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idtool);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String toolsname, rawmaterial;
			
			toolsname = resultSet.getString("toolsname");
			rawmaterial = resultSet.getString("rawmaterial");
			Tool tool = new Tool(toolsname, rawmaterial);
			tool.setIdtool(resultSet.getInt("idtools"));
			
			return tool;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public boolean update(Tool toolToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (toolToUpdate.getIdtool() == 0)
			return false;

		Tool toolRead = read(toolToUpdate.getIdtool());
		if(!toolRead.equals(toolToUpdate)) {
			try {
				if(toolToUpdate.getToolname() == null || toolToUpdate.getToolname().equals("")) {
					toolToUpdate.setToolname(toolRead.getToolname());
				}
				
				if(toolToUpdate.getRawmaterial() == null || toolToUpdate.getRawmaterial().equals("")) {
					toolToUpdate.setRawmaterial(toolRead.getRawmaterial());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, toolToUpdate.getToolname());
				preparedStatement.setString(2, toolToUpdate.getRawmaterial());
				preparedStatement.setInt(3, toolToUpdate.getIdtool());
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
	
	public boolean delete(int idtools) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idtools);
			int n = preparedStatement.executeUpdate();
			if(n != 0)
				return true;
		}
		catch(SQLException e) {
		}
		
		return false;
	}
}

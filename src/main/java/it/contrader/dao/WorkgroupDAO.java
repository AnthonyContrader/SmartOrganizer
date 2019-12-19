package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;

import it.contrader.model.Workgroup;


public class WorkgroupDAO implements DAO<Workgroup>{
	private final String QUERY_ALL = "SELECT * FROM workgroup";
	private final String QUERY_CREATE = "INSERT INTO workgroup (name, members, responsible, work) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM workgroup WHERE idworkgroup=?";
	private final String QUERY_UPDATE = "UPDATE workgroup SET name=?, members=?, responsible=?,work=? WHERE idworkgroup=?";
	private final String QUERY_DELETE = "DELETE FROM workgroup WHERE idworkgroup=?";

	public WorkgroupDAO() {
		
	}
	
	public List<Workgroup> getAll(){
		List<Workgroup> workgroupList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Workgroup workgroup;
			while(resultSet.next()) {
				int idworkgroup = resultSet.getInt("idworkgroup"); 
				String name = resultSet.getString("name");
				String members = resultSet.getString("members");
				String responsible = resultSet.getString("responsible");
				String work = resultSet.getString("work");
				
				workgroup= new Workgroup(name, members, responsible, work);
				workgroup.setIdworkgroup(idworkgroup);
				workgroupList.add(workgroup);
						
			}//fine while
			
		
		
		}//fine try  statement
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("errore in DAO controlla le query connection e result");
			System.out.println("se non trovi l'errore bestemmia");
			e.printStackTrace();
		}//fine Catch statement
	return workgroupList;
	}//fine getall
	
	public boolean insert(Workgroup workgroupToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, workgroupToInsert.getName());
			preparedStatement.setString(2, workgroupToInsert.getMembers());
			preparedStatement.setString(3, workgroupToInsert.getResponsible());
			preparedStatement.setString(4, workgroupToInsert.getWork());
			preparedStatement.execute();
			return true;
		
		} //fine try statement
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\"errore in DAO metodo insert controlla le query connection e result\"");
			return false;
		}//fine catch statement
		
		
	}//fine insert
	// METODO READ
	public Workgroup read(int idworkgroup) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idworkgroup);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			String members;
			String responsible;
			String work;

			name = resultSet.getString("name");
			members = resultSet.getString("members");
			responsible = resultSet.getString("responsible");
			work = resultSet.getString("work");
			
			Workgroup workgroup = new Workgroup(name, members, responsible, work);
			workgroup.setIdworkgroup(resultSet.getInt("idworkgroup"));

			return workgroup;
		}
		//fine try read
		catch (SQLException e) {
			System.out.println("\"errore in workgroupDAO metodo read prova 1 controlla le: query, connection,  result etc \"");
			
			System.out.println(e);
			
			return null;
		}
			
		}//read
	
	public boolean update(Workgroup workgroupToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(workgroupToUpdate.getIdworkgroup()==0)
			return false;
		
		Workgroup workgroupRead = read(workgroupToUpdate.getIdworkgroup());
		
		
		if(!workgroupRead.equals(workgroupToUpdate))
		{
			try {
			if (workgroupToUpdate.getName() == null || workgroupToUpdate.getName().equals("")) 
			{
				workgroupToUpdate.setName(workgroupRead.getName());
			}
			if (workgroupToUpdate.getMembers() == null || workgroupToUpdate.getMembers().equals("")) 
			{
				workgroupToUpdate.setMembers(workgroupRead.getMembers());
			}
			if (workgroupToUpdate.getResponsible() == null || workgroupToUpdate.getResponsible().equals("")) 
			{
				workgroupToUpdate.setResponsible(workgroupRead.getResponsible());
			}
			if (workgroupToUpdate.getWork() == null || workgroupToUpdate.getWork().equals("")) 
			{
				workgroupToUpdate.setWork(workgroupRead.getWork());
			}

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, workgroupToUpdate.getName());
			preparedStatement.setString(2, workgroupToUpdate.getMembers());
			preparedStatement.setString(3, workgroupToUpdate.getResponsible());
			preparedStatement.setString(4, workgroupToUpdate.getWork());
			preparedStatement.setInt(5, workgroupToUpdate.getIdworkgroup());
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
	
	public boolean delete(int idworkgroup) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idworkgroup);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


	
} //fine classe

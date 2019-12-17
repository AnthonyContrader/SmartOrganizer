package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Employees;


public class EmployeesDAO implements DAO<Employees> {

	private final String QUERY_ALL = "SELECT * FROM employees";
	private final String QUERY_CREATE = "INSERT INTO employees (name, surname, fiscalcode, worksector, position, numberofregistration) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM employees WHERE idemployee=?";
	private final String QUERY_UPDATE = "UPDATE employees SET name=?, surname=?, fiscalcode=?, worksector=?, position=?, numberofregistration=? WHERE idemployee=?";
	private final String QUERY_DELETE = "DELETE FROM employees WHERE idemployee=?";

	public EmployeesDAO() {

	}

	public List<Employees> getAll() {
		List<Employees> employeessList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Employees employees;
			while (resultSet.next()) {
				int idemployee = resultSet.getInt("idemployee");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String fiscalcode = resultSet.getString("fiscalcode");
				String worksector = resultSet.getString("worksector");
				String position = resultSet.getString("position");
				String numberofregistration = resultSet.getString("numberofregistration");
				employees = new Employees(name, surname, fiscalcode, worksector, position, numberofregistration);
				employees.setIdemployee(idemployee);
				employeessList.add(employees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeessList;
	}

	public boolean insert(Employees employeesToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, employeesToInsert.getName());
			preparedStatement.setString(2, employeesToInsert.getSurname());
			preparedStatement.setString(3, employeesToInsert.getFiscalcode());
			preparedStatement.setString(4, employeesToInsert.getWorksector());
			preparedStatement.setString(5, employeesToInsert.getPosition());
			preparedStatement.setString(6, employeesToInsert.getNumberofregistration());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Employees read(int idemployee) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idemployee);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, surname, fiscalcode, worksector, position, numberofregistration;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			fiscalcode = resultSet.getString("fiscalcode");
			worksector = resultSet.getString("worksector");
			position = resultSet.getString("position");
			numberofregistration = resultSet.getString("numberofregistration");
			Employees employees = new Employees(name, surname, fiscalcode, worksector, position, numberofregistration);
			employees.setIdemployee(resultSet.getInt("idemployee"));

			return employees;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Employees employeesToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (employeesToUpdate.getIdemployee() == 0)
			return false;

		Employees employeesRead = read(employeesToUpdate.getIdemployee());
		if (!employeesRead.equals(employeesToUpdate)) {
			try {
				// Fill the employeesToUpdate object
				if (employeesToUpdate.getName() == null || employeesToUpdate.getName().equals("")) {
					employeesToUpdate.setName(employeesRead.getName());
				}

				if (employeesToUpdate.getSurname() == null || employeesToUpdate.getSurname().equals("")) {
					employeesToUpdate.setSurname(employeesRead.getSurname());
				}

				if (employeesToUpdate.getFiscalcode() == null || employeesToUpdate.getFiscalcode().equals("")) {
					employeesToUpdate.setFiscalcode(employeesRead.getFiscalcode());
				}
				
				if (employeesToUpdate.getWorksector() == null || employeesToUpdate.getWorksector().equals("")) {
					employeesToUpdate.setWorksector(employeesRead.getWorksector());
				
				}
				
				if (employeesToUpdate.getPosition() == null || employeesToUpdate.getPosition().equals("")) {
					employeesToUpdate.setPosition(employeesRead.getPosition());
				}
				
				if (employeesToUpdate.getNumberofregistration() == null || employeesToUpdate.getNumberofregistration().equals("")) {
					employeesToUpdate.setNumberofregistration(employeesRead.getNumberofregistration());
				}


				// Update the employees
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, employeesToUpdate.getName());
				preparedStatement.setString(2, employeesToUpdate.getSurname());
				preparedStatement.setString(3, employeesToUpdate.getFiscalcode());
				preparedStatement.setString(4, employeesToUpdate.getWorksector());
				preparedStatement.setString(5, employeesToUpdate.getPosition());
				preparedStatement.setString(6, employeesToUpdate.getNumberofregistration());
				preparedStatement.setInt(7, employeesToUpdate.getIdemployee());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int idemployee) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idemployee);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}

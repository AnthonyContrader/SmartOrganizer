package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Employees;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class EmployeesDAO {

	private final String QUERY_ALL = "SELECT * FROM employees";
	private final String QUERY_CREATE = "INSERT INTO employees (name, surname, fiscalcode, worksector, position, numberofregistration) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM employees WHERE idemployee=?";
	private final String QUERY_UPDATE = "UPDATE employees SET name=?, surname=?, fiscalcode=?, worksector=?, position=?, numberofregistration=? WHERE idemployees=?";
	private final String QUERY_DELETE = "DELETE FROM employees WHERE idemployees=?";

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
				int id = resultSet.getInt("id employee");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String fiscalcode = resultSet.getString("fiscalcode");
				String worksector = resultSet.getString("worksector");
				String position = resultSet.getString("position");
				String numberofregistration = resultSet.getString("number of registration");
				employees = new Employees(name, surname, fiscalcode, worksector, position, numberofregistration);
				employees.setId(id);
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
			preparedStatement.setString(3, employeesToInsert.getFiscalCode());
			preparedStatement.setString(3, employeesToInsert.getWorkSector());
			preparedStatement.setString(3, employeesToInsert.getPosition());
			preparedStatement.setString(3, employeesToInsert.getNumberOfRegistration());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Employees read(int employeesId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, employeesId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, surname, fiscalcode, worksector, position, numberofregistration;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			fiscalcode = resultSet.getString("fiscalcode");
			worksector = resultSet.getString("worksector");
			position = resultSet.getString("position");
			numberofregistration = resultSet.getString("number of registration");
			Employees employees = new Employees(name, surname, fiscalcode, worksector, position, numberofregistration);
			employees.setId(resultSet.getInt("id"));

			return employees;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Employees employeesToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (employeesToUpdate.getId() == 0)
			return false;

		Employees employeesRead = read(employeesToUpdate.getId());
		if (!employeesRead.equals(employeesToUpdate)) {
			try {
				// Fill the employeesToUpdate object
				if (employeesToUpdate.getName() == null || employeesToUpdate.getName().equals("")) {
					employeesToUpdate.setName(employeesRead.getName());
				}

				if (employeesToUpdate.getSurname() == null || employeesToUpdate.getSurname().equals("")) {
					employeesToUpdate.setSurname(employeesRead.getSurname());
				}

				if (employeesToUpdate.getFiscalCode() == null || employeesToUpdate.getFiscalCode().equals("")) {
					employeesToUpdate.setFiscalCode(employeesRead.getFiscalCode());
				}
				
				if (employeesToUpdate.getWorkSector() == null || employeesToUpdate.getWorkSector().equals("")) {
					employeesToUpdate.setWorkSector(employeesRead.getWorkSector());
				
				}
				
				if (employeesToUpdate.getPosition() == null || employeesToUpdate.getPosition().equals("")) {
					employeesToUpdate.setPosition(employeesRead.getPosition());
				}
				
				if (employeesToUpdate.getNumberOfRegistration() == null || employeesToUpdate.getNumberOfRegistration().equals("")) {
					employeesToUpdate.setNumberOfRegistration(employeesRead.getNumberOfRegistration());
				}


				// Update the employees
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, employeesToUpdate.getName());
				preparedStatement.setString(2, employeesToUpdate.getSurname());
				preparedStatement.setString(3, employeesToUpdate.getFiscalCode());
				preparedStatement.setString(3, employeesToUpdate.getWorkSector());
				preparedStatement.setString(3, employeesToUpdate.getPosition());
				preparedStatement.setString(3, employeesToUpdate.getNumberOfRegistration());
				preparedStatement.setInt(4, employeesToUpdate.getId());
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

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}

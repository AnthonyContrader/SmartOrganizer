package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Bill;


public class BillDAO implements DAO<Bill> {

	private final String QUERY_ALL = "SELECT * FROM bill";
	private final String QUERY_CREATE = "INSERT INTO bill (numberbill, date, customer, price, location) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM bill WHERE idbill=?";
	private final String QUERY_UPDATE = "UPDATE bill SET numberbill=?, date=?, customer=?, price=?, location=? WHERE idbill=?";
	private final String QUERY_DELETE = "DELETE FROM bill WHERE idbill=?";

	public BillDAO() {

	}

	public List<Bill> getAll() {
		List<Bill> billlist = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Bill bill;
			while (resultSet.next()) {
				int idbill = resultSet.getInt("idbill");
				int numberbill = resultSet.getInt("numberbill");
				Date date = resultSet.getDate("date");
				String customer = resultSet.getString("customer");
				float price = resultSet.getFloat("price");
				String location = resultSet.getString("location");
				bill = new Bill(idbill,numberbill, date, customer, price, location);
				bill.setIdbill(idbill);
				billlist.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billlist;
	}

	public boolean insert(Bill billToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, billToInsert.getNumberbill());
			preparedStatement.setDate(2, billToInsert.getDate());
			preparedStatement.setString(3, billToInsert.getCustomer());
			preparedStatement.setFloat(4, billToInsert.getPrice());
			preparedStatement.setString(5, billToInsert.getLocation());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Bill read(int idbill) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idbill);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String customer, location;
			int numberbill;
			Float price;
			Date date;

			numberbill = resultSet.getInt("numberbill");
			date = resultSet.getDate("date");
			customer = resultSet.getString("customer");
			price = resultSet.getFloat("price");
			location = resultSet.getString("location");
			Bill bill = new Bill(numberbill, date, customer, price, location);
			bill.setIdbill(resultSet.getInt("idbill"));

			return bill;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Bill billToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (billToUpdate.getIdbill() == 0)
			return false;

		Bill billRead = read(billToUpdate.getIdbill());
		if (!billRead.equals(billToUpdate)) {
			try {
				// Fill the employeesToUpdate object
				if (billToUpdate.getNumberbill() == 0) {
					billToUpdate.setNumberbill(billRead.getNumberbill());
				}

				if (billToUpdate.getDate() == null || billToUpdate.getDate().equals("")) {
					billToUpdate.setDate(billRead.getDate());
				}

				if (billToUpdate.getCustomer() == null || billToUpdate.getCustomer().equals("")) {
					billToUpdate.setCustomer(billRead.getCustomer());
				}
				
				if (billToUpdate.getPrice() == 0) {
					billToUpdate.setPrice(billRead.getPrice());
				
				}
				
				if (billToUpdate.getLocation() == null || billToUpdate.getLocation().equals("")) {
					billToUpdate.setLocation(billRead.getLocation());
				}


				// Update the employees
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, billToUpdate.getNumberbill());
				preparedStatement.setDate(2, billToUpdate.getDate());
				preparedStatement.setString(3, billToUpdate.getCustomer());
				preparedStatement.setFloat(4, billToUpdate.getPrice());
				preparedStatement.setString(5, billToUpdate.getLocation());
				preparedStatement.setInt(6, billToUpdate.getIdbill());
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

	public boolean delete(int idbill) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idbill);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}

package com.daoclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojoclass.Request;

public class RequestDao {
	String url = "jdbc:postgresql://localhost:5432/myproject";
	String username = "sreedhar";
	String password = "123456";

	public void createRequest(Request request) {
		String isActive = "Yes";
		String query = "insert into requests(name,email,message,isActive) values(?,?,?,?);";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, request.getName());
			statement.setString(2, request.getEmail());
			statement.setString(3, request.getMessage());
			statement.setString(4, isActive);
			statement.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Request> getArchivedUserRequests() {
		String query = "select * from requests where isActive='No';";
		List<Request> getArchivedUserRequests = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Request request = new Request();
				request.setId(resultSet.getInt(1));
				request.setName(resultSet.getString(2));
				request.setEmail(resultSet.getString(3));
				request.setMessage(resultSet.getString(4));
				request.setIsActive(resultSet.getString(5));

				getArchivedUserRequests.add(request);
			}
			return getArchivedUserRequests;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Request> getActiveUserRequests() {
		String query = "select * from requests where isActive='Yes';";
		List<Request> getActiveUserRequests = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Request request = new Request();
				request.setId(resultSet.getInt(1));
				request.setName(resultSet.getString(2));
				request.setEmail(resultSet.getString(3));
				request.setMessage(resultSet.getString(4));
				request.setIsActive(resultSet.getString(5));

				getActiveUserRequests.add(request);
			}
			return getActiveUserRequests;
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return null;
	}

	public void updateStatus(Integer id) {
		String query = "Update requests set isActive='No' where id=?";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

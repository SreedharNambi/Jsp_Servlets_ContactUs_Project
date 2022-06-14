package com.daoclass;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojoclass.User;

public class UserDao {
	String url = "jdbc:postgresql://localhost:5432/myproject";
	String username = "sreedhar";
	String password = "123456";

	public boolean validateAdmin(User user) {
		String query = "select * from admindetails where username= ? and password=?;";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

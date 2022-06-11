package com.myproject;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	String url = "jdbc:postgresql://localhost:5432/myproject";
	String user = "sreedhar";
	String password1 = "123456";

	public boolean validateAdmin(User userObject) {

		String Query = "select * from admindetails where username= ? and password=?;";

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password1);
			PreparedStatement statement = con.prepareStatement(Query);
			statement.setString(1, userObject.getUsername());
			statement.setString(2, userObject.getPassword());

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}

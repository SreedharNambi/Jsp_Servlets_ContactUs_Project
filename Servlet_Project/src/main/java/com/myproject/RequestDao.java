package com.myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RequestDao {

	String url = "jdbc:postgresql://localhost:5432/myproject";
	String username = "sreedhar";
	String password = "123456";

	public void createRequest(Request requestObject) {

		String status = "1";

		String Query = "insert into contactinfo(name,email,message,status) values(?,?,?,?);";

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(Query);

			st.setString(1, requestObject.getName());
			st.setString(2, requestObject.getEmail());
			st.setString(3, requestObject.getMessage());
			st.setString(4, status);

			st.executeUpdate();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Request> getArchievedUserRequestsData() {

		String Query = "select * from contactinfo where status='0';";
		ArrayList<Request> getArchievedUserRequests = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				Request req = new Request();
				req.setId(rs.getInt(1));
				req.setName(rs.getString(2));
				req.setEmail(rs.getString(3));
				req.setMessage(rs.getString(4));
				req.setStatus(rs.getString(5));

				getArchievedUserRequests.add(req);

			}
			return getArchievedUserRequests;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Request> getActiveUserRequestsData() {

		String Query = "select * from contactinfo where status='1';";
		ArrayList<Request> getActiveUserRequests = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while (rs.next()) {
				Request req = new Request();
				req.setId(rs.getInt(1));
				req.setName(rs.getString(2));
				req.setEmail(rs.getString(3));
				req.setMessage(rs.getString(4));
				req.setStatus(rs.getString(5));

				getActiveUserRequests.add(req);

			}
			return getActiveUserRequests;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void updateStatus(int id) {
		String Query = "Update contactinfo set status='0' where id=?";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setLong(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

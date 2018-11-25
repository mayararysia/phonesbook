package com.phonesbook.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactorySpec {
	private static ConnectionFactory CONNECTION;
	
	public ConnectionFactorySpec() {
		this.CONNECTION = new ConnectionFactory();
	}
	
	public static void main(String[] args) throws SQLException {
		try {
			Connection connection = CONNECTION.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from contacts;");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			System.out.println("Connection successfully!");
			CONNECTION.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

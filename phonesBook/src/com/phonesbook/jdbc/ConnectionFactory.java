package com.phonesbook.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection CONNECTION = null;
	private static String DB_USER = "root";
	private static String DB_PW = "";
	private static String DB_URL = "localhost:3306/phones_book?useTimezone=true&serverTimezone=UTC";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONNECTION = DriverManager.getConnection("jdbc:mysql://"+DB_URL, DB_USER, DB_PW);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return CONNECTION;
	}
	
	public static void closeConnection() {
		if (CONNECTION != null) {
			try {
				CONNECTION.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

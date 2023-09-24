package com.oms.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/code_fury_database";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
}

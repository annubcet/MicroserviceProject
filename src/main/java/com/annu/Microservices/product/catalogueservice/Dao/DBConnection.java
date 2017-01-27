package com.annu.Microservices.product.catalogueservice.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("org.h2.Driver");
	con=DriverManager.getConnection("jdbc:h2:E:\\MyWork\\h2;AUTO_SERVER=TRUE","sa","");
	
	return con;
	}
	
}

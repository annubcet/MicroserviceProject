package com.annu.Microservices.product.catalogueservice.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DBConnection {

	
	private static Connection con;
	@Bean
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("org.h2.Driver");
	con=DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1","sa","");
	
	return con;
	}
	
}

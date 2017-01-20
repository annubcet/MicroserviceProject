package com.annu.Microservices.product.catalogueservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.annu.Microservices.product.catalogue.dto.Product;
import com.annu.Microservices.product.catalogueservice.Dao.DBConnection;



public class ServiceImplimentation {

/*	public static void main(String args[])
	{
		ServiceImplimentation imp= new ServiceImplimentation();
		imp.createTable();
		int i=imp.addProduct(new Product(1,"AlmondOil","bajaj",70,"BajajHairoil","haircare"));
		System.out.println(i);
		Product prod=imp.getProductPrice(new Product(1,"AlmondOil","bajaj",70,"BajajHairoil","haircare"));
		System.out.println(prod.getPrice());
		
		
	}*/
	
	public ServiceImplimentation()
	{
		
	}
	
	public void createTable()
	{
		
		Connection con=null;
		Statement statement=null;
		PreparedStatement pst=null;
		boolean i =false;
		try {			
	    con = DBConnection.getConnection();			
		String query="create table product(productCode int,name varchar(20),brand  varchar(20),price int,manufacturer varchar(20),category  varchar(20))";
		pst=con.prepareStatement(query);
	    i=pst.execute();
	     
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();			
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				con.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public int addProduct(Product product) 
	{
		Connection con=null;
		Statement statement=null;
		PreparedStatement pst=null;
		int i =0;
		try {			
	    con = DBConnection.getConnection();			
		String query="insert into product values(?,?,?,?,?,?)";
		pst=con.prepareStatement(query);

		pst.setInt(1, product.getProductCode());
		pst.setString(2, product.getName());
		pst.setString(3, product.getBrand());
		pst.setInt(4, product.getPrice());
		pst.setString(5, product.getManufacturer());
		pst.setString(6, product.getCategory());
	     i=pst.executeUpdate();
	     
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();			
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				con.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return i;
		
	}
	
	
	
	public Product retriveProduct(int id)
	{
		int productCode=0;
		 String name=null;
		String brand=null;
		int price=0;
		String manufacturer=null;
		String category=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		//Product retrivedProduct= new Product();
		Product retrivedProduct=new Product(productCode, name, brand, price, manufacturer, category);
		try{
		con=DBConnection.getConnection();
		String query="Select * from Product where productcode=?";
		pst=con.prepareStatement(query);
		pst.setInt(1,id);
		rs=pst.executeQuery();
		
		while(rs.next())
		{
			retrivedProduct.setProductCode(rs.getInt(1));
			retrivedProduct.setName(rs.getString(2));
			retrivedProduct.setBrand(rs.getString(3));
			retrivedProduct.setPrice(rs.getInt(4));
			retrivedProduct.setManufacturer(rs.getString(5));
			retrivedProduct.setCategory(rs.getString(6));
		}
		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
		 e.printStackTrace();	
		}finally{
			try {
				pst.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return retrivedProduct;
		
	}
	

public int deleteProduct(int productId)
{
	Connection con=null;
	PreparedStatement pst=null;
	int i=0;
	try{
	con=DBConnection.getConnection();
	String query="delete from Product where productcode=?";
	pst=con.prepareStatement(query);
	pst.setInt(1, productId);
	i=pst.executeUpdate();
		
	}catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}catch(SQLException e)
	{
	 e.printStackTrace();	
	}finally{
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return i;
	
}

public Product getProductPrice(Product product)
{
	int productCode=0;
	 String name=null;
	String brand=null;
	int price=0;
	String manufacturer=null;
	String category=null;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	//Product retrivedProduct= new Product();
	Product retrivedProduct=new Product(productCode, name, brand, price, manufacturer, category);
	try{
	con=DBConnection.getConnection();
	String query="Select price from Product where productcode=?";
	pst=con.prepareStatement(query);
	pst.setInt(1, product.getProductCode());
	rs=pst.executeQuery();
	
	while(rs.next())
	{
		retrivedProduct.setPrice(rs.getInt(1));

	}
	
	}catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}catch(SQLException e)
	{
	 e.printStackTrace();	
	}finally{
		try {
			pst.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return retrivedProduct;
	
}



}

package com.annu.Microservices.product.catalogue.dto;

public class Product {

	private int productCode;
	private String name;
	private String brand;
	private int price;
	private String manufacturer;
	private String category;
	
	public Product()
	{
		
	}
	public Product(int productCode,String name,String brand,int price,String manufacturer,String category)
	{
		this.productCode=productCode;
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.manufacturer=manufacturer;
		this.category=category;
	}

	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}

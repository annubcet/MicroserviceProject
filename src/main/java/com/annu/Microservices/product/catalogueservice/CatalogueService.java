package com.annu.Microservices.product.catalogueservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annu.Microservices.product.catalogue.dto.Product;

@RestController
public class CatalogueService {

	@Autowired
	protected ServiceImplimentation impl;
	
	@Autowired
	public CatalogueService(ServiceImplimentation impl) {
		this.impl=impl;
	}
	 
	@RequestMapping(value="/CatalogueService/addProduct",method=RequestMethod.POST)
	public String addProduct(@RequestBody Product product)
	{
		impl.createTable();
		int i=impl.addProduct(product);
		return "no of product added:"+i+"Product name:"+product.getName();
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/CatalogueService/retriveProduct/{id}",method=RequestMethod.GET)
	public List<Product> retriveProduct(@PathVariable int productId)	
	{
		
		return (List<Product>) impl.retriveProduct(productId);
		
	}
	
    @RequestMapping(value="/CatalogueService/removeProduct/{id}",method=RequestMethod.DELETE)
	public String removeProduct(@PathVariable int id)
	{
		int i=impl.deleteProduct(id);
		return "no of product deleted :"+i+"Product code:"+id;
		
	}
}

package com.annu.Microservices.product.catalogueservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		int i=impl.addProduct(product);
		if(i !=0)
		{
		return "No of product added:"+i+"    "+"Product name:"+product.getName();
		}else{
			return "Product not added";
		}
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/CatalogueService/retriveProduct/{Category}",method=RequestMethod.GET)
	public List<Product> retriveProduct(@PathVariable("Category") String productCategory)
	{

		return impl.retriveProduct(productCategory);
		
	}
	
    @RequestMapping(value="/CatalogueService/removeProduct/{id}",method=RequestMethod.DELETE)
	public String removeProduct(@PathVariable("id") int id)
	{
		int i=impl.deleteProduct(id);
		if(i!=0)
		{
		return "No of product deleted :"+i+"  "+"Product code:"+id;
		}else{
			return "Product not found";
		}
		
	}
}

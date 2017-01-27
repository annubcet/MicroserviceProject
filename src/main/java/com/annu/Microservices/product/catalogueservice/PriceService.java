package com.annu.Microservices.product.catalogueservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annu.Microservices.product.catalogue.dto.Product;



@RestController
public class PriceService {
	
	
	@Autowired
	protected ServiceImplimentation impl;
	
	@Autowired
	public PriceService(ServiceImplimentation impl) {
		this.impl=impl;
	}
	
	
		@RequestMapping(value="/CatalogueService/price/{id}",method=RequestMethod.GET)
		public String getProductPrice(@PathVariable("id") int productId)
		{
		    impl= new ServiceImplimentation();
			int price=impl.getProductPrice(productId);
			return "Price of selected product : "+price;
			
		}
		

}

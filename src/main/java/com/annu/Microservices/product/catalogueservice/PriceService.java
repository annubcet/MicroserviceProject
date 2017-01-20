package com.annu.Microservices.product.catalogueservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.annu.Microservices.product.catalogue.dto.Product;



@Path("/priceService")
public class PriceService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int getProductPrice(Product product)
	{
		ServiceImplimentation impl= new ServiceImplimentation();
		Product retrivedProduct=impl.getProductPrice(product);
		return retrivedProduct.getPrice();
		
	}

}

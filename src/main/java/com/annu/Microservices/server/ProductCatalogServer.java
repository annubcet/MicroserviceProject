package com.annu.Microservices.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.annu.Microservices.product.catalogueservice.CatalogueService;
import com.annu.Microservices.product.catalogueservice.ServiceImplimentation;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import({CatalogueService.class, ServiceImplimentation.class})
public class ProductCatalogServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "catalog-service");
	    SpringApplication.run(ProductCatalogServer.class, args);

	}
	
	

}

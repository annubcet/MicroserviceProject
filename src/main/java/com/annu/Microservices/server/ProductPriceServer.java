package com.annu.Microservices.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.annu.Microservices.product.catalogueservice.PriceService;
import com.annu.Microservices.product.catalogueservice.ServiceImplimentation;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import({PriceService.class, ServiceImplimentation.class})
public class ProductPriceServer {

	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "price-service");
	    SpringApplication.run(ProductPriceServer.class, args);
	}

}

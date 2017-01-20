package com.annu.Microservices.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.annu.Microservices.product.catalogue.dto.Product;



@Service
public class ServiceController {

	private static final Class<String> String = null;

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;
	
	public ServiceController(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public String addproduct(Product product)
	{
		return restTemplate.getForObject(serviceUrl + "/CatalogueService/addProduct", String);
		
	}
}

package com.LLD.notifyMeDesign;

import com.LLD.notifyMeDesign.Entity.Product;
import com.LLD.notifyMeDesign.Entity.User;
import com.LLD.notifyMeDesign.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class notifyMeDesignApplication {

	public static void main(String[] args) {
		System.out.println("Starting notifyMe design!!");
//		User user = new User("Utkarsh","kutkarsh460@gmail.com","1234");


		ProductService productService = new ProductService();
		productService.addProduct(new Product("Brush","BRUSH"));

		SpringApplication.run(notifyMeDesignApplication.class, args);
	}

}

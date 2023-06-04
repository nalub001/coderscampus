package com.coderscampus.service;

import java.util.ArrayList;

import com.coderscampus.domain.Product;

public class ReportGenerator {
	
	public void generateLowInventoryReport(ArrayList<Product> products) {
		
		for(Product product : products) {
			Double productPrice = product.getPrice();
			Integer productQuantity = product.getQuantity();
			
			if(((productPrice > 0.99 && productPrice <= 100) && productQuantity <= 20)
					|| (productPrice >= 101 && productQuantity <= 10)){
				
				System.out.println(product + " needs to be re-ordered");
			}
		}
		
	}

}

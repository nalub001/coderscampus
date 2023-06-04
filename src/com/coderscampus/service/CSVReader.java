package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.domain.Product;

public class CSVReader {
	
	private static CSVReader csvReaderService= null;
	

	private CSVReader() {
		
	}
	
	//Re-enforce singleton
	public static CSVReader getInstance() {
		if(csvReaderService == null) {
			csvReaderService = new CSVReader();
		}
		
		return csvReaderService; 
	}

	public ArrayList<Product> readProductsFromFile(String filePath) {
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			Path strPath = Paths.get(filePath);
			//System.out.println("printing file content: "+ Files.readAllLines(strPath));
			
			List<String> data = Files.readAllLines(strPath);
			
			data.stream()
				.skip(1)
				.forEach((String line) ->{
				String[] productData = line.split(",");
				Product product = new Product();
				product.setId(Integer.parseInt(productData[0]));
				product.setName(productData[1]);
				product.setQuantity(Integer.parseInt(productData[2]));
				product.setPrice(Double.parseDouble(productData[3]));
				//System.out.println(product);
				products.add(product);
			});
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}

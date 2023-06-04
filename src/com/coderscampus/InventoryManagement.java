package com.coderscampus;

import com.coderscampus.service.CSVReader;
import com.coderscampus.service.ReportGenerator;

public class InventoryManagement {

	public static void main(String[] args) {
		CSVReader csvReaderService = CSVReader.getInstance();
		
		ReportGenerator reportGeneratorService = new ReportGenerator();
		reportGeneratorService.generateLowInventoryReport(csvReaderService.readProductsFromFile("product-inventory.txt"));

	}

}

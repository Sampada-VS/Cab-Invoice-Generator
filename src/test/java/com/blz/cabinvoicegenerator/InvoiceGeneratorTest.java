package com.blz.cabinvoicegenerator;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceGeneratorTest {
	static InvoiceGenerator invoiceGenerator;

	@BeforeClass
	public static void createObj() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@AfterClass
	public static void nullObj() {
		invoiceGenerator = null;
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 3.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(35, fare, 0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.2;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
}

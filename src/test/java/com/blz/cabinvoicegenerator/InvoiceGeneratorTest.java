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

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 5), new Ride(0.2, 2) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		Ride[] rides = { new Ride(3.0, 5), new Ride(0.2, 2) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);

	}
}

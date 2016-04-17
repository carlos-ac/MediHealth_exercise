package com.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogicTest {
	
	MediHealth logic = null;
	final double delta = 0.001;
	
	@Before
	public void setUp() throws Exception {
		logic = new MediHealth();
	}

	@Test
	public void test() {
		// standard cases
		System.out.println("Age 5-65, Diagnosis, no insurance");
		assertEquals(60.0d, logic.getBill(50, "Diagnosis", 0, false), delta);
		System.out.println("Age 70, ECG, with insurance");
		assertEquals(80.16d, logic.getBill(70, "ECG", 0, true), delta);
		System.out.println("Age 4, Vaccine, 3 vaccines, no insurance");
		assertEquals(43.5d, logic.getBill(4, "Vaccine", 3, false), delta);
		
		// boundary cases
		System.out.println("Age negative");
		assertEquals(0, logic.getBill(-2, "Vaccine", 0, false), delta);
		System.out.println("Non existing service");
		assertEquals(0, logic.getBill(50, "non existing service", 0, false), delta);
		System.out.println("Number vaccines negative");
		assertEquals(0d, logic.getBill(50, "Vaccine", -5, false), delta);
		System.out.println("Service null");
		assertEquals(0, logic.getBill(50, null, -5, false), delta);
		
	}
	
	@After
	public void tearDown() throws Exception {
		logic = null;
	}
	
	
}

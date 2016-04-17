package com.exercise.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MedServiceTest {
	
	MedService medService = null;
	final double delta = 0.001;
	
	@Before
	public void setUp() throws Exception {
		medService = new MedService("new name", 15d, 78d);
	}

	@Test
	public void test() {
		// standard cases
		System.out.println("Testing MedService bean");
		assertEquals("new name", medService.getName());
		assertEquals(15d, medService.getBaseCost(), delta);
		assertEquals(78d, medService.getAddCost(), delta);
		
	}
	
	@After
	public void tearDown() throws Exception {
		medService = null;
	}
	
	
}

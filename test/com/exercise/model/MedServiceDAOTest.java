package com.exercise.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MedServiceDAOTest {
	
	private MedServiceDAO medServiceDAO = null;
	
	@Before
	public void setUp() throws Exception {
		medServiceDAO = new MedServiceDAO();
	}

	@Test
	public void test() {
		// standard cases
		System.out.println("Numbers of cities");
		assertEquals(5, medServiceDAO.getMedServiceMap().size());
		
	}
	
	@After
	public void tearDown() throws Exception {
		medServiceDAO = null;
	}
	
}

package com.exercise.model;


/**
 * Class that represents a medical service
 */
public class MedService {
	private String name = "";
	private double baseCost = 0;
	private double addCost = 0;
	
	public MedService(String str, double d1, double d2) {
		name = str;
		baseCost = d1;
		addCost = d2;
	}
	
	public void setName(String str) {
		name=str;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBaseCost(double d) {
		baseCost = d;
	}
	
	public double getBaseCost() {
		return baseCost;
	}

	public void setAddCost(double num) {
		addCost = num;
	}
	
	public double getAddCost() {
		return addCost;
	}
	
}

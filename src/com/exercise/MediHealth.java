package com.exercise;

import com.exercise.model.MedServiceDAO;

/**
 * Class represents MediHealth exercise
 * Calculate the bill of a service given the following:
 * age of the person,
 * service name,
 * number of vaccines,
 * person has a insurance
 */
public class MediHealth {

	MedServiceDAO medServiceDAO = null;
	BillEngine billEngine = null;
	
	public MediHealth() {
		medServiceDAO = new MedServiceDAO();
		billEngine = new BillEngine(medServiceDAO);
	}
	
	/**
     * validateData. Validates the data entered.
     * @param age of the person
     * @param service name of the service
     * @param numVaccine the number of vaccines
     * @return true if the data is valid and false if it is not
     */
	private boolean validateData(int age, String service, int numVaccine) {
		if(age<0) return false;
		if(numVaccine<0) return false;
		if(medServiceDAO.getMedServiceMap().get(service)==null) return false;
		
		return true;	
	}
	
	/**
	   * getBill. Return the cost of the Bill 
	   * @param age of person
	   * @param service the name of the service
	   * @param numVaccine is the number of vaccines
	   * @param hasInsurance if the patient has an insurance
	   * @return double total cost of Bill
	 */
	public double getBill(int age, String service, int numVaccine, boolean hasInsurance) {
		double totalCost = 0;
		double discount = 1;
		
		if(!validateData(age, service, numVaccine)) return 0;
		
		totalCost = billEngine.getCost(service, numVaccine);
		discount = billEngine.getDiscount(age, service, hasInsurance);
		
		return discount * totalCost;
	}
	
}

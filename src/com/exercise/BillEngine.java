package com.exercise;

import com.exercise.model.MedService;
import com.exercise.model.MedServiceDAO;

/**
 * Class represents the billing engine.
 * Calculate the cost and discount for a given:
 * age of the person,
 * service name,
 * number of vaccines,
 * person has a insurance.
 */
public class BillEngine {

	MedServiceDAO medServiceDAO = null;
	
	public BillEngine(MedServiceDAO medServiceDAO) {
		this.medServiceDAO = medServiceDAO;
	}
	
	/**
     * getCost. Returns the cost for a given service and number of vaccines.
     * @param service the name of the service
     * @param numVaccine number of vaccines
     * @return the cost of the service
     */
	public double getCost(String service, int numVaccine) {
		double cost = 0;
		
		MedService medService = (MedService) medServiceDAO.getMedServiceMap().get(service);
		if(medService != null) { 
			cost = medService.getBaseCost();
			if(service.equals("Vaccine") && numVaccine>0) {
				cost = cost + numVaccine * medService.getAddCost();
			}
		}
		else cost = 0;
		
		return cost;		
	}
	
	/**
     * getDiscount. Returns discount for a given service regarding age and if person has an insurance.
     * @param service the name of the service
     * @param hasInsurance if the person has an insurance
     * @return the discount to aplly
     */
	public double getDiscount(int age, String service, boolean hasInsurance) {
		double factor = 1;
		
		if(age>70) {
			factor = 0.1d;
		}	
		else if(age>=65 && age<=70) {
			factor = 0.4d;
		}
		else if(age<=5) {
			factor = 0.6d;
		}
		
		if(hasInsurance && service.equals("Blood Test")) {
			factor = factor * 0.85d;
		}
		
		return factor;
	}
	
}

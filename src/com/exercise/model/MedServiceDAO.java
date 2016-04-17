package com.exercise.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


/**
 * Class that represents the DB for the medical services
 */
public class MedServiceDAO {

	private HashMap<String, MedService> medServiceMap = new HashMap<String, MedService>();
	
	public MedServiceDAO() {
		String service = null;
		String[] array = null;
		double baseCost = 0;
		double addCost = 0;
		
		try {
            BufferedReader in = new BufferedReader(new FileReader("data.txt"));
            String str;
         
            while ((str = in.readLine()) != null) {
                array=str.split("\\|");
                service = array[0];
                baseCost=Double.parseDouble(array[1]);
                addCost=Double.parseDouble(array[2]);

                medServiceMap.put(service, new MedService(service,baseCost,addCost));
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
		
	}
	
	public HashMap<String, MedService> getMedServiceMap() {
		return medServiceMap;
	}
}

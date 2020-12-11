package database.test;

import java.util.ArrayList;

import database.InsuranceDao;
import database.Logger;
import database.metaDataDao;
import entity.InsuranceData;

public class Tester {
private static void printInsurance(ArrayList <InsuranceData> insurances) {
	for(int i=0;i<insurances.size();i++) {
		System.out.println("insurance number " +i + " :");
	System.out.println(insurances.get(i).getFamilyName());
	System.out.println(insurances.get(i).getName());
	System.out.println(insurances.get(i).getRemarks());
	System.out.println(insurances.get(i).getType());
	}
}
public static void main(String[] args) {
	InsuranceDao insuranceData = Logger.getLogger();
	metaDataDao metaData = Logger.getLogger();
	insuranceData.addInsurace();
	insuranceData.addInsurace();
	printInsurance(insuranceData.getAllInsurance());
	System.out.println(metaData.getInput());
	
}
}

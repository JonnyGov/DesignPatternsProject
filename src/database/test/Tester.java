package database.test;

import java.util.ArrayList;
import java.util.Date;

import database.Admin;
import database.InsuranceDao;
import database.dataBaseAdapter;
import database.metaDataDao;
import entity.CreateInsuraceFacade;
import entity.InsuranceData;
import entity.InsuranceData.InsuranceType;
public class Tester {
private static void printInsurance(ArrayList <InsuranceData> insurances) {
	System.out.println("printing insurances.....");
	for(int i=0;i<insurances.size();i++) {
	System.out.println("------------------------------------------");
	System.out.println("insurance number " +i + " :");
	System.out.println("name: "+insurances.get(i).getName());
	System.out.println("family: "+insurances.get(i).getFamilyName());
	System.out.println("remarks: "+insurances.get(i).getRemarks());
	System.out.println("type: "+insurances.get(i).getType());
	System.out.println("date: "+insurances.get(i).getDate());
	System.out.println("------------------------------------------");
	}
}
public static void adminTest() {
	System.out.println("Admin testing....");
	dataBaseAdapter.setLoggerDB();
	Admin admin=Admin.getAdmin();
	admin.deleteInsurance(1);
	admin.updateVersion("AdminTest");
	printInsurance(Admin.insuranceNotAdminMethods().getAllInsurance());
	System.out.println("printing meta data.....");
	System.out.println(Admin.metaDataNotAdminMethods().getMetaDataInput());
	admin.deleteAllInsurances();
	printInsurance(Admin.insuranceNotAdminMethods().getAllInsurance());
	
}
public static void main(String[] args) {
	dataBaseAdapter.setLoggerDB();
	InsuranceDao insuranceData = InsuranceDao.getInsuranceDataBase();
	metaDataDao metaData = metaDataDao.getMetaDataBase();
	Date d =new Date();
	insuranceData.addInsurace("ofek","Shachar",d,"give me money",InsuranceType.Apartment);
	insuranceData.addInsurace("yonathan","gov",d,"poop",InsuranceType.Car);
	d =new Date();
	insuranceData.addInsurace("vlad","mashu aroh",d,"i am good man!",InsuranceType.Health);
	d =new Date();
	insuranceData.addInsurace("ofek","Shachar",d,"give me",InsuranceType.Life);
	d =new Date();
	insuranceData.addInsurace("yonathan","gov",d,"poop poop",InsuranceType.Apartment);
	d =new Date();
	insuranceData.addInsurace("vlad","mashu aroh",d,"i am man!",InsuranceType.Car);
	CreateInsuraceFacade creator = new CreateInsuraceFacade();
	InsuranceData insurance = creator.createInsurance("ofek","Shachar",d,"add insurance by give insurance object",InsuranceType.Life); // create new insurance data.
	insuranceData.addInsurace(insurance);
	printInsurance(insuranceData.getAllInsurance());
	System.out.println("printing meta data.....");
	System.out.println(metaData.getMetaDataInput());
	adminTest();
	
}
}

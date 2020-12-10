package database;

import java.util.ArrayList;

import entity.CreateInsuraceFacade;
import entity.InsuranceMock;
import entity.InsuranceData;

public class Logger implements InsuranceDao,metaDataDao {

    @Override
    public void addInsurace() {
        // TODO Auto-generated method stubInsuranceData
        CreateInsuraceFacade creator =new CreateInsuraceFacade();
        InsuranceData insurance = creator.createInsurance();
        //insurace is the data you nee to add too gson (json)
    }

    @Override
    public ArrayList<InsuranceData> getAllInsurance() {
        // TODO Auto-generated method stub
        ArrayList<InsuranceData> insurances = new ArrayList<>();
        insurances.add(new InsuranceMock());
        return insurances;
    }

    @Override
    public metaData getInput() {

        // mock
        return new metaData("Ofek", "Yonathan", "Vlad", "0.2"); 
    }

}

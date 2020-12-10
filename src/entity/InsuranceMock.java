package entity;

import java.util.Date;

public class InsuranceMock implements InsuranceData {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "poop";
    }

    @Override
    public String getFamilyName() {
        // TODO Auto-generated method stub
        return "hoop";
    }

    @Override
    public Date getData() {
        // TODO Auto-generated method stub
        return new Date(System.currentTimeMillis());
    }

    @Override
    public String getRemarks() {
        // TODO Auto-generated method stub
        return "Good";
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "goochi";
    }
    
}

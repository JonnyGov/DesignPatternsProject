package entity;

import java.util.Date;

public class InsuranceMock implements InsuranceData {
	String name="poop",family="hoop",type="goochi",remarks="good";
	Date date=new Date(System.currentTimeMillis());
    @Override
    public String getName() {
        return "name";
    }

    @Override
    public String getFamilyName() {
        return "family name";
    }

    @Override
    public Date getDate() {
        return new Date(System.currentTimeMillis());
    }

    @Override
    public String getRemarks() {
        return "Good";
    }

    @Override
    public String getType() {
        return InsuranceType.Mock.toString();
    }
    
}

package database;

import java.util.ArrayList;
import java.util.Date;

import entity.InsuranceData;
import entity.InsuranceData.InsuranceType;

public interface InsuranceDao {
    public void addInsurace(String name, String namilyName , Date date,String remarks ,InsuranceType type);
    public ArrayList<InsuranceData> getAllInsurance();
}

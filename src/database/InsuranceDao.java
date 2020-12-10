package database;

import java.util.ArrayList;

import entity.InsuranceData;

public interface InsuranceDao {
    public void addInsurace();
    public ArrayList<InsuranceData> getAllInsurance();
}

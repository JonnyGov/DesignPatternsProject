package entity;

import java.util.Date;

public class CreateHealthInsurance extends CreateInsurace {
	@Override
	public InsuranceData getInsurance(String name, String namilyName, Date date, String remarks) {
	
		return  new HealthInsurance(name, namilyName, remarks, date);
	}
}

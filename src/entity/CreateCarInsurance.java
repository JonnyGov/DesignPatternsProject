package entity;

import java.util.Date;

public class CreateCarInsurance extends CreateInsurace {

	
	@Override
	public InsuranceData getInsurance(String name, String namilyName, Date date, String remarks) {
	
		return  new CarInsurance(name, namilyName, remarks, date);
	}
	
}

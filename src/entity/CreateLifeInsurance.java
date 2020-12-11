package entity;

import java.util.Date;

public class CreateLifeInsurance extends CreateInsurace {

	@Override
	public InsuranceData getInsurance(String name, String namilyName, Date date, String remarks)
	{
		return  new LifeInsurance(name, namilyName, remarks, date);
	}
}

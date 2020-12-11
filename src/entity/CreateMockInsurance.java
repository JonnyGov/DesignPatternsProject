package entity;

import java.util.Date;

public class CreateMockInsurance extends CreateInsurace 
{

	@Override
	public InsuranceData getInsurance(String name, String namilyName, Date date, String remarks)
	{
		return  new InsuranceMock();
	}
}

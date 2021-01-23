package entity;

import java.util.Date;

public class CreateAparmentInsurance extends CreateCarInsurance {
	@Override
	public InsuranceData getInsurance(String name, String namilyName, Date date, String remarks) {
		return  new ApartmentInsurance(name, namilyName, remarks, date);
	}
}

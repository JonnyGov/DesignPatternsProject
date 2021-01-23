package entity;

import java.util.Date;

public interface InsuranceData {
	enum InsuranceType
	{
		Car,Apartment,Life, Health ,Mock;
	}
	public String getName();
	public String getFamilyName();
	public Date getDate();
	public String getRemarks();
	public String getType();
}

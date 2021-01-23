package entity;

import java.util.Date;

import entity.InsuranceData.InsuranceType;

public class ApartmentInsurance  implements InsuranceData{
	
	 private String name,  fnamilyName, remarks ; 
	 private Date date;  
	 private InsuranceData.InsuranceType type;
	 
	public ApartmentInsurance(String name, String namilyName, String remarks, Date date) 
	{
		this.name = name;
		this.fnamilyName = namilyName;
		this.remarks = remarks;
		this.date = date;
		this.type = InsuranceType.Apartment;
	}

	@Override
	public String getName() 
	{

		return name;
	}

	@Override
	public String getFamilyName() 
	{

		return fnamilyName;
	}

	@Override
	public Date getDate() 
	{

		return date ;
	}

	@Override
	public String getRemarks() 
	{

		return remarks;
	}

	@Override
	public String getType()
	{

		return type.name();
	}
	

}

package entity;

import java.util.Date;

import entity.InsuranceData.InsuranceType;

public class CreateInsuraceFacade {

	
    public InsuranceData createInsurance(String name, String namilyName , Date date,String remarks ,InsuranceType type)
    {
    	CreateInsurace factory;

    	switch (type)
    	{
			case Car:
				factory = new CreateCarInsurance();		
				break;
			case Apartment:
				factory = new CreateAparmentInsurance();		
				break;
			case Life:
				factory = new CreateLifeInsurance();
				break;
			case Health:
				factory = new CreateHealthInsurance();		
				break;

			default:
				factory = new CreateMockInsurance();
				break;
		}
    	
        return  factory.getInsurance(name, namilyName, date, remarks);
    }
    
}

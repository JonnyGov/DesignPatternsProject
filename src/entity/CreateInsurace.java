package entity;
import java.util.Date;
public abstract class CreateInsurace {
	InsuranceData insured;
	
	// the factory method
  public InsuranceData getInsurance(String name, String namilyName , Date date,String remarks ) 
  {
	return new InsuranceMock();  
  }
  

  
  
}

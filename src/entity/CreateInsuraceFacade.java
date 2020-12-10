package entity;

public class CreateInsuraceFacade {

    public InsuranceData createInsurance(){
        return new InsuranceMock();
    }
    
}

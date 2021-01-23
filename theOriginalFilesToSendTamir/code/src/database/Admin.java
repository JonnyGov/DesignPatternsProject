package database;


public interface Admin{
public void updateVersion(String ver);
public void deleteInsurance(int index);
public void deleteAllInsurances();
public static InsuranceDao insuranceNotAdminMethods() {
	return dataBaseStartegy.getInsuranceDB();
}
public static metaDataDao metaDataNotAdminMethods() {
	return dataBaseStartegy.getMetaDataDB();
}
public static Admin getAdmin() {
	return dataBaseStartegy.getAdminDB();
}
}

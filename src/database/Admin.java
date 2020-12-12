package database;


public interface Admin{
public void updateVersion(String ver);
public void deleteInsurance(int index);
public void deleteAllInsurances();
public static InsuranceDao insuranceNotAdminMethods() {
	return dataBaseAdapter.getInsuranceDB();
}
public static metaDataDao metaDataNotAdminMethods() {
	return dataBaseAdapter.getMetaDataDB();
}
public static Admin getAdmin() {
	return dataBaseAdapter.getAdminDB();
}
}

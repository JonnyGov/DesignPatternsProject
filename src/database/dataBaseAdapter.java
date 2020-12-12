package database;

public class dataBaseAdapter {
	// default is logger.
	private static InsuranceDao insuranceDB=Logger.getLogger();
	private  static metaDataDao metaDataDB=Logger.getLogger();
	private  static Admin adminDB=Logger.getLogger();
	private dataBaseAdapter() {
	}
public static void setLoggerDB() {
	setInsuranceDB(Logger.getLogger());
	setMetaDataDB(Logger.getLogger());
	setAdminDB(Logger.getLogger());
}
public static InsuranceDao getInsuranceDB() {
	return insuranceDB;
}
public static void setInsuranceDB(InsuranceDao DB) {
	insuranceDB = DB;
}
public static metaDataDao getMetaDataDB() {
	return metaDataDB;
}
public static void setMetaDataDB(metaDataDao DB) {
	metaDataDB = DB;
}
public static Admin getAdminDB() {
	return adminDB;
}
public static void setAdminDB(Admin adminDB) {
	dataBaseAdapter.adminDB = adminDB;
}
}

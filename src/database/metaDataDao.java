package database;

public interface metaDataDao {
public metaData getMetaDataInput();
public static metaDataDao getMetaDataBase() {
	return dataBaseStartegy.getMetaDataDB();
}
}

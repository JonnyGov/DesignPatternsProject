package database;

public class metaData {
    public String  version ;
    public String  name1, name2, name3 ;
    public metaData(String name1, String name2, String name3 , String version)
    {
        this.name1= name1;
        this.name2=name2;
        this.name3=name3;
        this.version =version;
    }

    public String getName1() {
        return name1;
    }

    public String getName2()
    {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getVersion() {
        return version;
    }
    @Override
    public String toString() {
    	return "Version " + version+ "\nDesigned & Developed by:\n" +name1+" "+ name2+" "+name3;

    }
}

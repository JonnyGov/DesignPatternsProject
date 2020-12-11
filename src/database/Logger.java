package database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import entity.CreateInsuraceFacade;
import entity.InsuranceData;
import entity.InsuranceData.InsuranceType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class Logger implements InsuranceDao, metaDataDao {
	private final static Logger singelton = new Logger();
	private ArrayList<InsuranceData> insurances;
	private final static String metaDataPath = "metaTest.json";
	private final static String insurancesDataPath = "insuranceTest.json";
	private Gson gson;
	private metaData meta;
	private Type InsuranceDataListType;

	private Logger() {
		gson = new GsonBuilder().registerTypeAdapter(InsuranceData.class, new InterfaceAdapter<InsuranceData>())
				.create();
		InsuranceDataListType = new TypeToken<ArrayList<InsuranceData>>() {
		}.getType();
		getAllInsurance(); // update insurance data
		getInput(); // update metaInput

	}

	public static Logger getLogger() {
		return singelton;
	}

	@Override
	public void addInsurace(String name, String namilyName , Date date,String remarks ,InsuranceType type) {
		String jsonStr;
		CreateInsuraceFacade creator = new CreateInsuraceFacade();
		

		InsuranceData insurance = creator.createInsurance(name,namilyName,date,remarks,type); // create new insurance data.
		getAllInsurance();
		insurances.add(insurance);
		jsonStr = gson.toJson(insurances, InsuranceDataListType);
		wrtieToFile(insurancesDataPath, jsonStr);

	}

	@Override
	public ArrayList<InsuranceData> getAllInsurance() {
		String res;
		if (insurances != null)
			insurances.clear();
		res = readAllBytesJava7(insurancesDataPath);

		if (res == null) { // file not exist
			createFile(insurancesDataPath);
		}
		// file exist
		else
			// insuranceListDes =new InsuranceDataDeserializer(res);
			insurances = gson.fromJson(res, InsuranceDataListType);
		if (insurances == null)
			insurances = new ArrayList<InsuranceData>();
		return insurances;
	}

	@Override
	public metaData getInput() {
		String res;
		res = readAllBytesJava7(metaDataPath);
		if (res == null) { // file not exist
			createFile(metaDataPath);

		}
		// file exist
		else
			meta = gson.fromJson(res, metaData.class);
		if (meta == null) {
			meta = new metaData("Ofek", "Yonathan", "Vlad", "Beta");
			wrtieToFile(metaDataPath, gson.toJson(meta));
		}
		return meta;
	}

	private static String readAllBytesJava7(String filePath) {
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			return null;
			// e.printStackTrace();
			// return "";
		}

		return content;
	}

	private void wrtieToFile(String filePath, String content) {
		try {
			FileWriter myWriter = new FileWriter(filePath);
			myWriter.write(content);
			myWriter.close();
			System.out.println("Successfully wrote to the file (" + filePath + ").");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void createFile(String name) {
		try {
			File myObj = new File(name);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File (" + myObj.getName() + ") already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private final class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
		public JsonElement serialize(T object, Type interfaceType, JsonSerializationContext context) {
			final JsonObject wrapper = new JsonObject();
			wrapper.addProperty("type", object.getClass().getName());
			wrapper.add("data", context.serialize(object));
			return wrapper;
		}

		public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context)
				throws JsonParseException {
			final JsonObject wrapper = (JsonObject) elem;
			final JsonElement typeName = get(wrapper, "type");
			final JsonElement data = get(wrapper, "data");
			final Type actualType = typeForName(typeName);
			return context.deserialize(data, actualType);
		}

		private Type typeForName(final JsonElement typeElem) {
			try {
				return Class.forName(typeElem.getAsString());
			} catch (ClassNotFoundException e) {
				throw new JsonParseException(e);
			}
		}

		private JsonElement get(final JsonObject wrapper, String memberName) {
			final JsonElement elem = wrapper.get(memberName);
			if (elem == null)
				throw new JsonParseException(
						"no '" + memberName + "' member found in what was expected to be an interface wrapper");
			return elem;
		}
	}
}

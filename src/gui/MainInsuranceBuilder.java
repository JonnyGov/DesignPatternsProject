package gui;

import java.io.IOException;
import java.util.ArrayList;

import database.metaData;
import database.metaDataDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MainInsuranceBuilder implements SceneBuilder {
	final String fxmlPath;
	FXMLLoader loader;
	Scene scene;
	MainInsuranceController controller;
	
	
	public MainInsuranceBuilder() {
		fxmlPath= "/windows/MainInsurance.fxml";
	}

	@Override
	public void buildLoader() {
		loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlPath));
	}
	@Override
	public void buildScene() {
		try {
			scene =  new Scene(loader.load());
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void buildController() {
		if(loader.getController() instanceof MainInsuranceController) {
			controller = loader.getController();
		}else {
			throw new RuntimeException("Builder loader isn't match to Builder type");
		}
	}

	@Override
	public void buildVersion() {
		metaDataDao mdDao = metaDataDao.getMetaDataBase();;
		metaData md = mdDao.getMetaDataInput();
		controller.setVersion(md.getVersion());
	}

	@Override
	public void buildAuthors() {
		metaDataDao mdDao = metaDataDao.getMetaDataBase();;
		metaData md = mdDao.getMetaDataInput();
		ArrayList<String> authers = new ArrayList<>();
		authers.add(md.name1);
		authers.add(md.name2);
		authers.add(md.name3);
		controller.setAuthor(authers);
	}
	@Override
	public void buildInsurenceTitle() {
		return;
	}

	@Override
	public void buildViewPurchases() {
		return;
	}
	
	public Scene getResult() throws IOException {
		return scene;
	}

	
}

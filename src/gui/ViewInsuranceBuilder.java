package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import database.InsuranceDao;
import database.metaData;
import database.metaDataDao;
import entity.InsuranceData;
import entity.LifeInsurance;
import gui.controller.ViewInsuranceController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ViewInsuranceBuilder implements SceneBuilder {
	private final String fxmlPath;
	private FXMLLoader loader;
	private Scene scene;
	private ViewInsuranceController controller;


	public ViewInsuranceBuilder() {
		fxmlPath= "fxml/windows/ViewInsurance.fxml";
	}

	@Override
	public void buildLoader() {
		try {
			loader = new FXMLLoader();
			URL url = new URL("file:"+fxmlPath);
			loader.setLocation(url);
		} catch (MalformedURLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
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
		if(loader.getController() instanceof ViewInsuranceController) {
			controller = loader.getController();
		}else {
			throw new RuntimeException("Builder loader isn't match to Builder type");
		}
	}

	@Override
	public void buildVersion() {
		metaDataDao mdDao = metaDataDao.getMetaDataBase();
		metaData md = mdDao.getMetaDataInput();

		Label lblVersion = controller.getLblVersion();
		lblVersion.setText("Version: "+md.getVersion());
	}

	@Override
	public void buildAuthors() {
		metaDataDao mdDao = metaDataDao.getMetaDataBase();;
		metaData md = mdDao.getMetaDataInput();
		ArrayList<String> authers = new ArrayList<>();
		authers.add(md.name1);
		authers.add(md.name2);
		authers.add(md.name3);

		VBox VbxAuther = controller.getVBxAuthor();
		for (String auther : authers) {
			String text = String.format("auther %d: %s",authers.indexOf(auther)+1,auther);
			Label curAutherLable = new Label(text);
			curAutherLable.setMaxWidth(Double.MAX_VALUE);
			curAutherLable.getStyleClass().add("main-pane");
			VbxAuther.getChildren().add(curAutherLable);
		}
	}
	@Override
	public void buildInsurenceTitle() {
		return;
	}

	@Override
	public void buildViewPurchases() {
		TableView<InsuranceData> insuranceTable = controller.getInsuranceTable();
		for(TableColumn column :  insuranceTable.getColumns()) {
			column.setCellValueFactory(new PropertyValueFactory(column.getId().split("Column")[0]));
		}
		InsuranceDao iDao = InsuranceDao.getInsuranceDataBase(); 
		for(InsuranceData insurance : iDao.getAllInsurance()) {
			insuranceTable.getItems().add(insurance);
		}
	}


	public Scene getResult() {
		return scene;
	}


}

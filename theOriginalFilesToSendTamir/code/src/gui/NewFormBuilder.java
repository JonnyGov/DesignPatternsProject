package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import database.InsuranceDao;
import database.metaDataDao;
import entity.InsuranceData;
import entity.metaData;
import entity.InsuranceData.InsuranceType;
import gui.controller.NewFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NewFormBuilder implements SceneBuilder {
	private final String fxmlPath;
	private FXMLLoader loader;
	private Scene scene;
	private NewFormController controller;
	private String title;


	public NewFormBuilder(InsuranceType type) {
		fxmlPath= "fxml/windows/NewForm.fxml";
		this.title = "New "+ type.toString() +" Insurance";
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
		if(loader.getController() instanceof NewFormController) {
			controller = loader.getController();
		}else {
			throw new RuntimeException("Builder loader isn't match to Builder type");
		}
	}

	@Override
	public void buildVersion() {
		metaDataDao mdDao = metaDataDao.getMetaDataBase();;
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
		Label lblTitle = controller.getLblTitle();
		lblTitle.setText(title);
	}

	@Override
	public void buildViewPurchases() {
		return;
	}

	public Scene getResult() {
		return scene;
	}

	@Override
	public void buildButtons() {
		for (Button button : controller.getButtons()) {
			button.setOnAction(
					new javafx.event.EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Object targetObj = event.getSource();
							if(targetObj instanceof Button) {
								Button target = (Button) targetObj;

								switch(target.getId()) {
								case "btnClose":
									MainInsuranceBuilder builder = new MainInsuranceBuilder();
									new SceneDirector().build(builder);
									Scene scene = ((MainInsuranceBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								case "btnSave":
									InsuranceData insurance = controller.getInsuranceFromFields();
									InsuranceDao iDao = InsuranceDao.getInsuranceDataBase();
									iDao.addInsurace(insurance);
									controller.popUpMessage();
									controller.clearTextFields();
								}
							}
						}
					});
		}

	}


}

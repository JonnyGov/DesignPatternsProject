package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import database.metaData;
import database.metaDataDao;
import entity.InsuranceData.InsuranceType;
import gui.controller.MainInsuranceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainInsuranceBuilder implements SceneBuilder {
	private final String fxmlPath;
	private FXMLLoader loader;
	private Scene scene;
	private MainInsuranceController controller;


	public MainInsuranceBuilder() {
		fxmlPath= "fxml/windows/MainInsurance.fxml";
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
							SceneBuilder builder;
							Scene scene ;
							Object targetObj = event.getSource();
							if(targetObj instanceof Button) {
								Button target = (Button) targetObj;

								switch(target.getId()) {
								case "btnEmulateView":
									builder = new ViewInsuranceBuilder();
									new SceneDirector().build(builder);
									scene = ((ViewInsuranceBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								case "btnEmulateCar":
									builder = new NewFormBuilder(InsuranceType.Car);
									new SceneDirector().build(builder);
									scene = ((NewFormBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								case "btnEmulateLife":
									builder = new NewFormBuilder(InsuranceType.Life);
									new SceneDirector().build(builder);
									scene = ((NewFormBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								case "btnEmulateAprt":
									builder = new NewFormBuilder(InsuranceType.Apartment);
									new SceneDirector().build(builder);
									scene = ((NewFormBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								case "btnEmulateHealth":
									builder = new NewFormBuilder(InsuranceType.Health);
									new SceneDirector().build(builder);
									scene = ((NewFormBuilder) builder).getResult();
									App.getPrimaryStage().setScene(scene);
									break;
								}

							}else {
								throw new RuntimeException("Their was an Pressing Action but not on button");
							}
						}
					});
		}

	}


}

package gui.controller;

import gui.App;
import gui.NewFormBuilder;
import gui.SceneBuilder;
import gui.SceneDirector;
import gui.ViewInsuranceBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInsuranceController {

    @FXML
    private Button btnEmulate;

    @FXML
    private Button btnEmulateCar;

    @FXML
    private Button btnEmulateLife;

    @FXML
    private Button btnEmulateAprt;

    @FXML
    private Button btnEmulateHealth;

    @FXML
    private Button btnEmulateView;
    
    @FXML
    private Label lblVersion;
    
    @FXML
    private VBox VbxAuther;

    @FXML
    void btnEmulatePressed(ActionEvent event) {
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
    			builder = new NewFormBuilder("New Car Insurance");
				new SceneDirector().build(builder);
				scene = ((NewFormBuilder) builder).getResult();
				App.getPrimaryStage().setScene(scene);
    			break;
    		case "btnEmulateLife":
    			builder = new NewFormBuilder("New Life Insurance");
				new SceneDirector().build(builder);
				scene = ((NewFormBuilder) builder).getResult();
				App.getPrimaryStage().setScene(scene);
    			break;
    		case "btnEmulateAprt":
    			builder = new NewFormBuilder("New Apartment Insurance");
				new SceneDirector().build(builder);
				scene = ((NewFormBuilder) builder).getResult();
				App.getPrimaryStage().setScene(scene);
    			break;
    		case "btnEmulateHealth":
    			builder = new NewFormBuilder("New Health Insurance");
				new SceneDirector().build(builder);
				scene = ((NewFormBuilder) builder).getResult();
				App.getPrimaryStage().setScene(scene);
    			break;
    		}
    		
    	}else {
    		throw new RuntimeException("Their was an Pressing Action but not on button");
    	}

    }
    
    
    public Label getLblVersion() {
    	return lblVersion;
    }
    
    public VBox getVBxAuthor() {
    	return VbxAuther;
    }

}

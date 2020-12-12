package gui.controller;

import java.io.IOException;
import java.util.ArrayList;

import gui.App;
import gui.SceneDirector;
import gui.ViewInsuranceBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInsuranceController {

    @FXML
    private AnchorPane titleBar;

    @FXML
    private AnchorPane emuPane;

    @FXML
    private AnchorPane step1f;

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
    private AnchorPane step2f;

    @FXML
    private Button btnEmulateView;
    
    @FXML
    private Label lblVersion;
    
    @FXML
    private VBox VbxAuther;

    @FXML
    void btnEmulatePressed(ActionEvent event) {
    	Object targetObj = event.getSource();
    	if(targetObj instanceof Button) {
    		Button target = (Button) targetObj;
    		switch(target.getId()) {
    		case "btnEmulateView":
    			ViewInsuranceBuilder builder = new ViewInsuranceBuilder();
				new SceneDirector().build(builder);
				Stage pStage = App.getPrimaryStage();
				pStage.setScene(builder.getResult());
				// show is not needed
				//pStage.show();
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

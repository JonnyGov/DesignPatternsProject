package gui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainInsuranceController {

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
    private VBox VbxAuther;

    @FXML
    private Label lblVersion;
    
    public ArrayList<Button> getButtons(){
    	ArrayList<Button> listButton = new ArrayList<>();
    	listButton.add(btnEmulateCar);
    	listButton.add(btnEmulateLife);
    	listButton.add(btnEmulateAprt);
    	listButton.add(btnEmulateHealth);
    	listButton.add(btnEmulateView);
    	return listButton;
    }
    
    public Label getLblVersion() {
    	return lblVersion;
    }
    
    public VBox getVBxAuthor() {
    	return VbxAuther;
    }

}

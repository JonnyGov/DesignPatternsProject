package gui.controller;
import java.util.ArrayList;
import java.util.Date;

import entity.CreateInsuraceFacade;
import entity.InsuranceData;
import entity.InsuranceData.InsuranceType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NewFormController {

	@FXML
	private Label lblTitle;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfFamilyName;

	 @FXML
	 private DatePicker dpDate;

	@FXML
	private TextField tfRemarks;

	@FXML
	private TextField tfCreditCard;

	 @FXML
	private Button btnSave;

	@FXML
	private Button btnClose;

	@FXML
	private VBox vbxAuther;

	@FXML
	private Label lblVersion;
	
	public void clearTextFields() {
		tfName.clear();
		tfFamilyName.clear();
		dpDate.getEditor().clear();
		tfRemarks.clear();
		tfCreditCard.clear();
	}
	
	public InsuranceData getInsuranceFromFields() {
		java.sql.Date sdate = java.sql.Date.valueOf(dpDate.getValue());
		Date udate = new Date(sdate.getTime());
		InsuranceType type = InsuranceData.InsuranceType.valueOf(lblTitle.getText().split(" ")[1]);
		CreateInsuraceFacade creator = new CreateInsuraceFacade();
		InsuranceData insurance = creator.createInsurance(tfName.getText(),tfFamilyName.getText(),udate, tfRemarks.getText(),type);
		return insurance;
	}

	public void popUpMessage() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("success");
        alert.setHeaderText("Added new insurance");
        alert.setContentText("your insurace added seccessfully");
        alert.showAndWait();
	}

	public Label getLblVersion() {
		return lblVersion;
	}

	public Label getLblTitle() {
		return lblTitle;
	}

	public VBox getVBxAuthor() {
		return vbxAuther;
	}
	
	public ArrayList<Button> getButtons(){
		ArrayList<Button> listButton = new ArrayList<Button>();
		listButton.add(btnClose);
		listButton.add(btnSave);
		return listButton;
	}

}

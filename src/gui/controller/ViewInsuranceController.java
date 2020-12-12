package gui.controller;


import java.util.Date;

import com.sun.xml.internal.ws.util.StringUtils;

import entity.InsuranceData;
import entity.LifeInsurance;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ViewInsuranceController {

	@FXML
	private BorderPane mainBorderPane;

	@FXML
	private AnchorPane titleBar;

	@FXML
	private AnchorPane mainwindow_pane;

	@FXML
	private AnchorPane initiateSalePane;

	@FXML
	private TableView<InsuranceData> insuranceTable;

	@FXML
	private TableColumn<InsuranceData, String> FirstNameColumn;

	@FXML
	private TableColumn<InsuranceData, String> FamilyNameColumn;

	@FXML
	private TableColumn<InsuranceData, Date> DataColumn;

	@FXML
	private TableColumn<InsuranceData, InsuranceData> RemarksColumn;

	@FXML
	private VBox VbxAuther;

	@FXML
	private Label lblVersion;

	@FXML
	private Button btnBack;


	@FXML
	void btnBackClicked(MouseEvent event) {

	}
	
	public TableView<InsuranceData> getInsuranceTable() {
		return insuranceTable;
	}

	public Label getLblVersion() {
		return lblVersion;
	}

	public VBox getVBxAuthor() {
		return VbxAuther;
	}

}

package gui.controller;


import java.util.ArrayList;
import java.util.Date;

import entity.InsuranceData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private TableColumn<InsuranceData, String> NameColumn;

	@FXML
	private TableColumn<InsuranceData, String> FamilyNameColumn;

	@FXML
	private TableColumn<InsuranceData, Date> DateColumn;

	@FXML
	private TableColumn<InsuranceData, String> RemarksColumn;

	@FXML
	private VBox VbxAuther;

	@FXML
	private Label lblVersion;

	@FXML
	private Button btnBack;

	public TableView<InsuranceData> getInsuranceTable() {
		return insuranceTable;
	}

	public Label getLblVersion() {
		return lblVersion;
	}

	public VBox getVBxAuthor() {
		return VbxAuther;
	}

	public ArrayList<Button> getButtons() {
		ArrayList<Button> listButton = new ArrayList<Button>();
		listButton.add(btnBack);
		return listButton;
	}

}

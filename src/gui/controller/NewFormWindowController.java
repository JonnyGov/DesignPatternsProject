package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class NewFormWindowController {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private VBox vbox1;

    @FXML
    private AnchorPane titleBar;

    @FXML
    private AnchorPane mainwindow_pane;

    @FXML
    private AnchorPane addEditCustomerPane;

    @FXML
    private TextField tfAECUCustID;

    @FXML
    private TextField tfAECUFirstName;

    @FXML
    private TextField tfAECUSurname;

    @FXML
    private TextField tfAECUEmail;

    @FXML
    private TextField tfAECUCredit;

    @FXML
    private Button btnAECUSave;

    @FXML
    private Button btnAECUSave1;

    @FXML
    void btnAECUSavePressed(ActionEvent event) {

    }

}

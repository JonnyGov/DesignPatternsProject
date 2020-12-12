package gui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ViewInsuraceWindowController {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private AnchorPane titleBar;

    @FXML
    private AnchorPane mainwindow_pane;

    @FXML
    private AnchorPane initiateSalePane;

    @FXML
    private TableView<?> tvISSalesPattern;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> durationColumn;

    @FXML
    private TableColumn<?, ?> dieselDiscountColumn;

    @FXML
    private TableColumn<?, ?> gasolineDiscountColumn;
    
    @FXML
    private VBox VbxAuther;
    
    @FXML
    private Label lblVersion;

    @FXML
    private Button btnBack;

    @FXML
    void btnBackClicked(MouseEvent event) {

    }
    
    public Label getLblVersion() {
    	return lblVersion;
    }
    
    public VBox getVBxAuthor() {
    	return VbxAuther;
    }

}

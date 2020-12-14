package gui.controller;
import java.util.Date;
import database.InsuranceDao;
import entity.CreateInsuraceFacade;
import entity.InsuranceData;
import entity.InsuranceData.InsuranceType;
import gui.App;
import gui.MainInsuranceBuilder;
import gui.SceneDirector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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

	@FXML
	void btnAECUSavePressed(ActionEvent event) {
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
				java.sql.Date sdate = java.sql.Date.valueOf(dpDate.getValue());
				Date udate = new Date(sdate.getTime());
				InsuranceType type = InsuranceData.InsuranceType.valueOf(lblTitle.getText().split(" ")[1]);
				InsuranceDao iDao = InsuranceDao.getInsuranceDataBase();
				CreateInsuraceFacade creator = new CreateInsuraceFacade();
				InsuranceData insurance = creator.createInsurance(tfName.getText(),tfFamilyName.getText(),udate, tfCreditCard.getText(),type);
				iDao.addInsurace(insurance);
			}
		}
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

}

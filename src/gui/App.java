package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	private static Stage pStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			pStage= primaryStage;
			pStage.setResizable(false);
			pStage.setTitle("Insurace Company");
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			
			//build scene
			MainInsuranceBuilder builder = new MainInsuranceBuilder();
			new SceneDirector().build(builder);
			
			//show scene
			pStage.setScene(builder.getResult());
			pStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getPrimaryStage() {
        return pStage;
    }

	public static void main(String args[]) throws Exception {
		launch(args);
	}

}

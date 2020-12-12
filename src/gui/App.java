package gui;

import database.test.Tester;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * client's exe starts here
 * <p>
 * loads login window
 * 
 * @version Final
 * @author Elroy, Lior
 */
public class App extends Application {

	/**
	 * opens login window and creates a new instance of login boundary
	 */
	private static Stage pStage;
	@Override
	public void start(Stage primaryStage) {
		Tester.main(null);
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

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		launch(args);
	}

}

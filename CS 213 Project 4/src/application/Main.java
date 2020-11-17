package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
/**
 * Main, executes the program and displays the initial JavaFX scene.
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */

public class Main extends Application {
	public static Stage parentWindow;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			parentWindow = primaryStage;
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Controller.fxml"));

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Controller.fxml"));
			
			MainController controller = new MainController();
			loader.setController(controller);
			
			
			//Parent firstPane = loader.load();
			Scene scene = new Scene(root,700,700);
			
			/*FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("ControllerTwo.fxml"));
	        Parent secondPane = secondPageLoader.load();
	        Scene secondScene = new Scene(secondPane, 700, 700);

	        MainController firstPaneController = (MainController) loader.getController();
	        firstPaneController.setSecondScene(secondScene);
	        
	        SecondController secondPaneController = (SecondController) secondPageLoader.getController();
	        secondPaneController.setFirstScene(scene);
	        
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());*/
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cayfabe's Sandwiches (CS 213 Project 4)");

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

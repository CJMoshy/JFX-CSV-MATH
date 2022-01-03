
//created by CJ Moshy on 12/20/2022
/*purpose: A simple file reader that will calculate the sum and average of a text file
 * with one number per line */
//Constraints: file reader parses all numbers to an INTEGER, not a floating point
//files needed: NONE
//external dependencies: SEE Referenced Libraries

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Instantiate our pane
			primaryStage.setTitle("CSV Parser");
			Parent root = FXMLLoader.load(getClass().getResource("SimpleAverage.fxml"));
			Scene scene = new Scene(root, 600, 400);

			// link our CSS
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Display Page
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

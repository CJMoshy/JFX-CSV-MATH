package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class Controller {

	// using some global data here so I can reference it in different methods
	static String path;
	static File file;

	@FXML
	protected TextField fileTextBox = new TextField();

	@FXML
	protected Button ca = new Button();

	@FXML
	protected Button cs = new Button();

	@FXML
	protected Button oFile = new Button();

	@FXML
	protected Label result = new Label();

	protected FileChooser fc = new FileChooser();

	public void openFileOnClick(MouseEvent e) {

		file = fc.showOpenDialog(null);
		fileTextBox.setText(file.getAbsolutePath());

		// some alerts to make the system feel more interactive
		if (!file.exists()) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Invalid Input");
			errorAlert.setContentText("The specified file path does not exhist");
			errorAlert.showAndWait();
			return;
		} else {
			Alert Alert = new Alert(AlertType.CONFIRMATION);
			Alert.setHeaderText("File Found Confirmaiton");
			Alert.setContentText("File was located successfully");
			Alert.showAndWait();
		}
	}

	public void calculateAverage(MouseEvent e) {

		// capture the data from the input file
		String str;
		BufferedReader br;

		// using a dynamic array for ease of use and the included for each
		ArrayList<Integer> data = new ArrayList<Integer>();

		try {
			// read file
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				data.add(Integer.parseInt(str));
			}

			/*
			 * if these exceptions are raised, then there is a problem with the code that
			 * must be addressed by the programmer
			 */

		} catch (NumberFormatException e2) {
			// do nothing
		} catch (IOException e3) {
			// do nothing
		} catch (NullPointerException e4) {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("File Reading Error");
			a.setContentText("Please ensure a proper file-path has been specified");
			a.showAndWait();
			return;
		}

		// get the average of the numbers
		float avg = 0;

		for (int x : data) {
			avg += x;
		}

		avg = avg / data.size();

		// set the result label text accordingly
		result.setText("The total average is : " + String.valueOf(avg));
	}

	public void calculateSum(MouseEvent e) {

		String str;
		BufferedReader br;
		ArrayList<Integer> data = new ArrayList<Integer>();

		try {
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				data.add(Integer.parseInt(str));
			}

		} catch (NumberFormatException e2) {
			// do nothing
		} catch (IOException e3) {
			// do nothing
		} catch (NullPointerException e4) {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("File Reading Error");
			a.setContentText("Please ensure a proper file-path has been specified");
			a.showAndWait();
			return;
		}

		// get the sum of the numbers
		int sum = 0;

		for (int x : data) {
			sum += x;
		}

		result.setText("The total sum is : " + String.valueOf(sum));
	}
}

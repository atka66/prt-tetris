package hu.unideb.inf.prt.beadando.tetris.view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LeaderboardController implements Initializable {

	@FXML
	Label label1Name;
	@FXML
	Label label1Score;
	@FXML
	Label label2Name;
	@FXML
	Label label2Score;
	@FXML
	Label label3Name;
	@FXML
	Label label3Score;
	@FXML
	Label label4Name;
	@FXML
	Label label4Score;
	@FXML
	Label label5Name;
	@FXML
	Label label5Score;
	@FXML
	Button buttonBack;

	@FXML
	private void handleButtonBack(ActionEvent event) {
		Stage stage;
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuFXML.fxml"));
			root = loader.load();
			loader.<MenuController> getController();
			stage = (Stage) buttonBack.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		label1Name.setText("FIRSTNAME");
		label1Score.setText("FIRSTSCORE");
	}
}

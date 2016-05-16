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

public class MenuController implements Initializable {
	
	@FXML
	Label labelTetris;
	@FXML
	Label labelCreator;
	@FXML
	Button buttonStartGame;
	@FXML
	Button buttonLeaderboard;

	@FXML
	private void handleButtonStartGame(ActionEvent event) {
		Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameFXML.fxml"));
            root = loader.load();
            loader.<GameController>getController();
            stage = (Stage) buttonStartGame.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	@FXML
	private void handleButtonLeaderboard(ActionEvent event) {
		Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LeaderboardFXML.fxml"));
            root = loader.load();
            loader.<LeaderboardController>getController();
            stage = (Stage) buttonLeaderboard.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	public void initialize(URL location, ResourceBundle resources) {

	}
}

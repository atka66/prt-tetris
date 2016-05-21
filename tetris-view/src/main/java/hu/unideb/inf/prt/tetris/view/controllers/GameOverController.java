package hu.unideb.inf.prt.tetris.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.prt.tetris.view.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameOverController implements Initializable {

	@FXML
	Button buttonSave;
	@FXML
	Button buttonSkip;
	@FXML
	Label labelScore;
	@FXML
	TextField textFieldPlayer;

	@FXML
	private void handleButtonSave(ActionEvent event) {
		// TODO
	}

	@FXML
	private void handleButtonSkip(ActionEvent event) {
		// TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textFieldPlayer.setText(Main.player);
		labelScore.setText(Integer.toString(Main.score));
	}
}

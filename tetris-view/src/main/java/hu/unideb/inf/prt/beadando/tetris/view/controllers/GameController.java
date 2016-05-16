package hu.unideb.inf.prt.beadando.tetris.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class GameController implements Initializable {

	@FXML
	Label labelScore;
	@FXML
	Canvas canvasNextPiece;
	@FXML
	Canvas canvasField;
	
	GraphicsContext gcField;
	GraphicsContext gcNextPiece;

	@FXML
	private void handleKeyPressed(ActionEvent event) {
		System.out.println("KEY PRESSED");
	}

	public void initialize(URL location, ResourceBundle resources) {
		gcField = canvasField.getGraphicsContext2D();
		gcNextPiece = canvasNextPiece.getGraphicsContext2D();
		
		gcField.setFill(Color.BLACK);
		gcField.fillRect(0, 0, 160, 320);
	}
}

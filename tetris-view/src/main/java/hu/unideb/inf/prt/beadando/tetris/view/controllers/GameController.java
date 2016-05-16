package hu.unideb.inf.prt.beadando.tetris.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.prt.beadando.tetris.controller.game.pieces.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GameController implements Initializable {

	@FXML
	Label labelScore;
	@FXML
	Canvas canvasNextPiece;
	@FXML
	Canvas canvasField;

	GraphicsContext gcField;
	GraphicsContext gcNextPiece;
	Game game;

	@FXML
	private void handleKeyPressed(ActionEvent event) {
		System.out.println("KEY PRESSED");
	}

	private Paint getBlockColorFromInt(int color) {
		switch (color) {
		case 1:
			return Color.CYAN;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.ORANGE;
		case 4:
			return Color.YELLOW;
		case 5:
			return Color.GREEN;
		case 6:
			return Color.MAGENTA;
		case 7:
			return Color.RED;
		default:
			return Color.BLACK;
		}
	}

	private void drawBlockOnGc(GraphicsContext gc, int x, int y, int color) {
		gc.setFill(getBlockColorFromInt(color));
		gc.fillRect(x * 16, y * 16, 15, 15);
		gc.strokeRect(x * 16, y * 16, 15, 15);
	}

	private void drawField() {
	}

	private void drawNextPiece() {
		int[][] nextPieceFigure = game.getNextPiece().getFigure();
		for (int i = 0; i < nextPieceFigure.length; i++) {
			for (int j = 0; j < nextPieceFigure[i].length; j++) {
				if (nextPieceFigure[i][j] != 0) {
					drawBlockOnGc(gcNextPiece, j, i, nextPieceFigure[i][j]);
				}
			}
		}
	}

	private void clearAll() {
		gcField.setFill(Color.BLACK);
		gcField.fillRect(0, 0, 160, 320);
		gcField.setStroke(Color.GRAY);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				gcField.strokeRect(i * 16, j * 16, 15, 15);
			}
		}

		gcNextPiece.setFill(Color.BLACK);
		gcNextPiece.fillRect(0, 0, 64, 64);
		gcNextPiece.setStroke(Color.GRAY);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				gcNextPiece.strokeRect(i * 16, j * 16, 15, 15);
			}
		}
		drawNextPiece();
	}

	public void initialize(URL location, ResourceBundle resources) {
		game = new Game();
		gcField = canvasField.getGraphicsContext2D();
		gcNextPiece = canvasNextPiece.getGraphicsContext2D();
		clearAll();
	}
}

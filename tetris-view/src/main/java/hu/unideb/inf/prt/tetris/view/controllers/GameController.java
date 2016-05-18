package hu.unideb.inf.prt.tetris.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.prt.tetris.controller.game.Game;
import hu.unideb.inf.prt.tetris.controller.game.Piece;
import hu.unideb.inf.prt.tetris.controller.game.PieceAction;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class GameController implements Initializable {

	@FXML
	Node node;
	@FXML
	Label labelScore;
	@FXML
	Canvas canvasNextPiece;
	@FXML
	Canvas canvasField;
	@FXML
	Button buttonLeft;
	@FXML
	Button buttonRight;
	@FXML
	Button buttonRotateLeft;
	@FXML
	Button buttonRotateRight;
	@FXML
	Button buttonDown;

	Timeline timeline;
	GraphicsContext gcField;
	GraphicsContext gcNextPiece;
	Game game;

	@FXML
	private void handleButtonLeft(ActionEvent event) {
		if (!game.getField().isPieceCollide(game.getCurrentPiece(), PieceAction.LEFT)) {
			game.getCurrentPiece().move(-1, 0);
		}
		render();
	}

	@FXML
	private void handleButtonRight(ActionEvent event) {
		if (!game.getField().isPieceCollide(game.getCurrentPiece(), PieceAction.RIGHT)) {
			game.getCurrentPiece().move(1, 0);
		}
		render();
	}

	@FXML
	private void handleButtonRotateLeft(ActionEvent event) {
		render();
	}

	@FXML
	private void handleButtonRotateRight(ActionEvent event) {
		render();
	}

	@FXML
	private void handleButtonDown(ActionEvent event) {
		if (!game.getField().isPieceCollide(game.getCurrentPiece(), PieceAction.DOWN)) {
			game.getCurrentPiece().move(0, 1);
		}
		render();
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
		int[][] fieldMap = game.getField().getMap();
		for (int i = 0; i < fieldMap.length; i++) {
			for (int j = 0; j < fieldMap[i].length; j++) {
				if (fieldMap[i][j] != 0) {
					drawBlockOnGc(gcField, j, i, fieldMap[i][j]);
				}
			}
		}
	}

	private void drawCurrentPiece() {
		Piece currentPiece = game.getCurrentPiece();
		int[][] currentPieceFigure = currentPiece.getFigure();
		for (int i = 0; i < currentPieceFigure.length; i++) {
			for (int j = 0; j < currentPieceFigure[i].length; j++) {
				if (currentPieceFigure[i][j] != 0) {
					drawBlockOnGc(gcField, j + currentPiece.getX(), i + currentPiece.getY(), currentPieceFigure[i][j]);
				}
			}
		}
	}

	private void drawNextPiece() {
		int[][] nextPieceFigure = game.getNextPiece().getFigure();
		for (int i = 0; i < nextPieceFigure.length; i++) {
			for (int j = 0; j < nextPieceFigure[i].length; j++) {
				drawBlockOnGc(gcNextPiece, j, i, nextPieceFigure[i][j]);
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
	}

	private void render() {
		if (!game.isGameOver()) {
			clearAll();
			labelScore.setText(Integer.toString(game.getPoints()));
			drawField();
			if (game.getCurrentPiece() != null) {
				drawCurrentPiece();
			}
			if (game.getNextPiece() != null) {
				drawNextPiece();
			}
		} else {
			game.addCurrentGameToHighscore();
			timeline.stop();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		game = new Game();
		gcField = canvasField.getGraphicsContext2D();
		gcNextPiece = canvasNextPiece.getGraphicsContext2D();
		render();
		timeline = new Timeline(new KeyFrame(Duration.millis(20), ae -> {
			game.tick();
			render();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
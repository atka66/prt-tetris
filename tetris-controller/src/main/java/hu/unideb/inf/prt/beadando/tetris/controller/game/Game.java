package hu.unideb.inf.prt.beadando.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
	
	private static Logger logger = LoggerFactory.getLogger(Game.class);
	
	private Field field;
	private Piece currentPiece;
	private Piece nextPiece;
	private int points;
	private boolean gameOver;

	public Game() {
		gameOver = false;
		field = new Field();
		nextPiece = PieceFactory.CreateRandomPiece();
		logger.info("New game created.");
	}

	public void tick() {
		if (!gameOver) {
			if (currentPiece == null) {
				currentPiece = new Piece();
				currentPiece.setFigure(nextPiece.getFigure());
				nextPiece = PieceFactory.CreateRandomPiece();
			}
			currentPiece.move(0, 1);
		}
	}

	public void spawnCurrentPiece() {
		// TODO checking if the piece can fit in the field
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}

	public Piece getNextPiece() {
		return nextPiece;
	}

	public void setNextPiece(Piece nextPiece) {
		this.nextPiece = nextPiece;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}

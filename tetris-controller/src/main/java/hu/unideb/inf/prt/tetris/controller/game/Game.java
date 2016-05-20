package hu.unideb.inf.prt.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

	private static Logger logger = LoggerFactory.getLogger(Game.class);

	private Field field;
	private Piece currentPiece;
	private Piece nextPiece;
	private int points;
	private boolean gameOver;
	private int tickCount;

	public Game() {
		logger.info("New game created.");
		tickCount = 0;
		gameOver = false;
		field = new Field();
		nextPiece = PieceFactory.CreateRandomPiece();
	}

	public void addCurrentGameToHighscore() {
		// TODO
	}

	public void tick() {
		tickCount++;
		if (currentPiece == null) {
			logger.info("Next piece replaces current piece, and gets a new random one");
			currentPiece = new Piece();
			currentPiece.setFigure(nextPiece.getFigure());
			gameOver = field.isBadSpawn(currentPiece);
			nextPiece = PieceFactory.CreateRandomPiece();
		}
		if (tickCount % 30 == 0) {
			if (!field.isPieceCollide(currentPiece, PieceAction.DOWN)) {
				currentPiece.move(0, 1);
			} else {
				switch (field.settlePiece(currentPiece)) {
				case 1: {
					points += 40;
					logger.info("Points earned: 40; Current points: " + points);
					break;
				}
				case 2: {
					points += 100;
					logger.info("Points earned: 100; Current points: " + points);
					break;
				}
				case 3: {
					points += 300;
					logger.info("Points earned: 300; Current points: " + points);
					break;
				}
				case 4: {
					points += 1200;
					logger.info("Points earned: 1200; Current points: " + points);
					break;
				}
				}
				currentPiece = null;
			}
		}
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

	public int getTickCount() {
		return tickCount;
	}

	public void setTickCount(int tickCount) {
		this.tickCount = tickCount;
	}
}

package hu.unideb.inf.prt.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.prt.tetris.controller.field.Field;
import hu.unideb.inf.prt.tetris.controller.piece.Piece;
import hu.unideb.inf.prt.tetris.controller.piece.PieceAction;
import hu.unideb.inf.prt.tetris.controller.piece.PieceFactory;

/**
 * The representation of a simple game of Tetris.
 * 
 * @author Atka
 */
public class Game {

	/**
	 * The logger of the object
	 */
	private static Logger logger = LoggerFactory.getLogger(Game.class);

	/**
	 * The play area, where the pieces are spawned
	 */
	private Field field;
	/**
	 * The piece that is currently moved by the player
	 */
	private Piece currentPiece;
	/**
	 * The next piece, which is shown somewhere in the view to help the player
	 * make better choice on where to put the current piece
	 */
	private Piece nextPiece;
	/**
	 * The points the player currently has in this playing session
	 */
	private int points;
	/**
	 * Represents the state of the game
	 */
	private boolean gameOver;
	/**
	 * Counts the gametime, but acts like a timer. It is used to determine when
	 * to move down the current piece by one
	 */
	private int tickCount;

	/**
	 * Constructor to initialize a game
	 */
	public Game() {
		logger.info("New game created.");
		tickCount = 0;
		gameOver = false;
		field = new Field();
		nextPiece = PieceFactory.CreateRandomPiece();
	}

	/**
	 * Accounts an ammount of points according to the number of rows cleared at
	 * once
	 * 
	 * @param rows
	 *            the number of rows cleared at once
	 */
	public void accountRows(int rows) {
		switch (rows) {
		case 1: {
			points += 40;
			break;
		}
		case 2: {
			points += 100;
			break;
		}
		case 3: {
			points += 300;
			break;
		}
		case 4: {
			points += 1200;
			break;
		}
		}
		logger.info(rows + " row(s) cleared. Current points: " + points);
	}

	/**
	 * Acts like a 'listener' or 'handler' to small time intervals. It 'ticks'
	 * every 20 seconds by default (depending on the view). This method is
	 * responsible for the manual movement of the current piece, determining the
	 * endgame, settling a piece if it has something below it, generating new
	 * pieces and slowly moving the piece down automatically
	 */
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
				accountRows(field.settlePiece(currentPiece));
				currentPiece = null;
			}
		}
	}

	/**
	 * Getter method for the field
	 * @return the field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * Setter method for the field
	 * @param field the field to set
	 */
	public void setField(Field field) {
		this.field = field;
	}

	/**
	 * Getter method for the current piece
	 * @return the current piece
	 */
	public Piece getCurrentPiece() {
		return currentPiece;
	}

	/**
	 * Setter method for the current piece
	 * @param currentPiece the current piece to set
	 */
	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}

	/**
	 * Getter method for the next piece
	 * @return the next piece
	 */
	public Piece getNextPiece() {
		return nextPiece;
	}

	/**
	 * Setter method for the next piece
	 * @param nextPiece the next piece to set
	 */
	public void setNextPiece(Piece nextPiece) {
		this.nextPiece = nextPiece;
	}

	/**
	 * Getter method for the points
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Setter method for the points
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Getter method for the game state
	 * @return the state of the game
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Setter method for the game state
	 * @param gameOver the state of the game to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * Getter method for the tick count
	 * @return the tick count
	 */
	public int getTickCount() {
		return tickCount;
	}

	/**
	 * Setter method for the tick count
	 * @param tickCount the tick count to set
	 */
	public void setTickCount(int tickCount) {
		this.tickCount = tickCount;
	}
}

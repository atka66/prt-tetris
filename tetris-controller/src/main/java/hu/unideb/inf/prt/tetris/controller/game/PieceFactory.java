package hu.unideb.inf.prt.tetris.controller.game;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A basic factory with static methods to create a valid random {@link Piece},
 * or to create a unique one (for test purposes).
 * 
 * @author Atka
 */
public class PieceFactory {

	/**
	 * The logger of the object.
	 */
	private static Logger logger = LoggerFactory.getLogger(PieceFactory.class);

	/**
	 * This method creates a unique {@link Piece} by the given parameter.
	 * 
	 * @param figure
	 *            the figure of the new piece
	 * @return the piece with the figure of the parameter
	 */
	public static Piece CreatePiece(int[][] figure) {
		Piece resultPiece = new Piece();
		resultPiece.setFigure(figure);
		return resultPiece;
	}

	/**
	 * This method creates a random {@link Piece} with a random generator. The
	 * figures are legit representations of the original Tetris game's pieces.
	 * 
	 * @return the piece with a randomly generated legit figure
	 */
	public static Piece CreateRandomPiece() {
		Piece resultPiece = new Piece();
		Random randomNumber = new Random();
		switch (randomNumber.nextInt(7) + 1) {
		// I piece
		case 1: {
			resultPiece.setFigure(new int[][] { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } });
			logger.info("I piece created");
			break;
		}
		// J piece
		case 2: {
			resultPiece.setFigure(new int[][] { { 2, 0, 0 }, { 2, 2, 2 }, { 0, 0, 0 } });
			logger.info("J piece created");
			break;
		}
		// L piece
		case 3: {
			resultPiece.setFigure(new int[][] { { 0, 0, 3 }, { 3, 3, 3 }, { 0, 0, 0 } });
			logger.info("L piece created");
			break;
		}
		// O piece
		case 4: {
			resultPiece.setFigure(new int[][] { { 4, 4 }, { 4, 4 } });
			logger.info("O piece created");
			break;
		}
		// S piece
		case 5: {
			resultPiece.setFigure(new int[][] { { 0, 5, 5 }, { 5, 5, 0 }, { 0, 0, 0 } });
			logger.info("S piece created");
			break;
		}
		// T piece
		case 6: {
			resultPiece.setFigure(new int[][] { { 0, 6, 0 }, { 6, 6, 6 }, { 0, 0, 0 } });
			logger.info("T piece created");
			break;
		}
		// Z piece
		case 7: {
			resultPiece.setFigure(new int[][] { { 7, 7, 0 }, { 0, 7, 7 }, { 0, 0, 0 } });
			logger.info("Z piece created");
			break;
		}
		}
		return resultPiece;
	}
}
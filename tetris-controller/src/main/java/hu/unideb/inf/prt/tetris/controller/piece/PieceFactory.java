package hu.unideb.inf.prt.tetris.controller.piece;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PieceFactory {

	private static Logger logger = LoggerFactory.getLogger(PieceFactory.class);

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

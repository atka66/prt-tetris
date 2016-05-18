package hu.unideb.inf.prt.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Field {

	private static Logger logger = LoggerFactory.getLogger(Field.class);

	private int[][] map;

	public Field() {
		map = new int[20][10];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
	}

	public boolean isBadSpawn(Piece piece) {
		int[][] pieceFigure = piece.getFigure();
		for(int i = 0; i < pieceFigure.length; i++) {
			for(int j = 0; j < pieceFigure[i].length; j++) {
				if (pieceFigure[i][j] != 0 && map[piece.getY() + i][piece.getX() + j] != 0) {
					logger.info("GAME OVER! New piece cannot spawn");
					return true; 
				}
			}
		}
		return false;
	}

	public boolean isPieceCollideUnder(Piece piece) {
		int[][] figure = piece.getFigure();
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] != 0) {
					try {
						if (map[piece.getY() + i + 1][piece.getX() + j] != 0) {
							logger.info("Piece Collides (under) with an already settled piece");
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						logger.info("Piece Collides (under) with the border");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isPieceCollideSide(Piece piece, int xx) {
		int[][] figure = piece.getFigure();
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] != 0) {
					try {
						if (map[piece.getY() + i][piece.getX() + j + xx] != 0) {
							logger.info("Piece Collides (side) with an already settled piece");
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						logger.info("Piece Collides (side) with the border");
						return true;
					}
				}
			}
		}
		return false;
	}

	public void settlePiece(Piece piece) {
		int[][] figure = piece.getFigure();
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] != 0) {
					map[piece.getY() + i][piece.getX() + j] = figure[i][j];
				}
			}
		}
		logger.info("Piece settled");
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
}

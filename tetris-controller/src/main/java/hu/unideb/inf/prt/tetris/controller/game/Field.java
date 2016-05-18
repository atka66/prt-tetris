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

	public boolean isPieceCollide(Piece piece) {
		int[][] figure = piece.getFigure();
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] != 0) {
					try {
						if (map[piece.getY() + i + 1][piece.getX() + j] != 0) {
							logger.info("Piece Collides with an already settled piece");
							return true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						logger.info("Piece Collides with the border at [" + (piece.getX() + j) + ","
								+ (piece.getY() + i + 1) + "]");
						return true;
					}
				}
			}
		}
		return false;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
}

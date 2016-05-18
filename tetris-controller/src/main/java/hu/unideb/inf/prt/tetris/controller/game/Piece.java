package hu.unideb.inf.prt.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Piece {

	private static Logger logger = LoggerFactory.getLogger(Piece.class);

	private int[][] figure;
	private int x;
	private int y;

	public Piece() {
		x = 4;
		y = 0;
	}

	public void move(int xx, int yy) {
		x += xx;
		y += yy;
		logger.info("Piece moved to [" + x + "," + y + "]");
	}

	public int[][] getFigure() {
		return figure;
	}

	public void setFigure(int[][] figure) {
		this.figure = figure;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

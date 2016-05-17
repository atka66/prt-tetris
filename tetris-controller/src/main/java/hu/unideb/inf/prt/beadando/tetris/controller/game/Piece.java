package hu.unideb.inf.prt.beadando.tetris.controller.game;

public class Piece {
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

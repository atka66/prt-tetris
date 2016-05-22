package hu.unideb.inf.prt.tetris.controller.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The representation of a tetris piece.
 * 
 * @author Atka
 */
public class Piece {

	/**
	 * The logger of the object.
	 */
	private static Logger logger = LoggerFactory.getLogger(Piece.class);

	/**
	 * This is the current 'physical' appearance of the piece.
	 */
	private int[][] figure;
	/**
	 * How far is the figure from the left side.
	 */
	private int x;
	/**
	 * How far is the figure from the top.
	 */
	private int y;

	/**
	 * Constructor to set the initial position of a piece. A newly instantiated
	 * piece will always be spawned at the top-center, if the {@link Field} is a
	 * 10x20 grid.
	 */
	public Piece() {
		x = 4;
		y = 0;
	}

	/**
	 * Moves the piece.
	 * 
	 * @param xx
	 *            the number of steps in the X-axis
	 * @param yy
	 *            the number of steps in the Y-axis
	 */
	public void move(int xx, int yy) {
		x += xx;
		y += yy;
		logger.info("Piece moved to [" + x + "," + y + "]");
	}

	/**
	 * Rotates the figure of the piece by 90 degrees clockwise or
	 * counterclockwise.
	 * 
	 * @param right
	 *            if true, it turns clockwise, otherwise it turns
	 *            counterclockwise
	 */
	public void rotate(boolean right) {
		if (right) {
			int[][] figureTemp = new int[figure.length][figure[0].length];
			for (int i = 0; i < figureTemp.length; i++) {
				for (int j = 0; j < figureTemp[i].length; j++) {
					figureTemp[i][j] = figure[(figure.length - 1) - j][i];
				}
			}
			figure = figureTemp;
		} else {
			int[][] figureTemp = new int[figure.length][figure[0].length];
			for (int i = 0; i < figureTemp.length; i++) {
				for (int j = 0; j < figureTemp[i].length; j++) {
					figureTemp[i][j] = figure[j][(figure[i].length - 1) - i];
				}
			}
			figure = figureTemp;
		}
		logger.info("Piece rotated " + (right ? "clockwised" : "counterclockwised"));
	}

	/**
	 * Getter method for the figure.
	 * 
	 * @return the figure
	 */
	public int[][] getFigure() {
		return figure;
	}

	/**
	 * Setter method for the figure.
	 * 
	 * @param figure
	 *            the figure to set
	 */
	public void setFigure(int[][] figure) {
		this.figure = figure;
	}

	/**
	 * Getter method for the distance from the left side.
	 * 
	 * @return the distance from the left side
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for the distance from the left side.
	 * 
	 * @param x
	 *            the distance to set from the left side
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter method for the distance from the top.
	 * 
	 * @return the distance from the top
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for the distance from the top.
	 * 
	 * @param y
	 *            the distance to set from the top
	 */
	public void setY(int y) {
		this.y = y;
	}
}

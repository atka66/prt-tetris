package hu.unideb.inf.prt.tetris.controller.game;

/**
 * The enumeration of the several actions a piece can do including three
 * movement, and two rotating actions.
 * 
 * @author Atka
 */
public enum PieceAction {
	/**
	 * Downward movement.
	 */
	DOWN,
	/**
	 * Movement to the left.
	 */
	LEFT,
	/**
	 * Movement to the right.
	 */
	RIGHT,
	/**
	 * Rotation to the left.
	 */
	ROTATE_LEFT,
	/**
	 * Rotation to the right.
	 */
	ROTATE_RIGHT
}

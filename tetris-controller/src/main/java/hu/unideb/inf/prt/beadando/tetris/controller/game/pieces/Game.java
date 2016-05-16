package hu.unideb.inf.prt.beadando.tetris.controller.game.pieces;

public class Game {
	private Field field;
	private Piece currentPiece;
	private Piece nextPiece;
	private int points;

	public Game() {
		field = new Field();
		nextPiece = PieceFactory.CreateRandomPiece();
	}

	public void tick() {
		if (currentPiece == null) {
			currentPiece = new Piece();
			currentPiece.setFigure(nextPiece.getFigure());
			nextPiece = PieceFactory.CreateRandomPiece();
			spawnCurrentPiece();
		}
		// TODO moving pieces
	}

	public void spawnCurrentPiece() {
		// TODO checking if the piece can fit in the field
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
}

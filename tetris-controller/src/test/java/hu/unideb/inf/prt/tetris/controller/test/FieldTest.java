package hu.unideb.inf.prt.tetris.controller.test;

import org.junit.Assert;
import org.junit.Test;

import hu.unideb.inf.prt.tetris.controller.field.Field;
import hu.unideb.inf.prt.tetris.controller.piece.Piece;
import hu.unideb.inf.prt.tetris.controller.piece.PieceAction;

public class FieldTest {

	@Test
	public void isBadSpawnTest() {
		Field fieldTest = new Field();
		Piece pieceTest = new Piece();
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 0 } });
		pieceTest.setFigure(new int[][] { { 1 } });
		Assert.assertEquals(false, fieldTest.isBadSpawn(pieceTest));
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 1 } });
		Assert.assertEquals(true, fieldTest.isBadSpawn(pieceTest));
	}

	@Test
	public void isPieceCollideTest() {
		Field fieldTest = new Field();
		Piece pieceTest = new Piece();
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } });
		pieceTest.setFigure(new int[][] { { 1 } });
		Assert.assertEquals(false, fieldTest.isPieceCollide(pieceTest, PieceAction.LEFT));
		Assert.assertEquals(false, fieldTest.isPieceCollide(pieceTest, PieceAction.RIGHT));
		Assert.assertEquals(false, fieldTest.isPieceCollide(pieceTest, PieceAction.DOWN));
		fieldTest.setMap(new int[][] { { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } });
		Assert.assertEquals(true, fieldTest.isPieceCollide(pieceTest, PieceAction.LEFT));
		Assert.assertEquals(true, fieldTest.isPieceCollide(pieceTest, PieceAction.RIGHT));
		Assert.assertEquals(true, fieldTest.isPieceCollide(pieceTest, PieceAction.DOWN));
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } });
		pieceTest.setFigure(new int[][] { { 1, 0 }, { 0, 0 } });
		Assert.assertEquals(false, fieldTest.isPieceCollide(pieceTest, PieceAction.ROTATE_LEFT));
		Assert.assertEquals(false, fieldTest.isPieceCollide(pieceTest, PieceAction.ROTATE_RIGHT));
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0 } });
		Assert.assertEquals(true, fieldTest.isPieceCollide(pieceTest, PieceAction.ROTATE_LEFT));
		Assert.assertEquals(true, fieldTest.isPieceCollide(pieceTest, PieceAction.ROTATE_RIGHT));
	}

	@Test
	public void settlePieceTest() {
		Field fieldTest = new Field();
		Piece pieceTest = new Piece();
		fieldTest.setMap(new int[][] { { 0, 0, 0, 0, 0 } });
		pieceTest.setFigure(new int[][] { { 1 } });
		fieldTest.settlePiece(pieceTest);
		Assert.assertEquals(1, fieldTest.getMap()[0][4]);
	}
}

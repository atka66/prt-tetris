package hu.unideb.inf.prt.tetris.controller.test;

import org.junit.Assert;
import org.junit.Test;

import hu.unideb.inf.prt.tetris.controller.piece.Piece;
import hu.unideb.inf.prt.tetris.controller.piece.PieceFactory;

public class PieceTest {
	
	@Test
	public void test() {
		Piece testPiece = PieceFactory.CreatePiece(new int[][] {{1,0},{0,0}});
		int x = testPiece.getX();
		int y = testPiece.getY();
		testPiece.move(1, 1);
		Assert.assertEquals(x + 1, testPiece.getX());
		Assert.assertEquals(y + 1, testPiece.getY());
		testPiece.rotate(true);
		Assert.assertEquals(0, testPiece.getFigure()[0][0]);
		Assert.assertEquals(1, testPiece.getFigure()[0][1]);
		testPiece.rotate(false);
		Assert.assertEquals(1, testPiece.getFigure()[0][0]);
		Assert.assertEquals(0, testPiece.getFigure()[0][1]);
	}
}

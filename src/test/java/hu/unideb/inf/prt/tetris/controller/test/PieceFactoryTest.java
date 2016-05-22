package hu.unideb.inf.prt.tetris.controller.test;

import org.junit.Assert;
import org.junit.Test;

import hu.unideb.inf.prt.tetris.controller.game.Piece;
import hu.unideb.inf.prt.tetris.controller.game.PieceFactory;

public class PieceFactoryTest {

	@Test
	public void createPieceTest() {
		int[][] pattern = new int[][] { { 1, 0 }, { 0, 1 } };
		Piece testPiece = PieceFactory.CreatePiece(pattern);
		Assert.assertEquals(1, testPiece.getFigure()[0][0]);
		Assert.assertEquals(0, testPiece.getFigure()[0][1]);
		Assert.assertEquals(0, testPiece.getFigure()[1][0]);
		Assert.assertEquals(1, testPiece.getFigure()[1][1]);
	}

	@Test
	public void createRandomPieceTest() {
		for (int i = 0; i < 100; i++) {
			PieceFactory.CreateRandomPiece();
		}
	}
}

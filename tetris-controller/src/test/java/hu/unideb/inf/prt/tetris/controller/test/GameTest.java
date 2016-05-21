package hu.unideb.inf.prt.tetris.controller.test;

import org.junit.Assert;
import org.junit.Test;

import hu.unideb.inf.prt.tetris.controller.game.Game;

public class GameTest {
	
	@Test
	public void gameOverTest() {
		Game gameTest = new Game();
		int counter = 0;
		while (!gameTest.isGameOver()) {
			gameTest.tick();
			if (counter > 500) {
				Assert.fail();
			}
		}
	}

	@Test
	public void gameAccountRowsTest() {
		Game gameTest = new Game();
		gameTest.accountRows(1);
		gameTest.accountRows(2);
		gameTest.accountRows(3);
		gameTest.accountRows(4);
		Assert.assertEquals(1640, gameTest.getPoints());
	}
}

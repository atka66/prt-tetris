package hu.unideb.inf.prt.tetris.model.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;
import hu.unideb.inf.prt.tetris.model.service.HighscoreService;
import hu.unideb.inf.prt.tetris.model.serviceImpl.HighscoreServiceImpl;

public class ModelTest {
	@Test
	public void modelTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HighscoreDb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			HighscoreService highscoreService = new HighscoreServiceImpl(entityManager);

			highscoreService.add(new Highscore("TESTPLAYER", 123456));
			int id = highscoreService.getAll().stream()
					.filter(h -> h.getPlayer().equals("TESTPLAYER") && h.getScore() == 123456).findFirst().orElse(null)
					.getId();
			Highscore highscore = highscoreService.getById(id);
			Assert.assertEquals("TESTPLAYER", highscore.getPlayer());
			Assert.assertEquals(123456, highscore.getScore());
			highscoreService.removeById(id);
			Assert.assertEquals(null,
					highscoreService.getAll().stream()
							.filter(h -> h.getPlayer().equals("TESTPLAYER") && h.getScore() == 123456).findFirst()
							.orElse(null));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}

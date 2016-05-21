package hu.unideb.inf.prt.tetris.model.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;
import hu.unideb.inf.prt.tetris.model.service.HighscoreService;

public class HighscoreServiceImpl implements HighscoreService {

	private static Logger logger = LoggerFactory.getLogger(HighscoreServiceImpl.class);

	EntityManager entityManager;

	public HighscoreServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void add(Highscore highscore) {
		logger.info("New score added to HIGHSCORE table");
		entityManager.persist(highscore);
	}

	@Override
	public List<Highscore> getAll() {
		logger.info("Getting all score from HIGHSCORE table");
		return entityManager
				.createQuery("SELECT h from hu.unideb.inf.prt.tetris.model.entity.Highscore h", Highscore.class)
				.getResultList();
	}

}

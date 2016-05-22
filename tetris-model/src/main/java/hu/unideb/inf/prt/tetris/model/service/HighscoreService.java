package hu.unideb.inf.prt.tetris.model.service;

import java.util.List;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;

/**
 * Interface for the Highscore service. It contains basic methods for a standard
 * database service.
 * 
 * @author Atka
 */
public interface HighscoreService {
	/**
	 * Adds the parameter entity to the database.
	 * 
	 * @param highscore
	 *            the highscore entity to persist
	 */
	public void add(Highscore highscore);

	/**
	 * Returns every highscore entity in the database.
	 * 
	 * @return the list of entities in the database
	 */
	public List<Highscore> getAll();

	/**
	 * Returns a highscore entity by its ID.
	 * 
	 * @param id
	 *            the ID of the entity
	 * @return the entity with the ID
	 */
	public Highscore getById(int id);

	/**
	 * Removes a highscore entity by its ID from the database.
	 * 
	 * @param id
	 *            the ID of the entity to delete
	 */
	public void removeById(int id);
}

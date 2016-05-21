package hu.unideb.inf.prt.tetris.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * The entity object for the records in the HIGHSCORE table
 * 
 * @author Atka
 */
@Entity(name = "highscore")
public class Highscore {

	/**
	 * The ID of the Highscore
	 */
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "IdGenerator", sequenceName = "hssequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int id;
	/**
	 * The name of the player
	 */
	private String player;
	/**
	 * The score the player reached
	 */
	private int score;

	/**
	 * Empty constructor
	 */
	public Highscore() {
		super();
	}

	/**
	 * Constructor to initialize the fields
	 * 
	 * @param player
	 *            the player to set
	 * @param score
	 *            the score to set
	 */
	public Highscore(String player, int score) {
		super();
		this.player = player;
		this.score = score;
	}

	/**
	 * Getter method for ID
	 * 
	 * @return the ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for ID
	 * 
	 * @param id
	 *            the ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter method for the player
	 * 
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * Setter method for the player
	 * 
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}

	/**
	 * Getter method for the score
	 * 
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter method for the score
	 * 
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
}

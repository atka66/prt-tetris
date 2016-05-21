package hu.unideb.inf.prt.tetris.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "highscore")
public class Highscore {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "IdGenerator", sequenceName = "hssequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	private int id;
	private String player;
	private int score;

	public Highscore() {
		super();
	}

	public Highscore(String player, int score) {
		super();
		this.player = player;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

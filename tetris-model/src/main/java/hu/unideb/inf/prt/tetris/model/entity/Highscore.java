package hu.unideb.inf.prt.tetris.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "highscore")
@XmlAccessorType(XmlAccessType.FIELD)
public class Highscore {

	private String player;
	private Long score;

	public Highscore() {
		super();
	}

	public Highscore(String player, Long score) {
		super();
		this.player = player;
		this.score = score;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
}

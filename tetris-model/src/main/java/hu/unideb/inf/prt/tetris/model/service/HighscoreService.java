package hu.unideb.inf.prt.tetris.model.service;

import java.util.List;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;

public interface HighscoreService {
	public void add(Highscore highscore);
	public List<Highscore> getAll();
	public Highscore getById(int id);
	public void removeById(int id);
	
}

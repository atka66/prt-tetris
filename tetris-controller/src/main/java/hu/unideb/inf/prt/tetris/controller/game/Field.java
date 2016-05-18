package hu.unideb.inf.prt.tetris.controller.game;

public class Field {
	
	private int[][] map;

	public Field() {
		setMap(new int[20][10]);
		for(int i = 0; i < getMap().length; i++) {
			for(int j = 0; j < getMap()[i].length; j++) {
				getMap()[i][j] = 0;
			}
		}
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
}

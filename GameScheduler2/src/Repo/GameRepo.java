package Repo;

import POJO.Game;

public class GameRepo implements IGameRepo {
	private Game[] games;

	public GameRepo() {
	}

	public GameRepo(Game[] games) {
		this.games = games;
	}

	public String save(Game g) {
		return "";
	}

	public Game findOne(String name) {
		
		for(int i=0; i<games.length; i++) {
			if(games[i] != null) {
				if(games[i].getName().equals(name)) {
					System.out.println("came here");
					return new Game("repeat", 1);
				}
			}
		}

		return new Game("new", 2);
	}

	public Game[] findAll() {
		return games;
	}

	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}

}

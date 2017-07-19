package Repo;

import POJO.Game;
import POJO.Player;

public class PlayerRepo implements IPlayerRepo {
	private Player[] players;
	
	public PlayerRepo() {
	}
	
	public PlayerRepo(Player[] players) {
		this.players = players;
	}

	public String save(Player p) {
		return "";
	}
	public Player findOne(String name) {
		for(int i=0; i<players.length; i++) {
			if(players[i] != null) {
				if(players[i].getName().equals(name)) {
					System.out.println("came here");
					Game[] games = new Game[5];
					return new Player("repeat", games);
				}
			}
		}
		
		Game[] games2 = new Game[5];
		return new Player("new", games2);
	}
	public Player[] findAll() {
		return players;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
}

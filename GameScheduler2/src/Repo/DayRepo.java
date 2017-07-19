package Repo;

import POJO.Day;
import POJO.Game;
import POJO.Player;

public class DayRepo implements IDayRepo {
	private Day[] days;
	
	public DayRepo() {
	}
	
	public DayRepo(Day[] days) {
		this.days = days;
	}

	public String save(Day d) {
		return "";
	}
	public Day findOne(String name) {
		for(int i=0; i<days.length; i++) {
			if(days[i] != null) {
				if(days[i].getName().equals(name)) {
					System.out.println("came here");
					Game[] games = new Game[5];
					return new Day("repeat", games);
				}
			}
		}
		
		Game[] games2 = new Game[5];
		return new Day("new", games2);
	}
	public Day[] findAll() {
		return new Day[5];
	}

	public Day[] getDays() {
		return days;
	}

	public void setDays(Day[] days) {
		this.days = days;
	}
	
}

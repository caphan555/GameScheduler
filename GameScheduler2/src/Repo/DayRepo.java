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
		Day[] days = this.getDays();
		int daySize = days.length;

		if (days[--daySize] != null) {

			int newDaySize = days.length;
			++newDaySize;
			Day[] newDays = new Day[newDaySize];

			for (int t = 0; t < days.length; t++) {
				//
				//System.out.println(d.getName());
				//System.out.println("Sorting new array " + t);
				newDays[t] = days[t];
			}
			//
			newDays[--newDaySize] = d;
			this.setDays(newDays);
			/*for (Day dayTry : dayRepo.getDays()) {
				System.out.println("Testing game presence");
				System.out.println(dayTry.getName());
			}*/

			return "success";
		} else {
			//System.out.println("Entered first if");
			for (int i = 0; i < days.length; i++) {
				if (days[i] != null) {
					//System.out.println("Hit games[i] not null " + i);
					continue;
				} else {
					//System.out.println("Hit games[i] null " + i);
					//
					days[i] = d;
					return "success";
				}
			}
		}
		return "success";
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

package Scheduler;

import java.util.Scanner;

import POJO.Day;
import POJO.Game;
import POJO.Player;
import Repo.DayRepo;
import Repo.GameRepo;
import Repo.PlayerRepo;
import Service.SchedulerService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameRepo gameRepo = new GameRepo(new Game[5]);
		DayRepo dayRepo = new DayRepo(new Day[5]);
		PlayerRepo playerRepo = new PlayerRepo(new Player[5]);
		
		SchedulerService ss = new SchedulerService(gameRepo, playerRepo, dayRepo);
		setUp(ss);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("GAME SCHEDULER READY");
		System.out.println("TYPE IN NUMBER OF ACTION");
		System.out.println("1) Game wise report");
		System.out.println("2) Player wise report");
		System.out.println("3) Day wise report");
		System.out.print("Chosen Action: ");

		String action = sc.nextLine();

		if (action.equals("1")) {
			System.out.print("Enter name of game: ");
			String gameName = sc.nextLine();
			//System.out.println("gameName: " + gameName);
			StringBuffer gameWiseResult = ss.gameWiseReport(gameName);
			
			System.out.println("==========================================");
			System.out.println("GAME WISE REPORT");
			System.out.println("==========================================");
			
			System.out.print(gameWiseResult.toString());
			
			System.out.println("==========================================");
			System.out.println("END OF REPORT");
			System.out.println("==========================================");
		} else if (action.equals("2")) {
			System.out.print("Enter name of player: ");
			String playerName = sc.nextLine();
			System.out.println("PLayer name: " + playerName);
			StringBuffer playerWiseResult = ss.playerWiseReport(playerName);
			//System.out.println("Testing: "+playerWiseResult);
			
			System.out.println("==========================================");
			System.out.println("PLAYER WISE REPORT");
			System.out.println("==========================================");
			
			System.out.print(playerWiseResult.toString());
			
			System.out.println("==========================================");
			System.out.println("END OF REPORT");
			System.out.println("==========================================");
		} else if (action.equals("3")) {
			System.out.print("Enter name of day: ");
			String dayName = sc.nextLine();
			StringBuffer dayWiseResult = ss.dayWiseReport(dayName);
			
			System.out.println("==========================================");
			System.out.println("DAY WISE REPORT");
			System.out.println("==========================================");
			
			System.out.print(dayWiseResult.toString());
			
			
			System.out.println("==========================================");
			System.out.println("END OF REPORT");
			System.out.println("==========================================");
		}
		
	}
	
	public static void setUp(SchedulerService ss) {
		//Set Up Game
		Game game1 = new Game("Basketball", 5);
		Game game2 = new Game("Pingpong", 2);
		Game game3 = new Game("Tennis", 2);
		Game game4 = new Game("Soccer", 11);
		Game game5 = new Game("Rugby", 4);
		
		String gameResult1 = ss.createGame(game1);
		String gameResult2 = ss.createGame(game2);
		String gameResult3 = ss.createGame(game3);
		String gameResult4 = ss.createGame(game4);
		String gameResult5 = ss.createGame(game5);
		
		/*System.out.println("Testing added games");
		for(int i=0; i<ss.getGameRepo().getGames().length; i++) {
			Game[] games = ss.getGameRepo().getGames();
			System.out.println("game: "+games[i].getName());
		}*/
		
		//Set Up Players
		Game[] player1Games = {game1, game2};
		Player player1 = new Player("Xiaoming", player1Games);
		Game[] player2Games = {game2, game3};
		Player player2 = new Player("Ali", player2Games);
		Game[] player3Games = {game1, game2, game3};
		Player player3 = new Player("Kumar", player3Games);
		Game[] player4Games = {game5};
		Player player4 = new Player("Aileen", player4Games);
		Game[] player5Games = {game2, game4};
		Player player5 = new Player("Peiyi", player5Games);
		
		String playerResult1 = ss.createPlayer(player1);
		String playerResult2 = ss.createPlayer(player2);
		String playerResult3 = ss.createPlayer(player3);
		String playerResult4 = ss.createPlayer(player4);
		String playerResult5 = ss.createPlayer(player5);
		
		/*Player[] players = ss.getPlayerRepo().getPlayers();
		System.out.println("printing players");
		for(int t=0; t<players.length; t++) {
			System.out.println("Player: " +players[t].getName());
		}*/
		
		//Set Up Days
		Game[] day1Games = {game1, game2};
		Day day1 = new Day("Day1", day1Games);
		Game[] day2Games = {game2, game3};
		Day day2 = new Day("Day2", day2Games);
		Game[] day3Games = {game1, game2, game3};
		Day day3 = new Day("Day3", day3Games);
		Game[] day4Games = {game5};
		Day day4 = new Day("Day4", day4Games);
		Game[] day5Games = {game2, game4};
		Day day5 = new Day("Day5", day5Games);
		
		String dayResult1 = ss.createDay(day1);
		String dayResult2 = ss.createDay(day2);
		String dayResult3 = ss.createDay(day3);
		String dayResult4 = ss.createDay(day4);
		String dayResult5 = ss.createDay(day5);
		
		/*System.out.println("Check Days");
		Day[] days = ss.getDayRepo().getDays();
		for(int a=0; a<days.length; a++) {
			System.out.println("Day: "+days[a].getName());
		}*/
		
		
	}
}

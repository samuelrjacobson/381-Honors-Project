import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// Observers
        Team team1 = new Team();
        Team team2 = new Team();
        String team1Name = "Oregon State";
        String team2Name = "Washington State";
        
        // Subject
        ScoreTracker scoreTracker = new ScoreTracker();
 
        // Register observers with subject
        scoreTracker.registerObserver(team1, team1Name);
        scoreTracker.registerObserver(team2, team2Name);
 
        // Receive score input from user (keyboard)
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < 8; i++) {
        	
	        System.out.print("\n" + team1Name + " score: ");
	        int team1Score = keyboard.nextInt();
	        System.out.print(team2Name + " score: ");
	        int team2Score = keyboard.nextInt();
	        
	        // Send data to Subject
	        scoreTracker.update(team1Name, team2Name, team1Score, team2Score);
        }
        
        // Calculate victor
        String winner = "";
        if(team1.getWins() > team2.getWins()) winner = team1.getName();
        else if(team1.getWins() < team2.getWins()) winner = team2.getName();
        else {
        	if(team1.getPoints() > team2.getPoints()) winner = team1.getName();
            else if(team1.getPoints() < team2.getPoints()) winner = team2.getName();
            else winner = team1Name + " and " + team2Name;
        }

        System.out.println("The PAC-2 Champion is " + winner + "!");
        keyboard.close();
	}
}

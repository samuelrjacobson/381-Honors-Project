// Observer interface
interface Observer {
    public void update(int pointsScored, int pointsAllowed);
    public String getName();
    public void setName(String name);
}

// Observer implementation
public class Team implements Observer {
	private String name;
    private int totalPointsScored;
    private int totalPointsAllowed;
    private int gamesWon;
    private int gamesLost;
    
    public Team() {
    	totalPointsScored = 0;
        totalPointsAllowed = 0;
        gamesWon = 0;
        gamesLost = 0;
    }
    
    // Subject sends data, observers process
    @Override
    public void update(int pointsScored, int pointsAllowed) {
        if(pointsScored > pointsAllowed) gamesWon++;
        else gamesLost++;
        totalPointsScored += pointsScored;
        totalPointsAllowed += pointsAllowed;
        
        // Display results
        System.out.println(name + " scores:");
        System.out.println("Total Points Scored (all games): " + totalPointsScored);
        System.out.println("Total Points Allowed (all games): " + totalPointsAllowed);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Games lost: " + gamesLost);
    }
    
    // Getters and setters
    @Override
    public String getName() {
    	return name;
    }
    @Override
    public void setName(String name) {
    	this.name = name;
    }
    public int getWins() {
    	return gamesWon;
    }
    public double getPoints() {
    	return (double) totalPointsScored - totalPointsAllowed;
    }
}
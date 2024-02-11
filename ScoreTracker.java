import java.util.ArrayList;
import java.util.Iterator;
 
// Subject interface
interface Subject {
    public void registerObserver(Observer o, String name);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}
 
// Subject implementation
class ScoreTracker implements Subject {
	String team1Name;
	String team2Name;
    int team1Score;
    int team2Score;
    ArrayList<Observer> observerList;	// list of registered observers
 
    public ScoreTracker() {
        observerList = new ArrayList<Observer>();
    }
 
    // Register observer/add to list
    @Override
    public void registerObserver(Observer o, String name) {
        observerList.add(o);
        o.setName(name);
    }
 
    // Unregister observer/remove from list
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }
 
    // Notify observers of state change
    @Override
    public void notifyObservers() {
        for (Iterator<Observer> it =
              observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            if(o.getName().equals(team1Name)) {
            	o.update(team1Score, team2Score);
            }
            if(o.getName().equals(team2Name)) o.update(team2Score, team1Score);
        }
    }
  
    // Receive new data from main program
    public void update(String team1Name, String team2Name, int team1Score, int team2Score) {
    	this.team1Name = team1Name;
    	this.team2Name = team2Name;
    	this.team1Score = team1Score;
    	this.team2Score = team2Score;
    	
        notifyObservers();
    }
}
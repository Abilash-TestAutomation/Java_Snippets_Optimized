package mapsTechniques;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class IntersectMoreArrayList {
	
	String name;
    int odiRuns;
    int t20Runs;
    int testRuns;

	public IntersectMoreArrayList(String name, int odiRuns, int t20Runs, int testRuns) {
		this.name = name;
        this.odiRuns = odiRuns;
        this.t20Runs = t20Runs;
        this.testRuns = testRuns;
        
        
	}
	// Calculate total runs across all formats
    public int getTotalRuns() {
        return odiRuns + t20Runs + testRuns;
    }

    @Override
    public String toString() {
        return name + " | Total Runs: " + getTotalRuns() + " | ODI: " + odiRuns + " | T20: " + t20Runs + " | Test: " + testRuns;
    }
	

	public static void main(String[] args) {

		// Initialize ArrayList to store runs from all formats
		ArrayList<Map.Entry<String, Integer>> odiRuns = new ArrayList<>();
		ArrayList<Map.Entry<String, Integer>> t20Runs = new ArrayList<>();
		ArrayList<Map.Entry<String, Integer>> testRuns = new ArrayList<>();

		//Add Players's runs in all List based on the format

		odiRuns.add(Map.entry("Sachin", 10000));
		odiRuns.add(Map.entry("Kholi", 9000));
		odiRuns.add(Map.entry("Rohit", 8000));
		odiRuns.add(Map.entry("Dhoni", 6000));
		odiRuns.add(Map.entry("Hardik", 3000));

		t20Runs.add(Map.entry("Sachin", 5000));
		t20Runs.add(Map.entry("Kohli", 7000));
		t20Runs.add(Map.entry("Rohit", 6000));
		t20Runs.add(Map.entry("Dohni", 4000));
		t20Runs.add(Map.entry("Hardik", 5000));

		testRuns.add(Map.entry("Sachin", 13000));
		testRuns.add(Map.entry("Kohli", 11000));
		testRuns.add(Map.entry("Rohit", 4000));
		testRuns.add(Map.entry("Dhoni", 8000));
		testRuns.add(Map.entry("Hardik", 2000));
		
		//Creating Map that is going to hold object for each players with their name as key
		Map<String,IntersectMoreArrayList> PlayerMap = new HashMap<>();
		
		/*
		 * Fill the Map with objects for all players with names as Key and Values for each format
		 * First loop will store objects for each player with thier name as key + odi runs as value
		 * for t20 and test, values will be initialized as 0 and stored in the next 2 loops
		 */
		
		//First Loop
		for(Map.Entry<String, Integer> getRuns:odiRuns) {
			PlayerMap.put(getRuns.getKey(), new IntersectMoreArrayList(getRuns.getKey(),getRuns.getValue(),0,0));
		}
				
		for(Map.Entry<String,Integer>getRuns:t20Runs) {
			IntersectMoreArrayList getPlayerObj = PlayerMap.get(getRuns.getKey());//Fetch the object of each player
			getPlayerObj.t20Runs = getRuns.getValue();//This will assign the value to t20 runs bassed on object
		}
		
		for(Map.Entry<String,Integer>getRuns:testRuns) {
			IntersectMoreArrayList getPlayerObj = PlayerMap.get(getRuns.getKey());//Fetch the object of each player
			getPlayerObj.testRuns = getRuns.getValue();//This will assign the value to t20 runs bassed on object
		}
		
		//Creating ArrayList to sort the the objects
		/*
		 * Passing class name as a type to ArrayList is called generics
		 * Specifying to compiler clearly that this can hold only objects related to this class
		 * Error will be thrown if you accidentally add any new values
		 * And also, if you don't use this then everytime you need to add and type cast
		 * And if you dont pass Map's oject as parameter  to ArrayList object then each time u need add values 1 by 1
		 */
		
		ArrayList<IntersectMoreArrayList> getPlayersInfo = new ArrayList<>(PlayerMap.values());
		
		/*
		 * Imagine now arraylist will be as below
		 * players.add(new Player("Sachin", 18426, 2000, 15921));
           players.add(new Player("Dhoni", 10773, 1617, 4876));
           players.add(new Player("Virat", 12311, 4008, 8472));
		 */
        
		/*
		 * Player::getTotalRuns means that the comparator will call the getTotalRuns() method on each Player object in the list.
		 * Initially sorted in ascending order
		 * 
		 */

		getPlayersInfo.sort(Comparator.comparingInt(IntersectMoreArrayList::getTotalRuns)
                .thenComparingInt(player -> player.odiRuns)
                .reversed());
		
		// Display sorted results
        System.out.println("Sorted players from Top to Low based on Total Runs (Tie breaker: ODI Runs):");
        for (IntersectMoreArrayList player : getPlayersInfo) {
            System.out.println(player);
        }
	}

}

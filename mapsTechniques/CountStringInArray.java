package mapsTechniques;

import java.util.HashMap;
import java.util.Map;

public class CountStringInArray {

	public static void main(String[] args) {

		//Declare String Array
		String[] fruits = {"Apple","Orange","Banana","Apple"};
		//Declare Map to get and Print the Strings with Occurrenace
		Map<String, Integer> getList = getCount(fruits);
		
		//Print the Map entries with Fruit and its occurance
		for(Map.Entry<String, Integer> getResult: getList.entrySet())
		{
			System.out.println(getResult.getKey() + ": " + getResult.getValue());
		}
	}

	private static Map<String, Integer> getCount(String[] fruits) {
		//Declare Map to store fruits name with count
		Map<String, Integer> countFruits = new HashMap<>();
		//Declare for each loop to get fruit one by one and check and put in Map pair
		for(String getFruit:fruits)
		{
			countFruits.put(getFruit, countFruits.getOrDefault(getFruit,0)+1);
		}
		return countFruits;
	}

}

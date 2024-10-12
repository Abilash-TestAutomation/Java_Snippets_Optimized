package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class HardCandies {

	/*
	 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
	 * int[] ratings =[1,0,2]
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * int[] candies = [1,1,1]
	 * Children with a higher rating get more candies than their neighbors. that means, compare in any way inside array
	 * the children with more rating will have more candies finally based on input
	 * Logic to be written for this
	 * Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
Finally return number of candies distributed
	 */

	public static void main(String[] args) {
		int[] ratings = {1,2,2,5,6,7,2,3};
		int[] candies = new int[ratings.length];
		System.out.println("Number of candies distribued: "+ candiesdistribution(ratings,candies));
		System.out.println("Ratings: " + Arrays.toString(ratings));
        System.out.println("Candies: " + Arrays.toString(candies));
	}

	private static int candiesdistribution(int[] ratings,int[] candies) {

		int n = ratings.length;
		// Base case
		if(n==0)
		{
			return 0;
		}
		//Distribute at least one candies to all Children
		Arrays.fill(candies, 1);
		/*
		 * so candies[0]=1, candies[1]=1, candies[2]=1
		 * Always where there is list and all the date inside the list to be compared then use 2 loops or 2 iterator etc
		 */
		//Left pass -> compare from the left i.e 2nd with 1st, 3rd with 2nd ......
		for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
		//Right pass -> compare from the right i.e Last's previous with last
		for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
            	candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        	   // we can't ue candies[i+1]+ 1 because candies will be distriubuted unevenly
        	   //consider condition is Math.max(2,2) -> then distrubution is not needed.
           }
		}
		
		//Now calculate the total candies.
		//Always when you want to manipulate the values in the array either use for foreach or iterator if list is used or mtry if hash is used
		
		int totalcandies = 0; //always initialize to 0 when you want to increment it with values in array and should be returned
		for(int candy:candies)
		{
			totalcandies +=candy;
		}
		return totalcandies;
	}
}

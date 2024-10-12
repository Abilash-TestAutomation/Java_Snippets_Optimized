package listTechniques;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountVowels {

	public static void main(String[] args) {

		String inputString = "Hello world!";
		int getCount = countVowels(inputString);
		System.out.println("No. of Vowles Present in the String:"+getCount);

	}

	private static int countVowels(String inputString) {

		//Basecase
		if(inputString==null)
		{
			return 0;
		}

		int count = 0;
		String vowles = "aeiouAEIOU";
		List<Character> getVowels = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if(vowles.indexOf(ch)!=-1) 
			{
				count++; 
				getVowels.add(ch);
			}

		}
		System.out.println("Vowels Found are: "+getVowels);
		return count;
	}

	/**
	 * Following is the another approach using Regex
	 * Recommendation: If performance and efficiency are paramount, especially with large datasets, Method 1 is the better choice. 
	 * If you prefer a more declarative and concise style and are dealing with smaller strings where the overhead is negligible, Method 2 can be suitable.
	 */

	//	private static final Pattern VOWEL_PATTERN = Pattern.compile("[aeiouAEIOU]");
	//
	//    public static long countAndPrintVowels(String input) {
	//        if (input == null) return 0;
	//        
	//        Matcher matcher = VOWEL_PATTERN.matcher(input);
	//        List<String> vowelsFound = new ArrayList<>();
	//        
	//        while (matcher.find()) {
	//            vowelsFound.add(matcher.group()); // Store each vowel found
	//        }
	//
	//        // Print the vowels
	//        System.out.println("Vowels found: " + vowelsFound);
	//
	//        return vowelsFound.size();
	//    }

	/*
	 * 
	 * Below are the 2 more approaches can be use but still Method 1 stands tall in terms of overhead, space, performance, Maintainability and readability
	 * eventhough time complexity is O(n) in all both space is O(1) for Method 1. 
	 * Lets see how to use other 2 approached below.
	 * Iterator with List
	 * For Each with List
	 */

	//	//public static int countVowels(String input) {
	//        if (input == null) return 0;
	//        
	//        int count = 0;
	//        String vowels = "aeiouAEIOU";
	//        
	//        // Convert the string to a List<Character>
	//        List<Character> charList = new ArrayList<>();
	//        for (char ch : input.toCharArray()) {
	//            charList.add(ch);
	//        }
	//        
	//        // Use an Iterator to traverse the list
	//        Iterator<Character> iterator = charList.iterator();
	//        while (iterator.hasNext()) {
	//            char ch1 = iterator.next();
	//            if (vowels.indexOf(ch1) != -1) {
	//                count++;
	//            }
	//        }
	//	for(char ch:charList)
	//	{
	//		
	//	}
	//        
	//        return count;
	//    }



}

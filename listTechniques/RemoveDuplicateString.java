package listTechniques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicateString {

	public static String[] removeDuplicates(List<String> fruit) {
		//When you pass arraylist as argument to the Linked Hashset, it will return array without duplicate
        LinkedHashSet<String> set = new LinkedHashSet<>(fruit);
        return set.toArray(new String[0]);
        //new String[0] will create array if length 0 i.e empty array, array will store the list and return
        
    }

    // Main method to test the removeDuplicates method
    public static void main(String[] args) {
        String[] testArray = {
            "apple", "banana", "apple", "orange", "banana", "kiwi"
        };
        
        List<String> testArrays = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi"));

        // Remove duplicates
        String[] uniqueArray = removeDuplicates(testArrays);

        // Print the result
        System.out.println("Array after removing duplicates:");
        System.out.println(Arrays.toString(uniqueArray));
    }
}

//Can use below method alternatively.
/*
 * public static String[] removeDuplicates(String[] arr) {
        ArrayList<String> uniqueList = new ArrayList<>();

        for (String str : arr) {
            if (!uniqueList.contains(str)) {
                uniqueList.add(str);
            }
        }

        return uniqueList.toArray(new String[0]);
    }
 * */


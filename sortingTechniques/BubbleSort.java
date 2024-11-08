package sortingTechniques;

public class BubbleSort {

	/*
	 * Complexity is O(n2) -> More then one pass for sorting the given numbers
	 * Steps: Compare index 0 and 1, if left index is greater then right then Swap
	 * Repeat the steps from 0 to n
	 * Continue the steps for 0 to n-i utill iteration is completed.
	 * During Each iteration, greatest number will be moved last
	 * Optimization: as soon as you see the there is no swap happened then consider that array is sorted
	 * Break out using flag
	 */

	public static void main(String[] args) {
		int[] numbers = {2, 10, 8, 1, 9, 5, 6, 3, 8, 4, 7};

		System.out.println("The Arrays before sorting");
		for (int number : numbers) {
			System.out.println(number + " ");
		}

		BubbleSorting(numbers);
		
		System.out.println("The Arrays after sorting");
		for (int number : numbers) {
			System.out.println(number + " ");
		}

	}

	public static void BubbleSorting(int[] numbers) {

		int n = numbers.length;
		//Outer Forloop for traversing all the elements in the Array
		for(int i=0;i< n-1;i++)
		{
			boolean swapped = false;
			//During each pass, based on i value, last element to be sorted so n-i-1
			//Example when i=2 then 10-2-1= 7 so 8th element would be in sorted form
			for(int j=0;j< n-i-1;j++)
			{
				if(numbers[j]>numbers[j+1])
				{
					int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
					swapped = true;
				}
			}
			// If no elements were swapped in this pass, break out
			if (!swapped) {
				break;
			}

		}

	}

}

package sortingTechniques;

import java.util.Arrays;
import java.util.Random;

public class QuickSortAlgorithm {

	/*
	 * Quick sort is highly efficient algorithm
	 * It is called and Divide and Conquer rule
	 * Complexity is 0(nlogn)
	 * It select the Pivot element commonly last, first or middle
	 * Based on Pivot, it will divide array into left with small and right array with large
	 * Applies Recursive mechanism on sub arrays
	 */
	/*
	 * Worst case: O(n2)
	 * If the pivot divides the array poorly (e.g., always the smallest or largest element in a sorted or reverse-sorted array), Quick Sort can degrade to 0(n2)
	 * This happens because, in such cases, the array is divided into a very unbalanced split
	 * One part with 0 elements and other with n-1 element leading to n levels of recursion
	 */

	public static void main(String[] args) {

		int[] numbers = {2, 10, 8, 1, 9, 5, 6, 3, 8, 4, 7};

		System.out.println("The Arrays before sorting");
		System.out.println(Arrays.toString(numbers));

        quickSort(numbers,0,numbers.length-1);
        System.out.println("The Arrays before sorting");
		System.out.println(Arrays.toString(numbers));

	}

	private static void quickSort(int[] numbers, int low, int high) {
		
		if(low<high)
		{
			//partition the array and get the pivot index
			int pivotIndex = partition(numbers,low,high);
			
			// Recursively apply quicksort to the left and right partitions
            quickSort(numbers, low, pivotIndex - 1);
            quickSort(numbers, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] numbers, int low, int high) {
		//Randomly select the Pivot to handle efficiently in case of sorted array
		Random random = new Random();
		int pivotIndex = low+random.nextInt(high-low+1);//It will choose the number b/w 0 to 8
		//Swap with last element
		swap(numbers,pivotIndex,high);//it will call swap method with array, random number generated and last element
		int pivot = numbers[high];//Now the last element is the Pivot element as swapped based on swap method
        int i = low - 1; // i is set as -1 as we need to place element from 0th position.
        for (int j = low; j < high; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
     // Place the pivot element in the correct position
        swap(numbers, i + 1, high);
        //Now the numbers will have sorted array partially based on Pivot element comparison, i+1 is index of pivot and high has pivot element
        //Now after swap is called, pivot shall be moved to the new index
        return i + 1;//Return the current i's value to get the pivot index.
	}

	private static void swap(int[] numbers, int i, int j) {
		
		//This will swap elements. initially last element with Pivot element. Example: 9 and 7 are swapped as numbers[4] is pivot
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}

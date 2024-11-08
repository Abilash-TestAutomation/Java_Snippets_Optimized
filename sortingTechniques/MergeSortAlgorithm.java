package sortingTechniques;

import java.util.Arrays;

public class MergeSortAlgorithm {

	private static void mergeSort(int[]transactions,int left,int right)
	{
		//Finding Mid point
		if(left<right)
		{
			int mid = left + (right-left)/2; // mid is calsulated as 3
			//Diving into 2 subarrays using mid element and sort
			/*
			 * This splits the array into two halves:

              Left half: mergeSort(array, 0, 3);
              Right half: mergeSort(array, 4, 7);
			 */
			mergeSort(transactions,left,mid); 
			//This call will be further split into 2 using mid until base is reached, this will be executing	
			mergeSort(transactions,mid+1,right);
			//Initialized in memory, will be called once left portion is divided, sorted and merged
			
			merge(transactions,left,mid,right);
			/*
			 * Iteration 1: Merge Step for merge(array, 0, 0, 1)/Left of Left
			 * Iteration 2: Merge Step for merge(array, 2, 2, 3)/Right of Left
			 * Iteration 3: Merge Step for merge(array, 0, 1, 3)/Finally Left
			 * After the Left Recursion is done
			 * Same way Right also shall be divided and conquered 
			 */
		}
		
	}
	
	public static void merge(int[] array, int left, int mid, int right) {
        // Sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Initial indexes of the left, right, and merged subarrays
        int i = 0, j = 0;
        int k = left;

        // Merge the arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

	public static void main(String[] args) {
		int[] transactions = {525,600,345,600,799,101,200,44};
		System.out.println("Original Transactions Order" +Arrays.toString(transactions));
		mergeSort(transactions,0,transactions.length-1);
		System.out.println("-------------");
		System.out.println("Sorted Transactions Order" +Arrays.toString(transactions));
	}

}

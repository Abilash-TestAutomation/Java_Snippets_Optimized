package sortingTechniques;

import java.util.Arrays;

public class InsertionSortAlgorithm {

    // Real-world example: Sorting grades of students in ascending order
	/*
	 * Start with key = 75 (at index 1).
       Compare 75 with 88 (index 0): 75 < 88, so move 88 to index 1.
       Place 75 at index 0.
       Array now: [75, 88, 92, 85, 70].
     * Next, key = 92 (at index 2).
       Compare 92 with 88 (index 1): 92 > 88, no shifting needed.
       92 stays in its position.
       Array remains: [75, 88, 92, 85, 70].

	 */
    public static void main(String[] args) {
        int[] studentGrades = {88, 75, 92, 85, 70};
        System.out.println("Before Sorting: " + Arrays.toString(studentGrades));
        
        insertionSort(studentGrades);
        
        System.out.println("After Sorting: " + Arrays.toString(studentGrades));
    }

    // Insertion Sort Implementation
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key; // Place the key in its correct position
        }
    }
}

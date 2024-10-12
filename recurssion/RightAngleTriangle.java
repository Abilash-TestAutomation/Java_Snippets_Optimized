package recurssion;

public class RightAngleTriangle {

	public static void main(String args[])
	{
		//Declaring No. of rows
		int n = 5;
		//printTriangle(1,n);
		
		/**
		 * Alternative approach where no involvement of methods calls recursively
		 * Iterative approach considering performance and space complexity in mind
		 * Both are o(n^2) for Time complexity but for space, iterative is O(1) and Recursive is O(n)
		 * Recursive is best only when you want the code to be readable and maintainable with input value is less
		 */
		for (int i = 1; i <= n; i++) {
		    for (int j = 1; j <= i; j++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}

	}

	static void printTriangle(int currentRow, int totalRows) {
		
		/**
		 * 
		 * Base case defining when the recursion should  stop gracefully
		 * This is crucial and typical to avoid stack overflow
		 */
		if(currentRow>totalRows)
		{
			return;
		}
		//To print number of stars till become 0
		printStars(currentRow);
		//Cursor blinks in the next row
		System.out.println();
		//Recursive call to move to next rows
		printTriangle(currentRow + 1, totalRows);
	}

	static void printStars(int stars) {
		
		if(stars==0)
		{
			return; // Return to previous method and execute the line after where it called
		}
		//Print start in current row
		System.out.print("*");
		//It will print starts until becomes 0
		printStars(stars-1);
	}
}

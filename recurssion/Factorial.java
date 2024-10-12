package recurssion;

public class Factorial {

	public static void main(String args[])
	{
		//Base case.
		int n=5;
		long result = 1;
		//System.out.println("The factorial of" + n + "is:"+factorial(n));
		for (int i = 1; i <= n; i++) {
            result *= i;  // Multiply result by i
        }
	}

	private static long factorial(int n) {
		
		//Base case
		if(n==0)
		{
			return 1;
		}
		return n * factorial(n-1);
	}
}

/*
 * It internally follows stack mechanism
 * Whenever there is function call, it preserves its state in stack. 5 * factorial(4), 4*factorial(3),...1*factorial(0)
 * When base case is reached, now it needs to unwinds the recursive stack now with return value.
 * Values will be stack out [LIFO] from factorial(1) to factorial(5) until it is empty
 * 
 * Base Case: factorial(0)

Stack Frame Pushed: Contains n = 0.
Action: Returns 1.
Unwinding Begins:

factorial(1) Resumes: Computes 1 * 1 = 1, returns 1.
factorial(2) Resumes: Computes 2 * 1 = 2, returns 2.
factorial(3) Resumes: Computes 3 * 2 = 6, returns 6.
factorial(4) Resumes: Computes 4 * 6 = 24, returns 24.
factorial(5) Resumes: Computes 5 * 24 = 120, returns 120.
 */

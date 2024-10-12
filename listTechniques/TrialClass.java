package listTechniques;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;

import myleetcode.HardBasicCalculator;

public class TrialClass {
	
	/*
	 * (1+(4+5+2)-3)+(6+8)/(5*2)
	 * 4+5+2 = 11
	 * 11 + 1 =12
	 * 12 - 3= 9
	 * -----
	 * 6 + 8 =14
	 * 5*2 = 10
	 * ----
	 * 14/10 = 1.4
	 * ----
	 * 9 + 1.4 = 10.4
	 */
	public static int calculator(String s)
	{
		/*
		 * Lets see how to handle each operator (, ), / , *, +, -
		 */
		// As we are expected to implement using stack, so delacre a stack.
		Stack<Integer> stack = new Stack<>();
		//Whenever need to add the values and store in a variable then declare a stack.
		int startCalculation = 0;
		//get the string length
		int n = s.length();
		

		return 0;
		
	}

	public static void main(String[] args) {
		String expression = "(1+(4+5+2)-3)+(6+8)/(5*2)"; // Input expression
		System.out.println(calculator(expression)); // Output the result
	}
}
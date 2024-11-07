package listTechniques;

import java.util.Stack;

public class CharacterPushOperation {
	
	/*
	 * Return true when stack is empty. false when all traversal is done and stack is not empty 
	 */


	public static void main(String[] args) {

		String test1 = "()";
		String test2 = "[]";
		String test3 = "{}";
		String test4 = "55";

		System.out.println("Test 1: " + isValid(test1));
		System.out.println("Test 1: " + isValid(test4));
	}

	private static boolean isValid(String getString) {

		Stack<Character> stack = new Stack<>();
		for (char ch : getString.toCharArray()) {
			if(ch=='(')
			{
				stack.push(')');
			}
			else
			{
				if(stack.isEmpty()||stack.pop()!=ch)
					return false;
			}
		}
		return stack.isEmpty();
	}

}

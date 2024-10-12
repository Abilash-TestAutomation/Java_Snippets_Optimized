package myleetcode;

import java.util.Stack;

import java.util.Stack;

public class HardBasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // Initialize to '+' to handle the first number.
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // If the character is a digit
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0'); // Build the number
            }

            // If the character is an operator or a parenthesis or the end of the string
            if (ch == '(') {
                // Find the matching closing parenthesis
                int j = i, count = 1;
                while (count > 0) {
                    j++;
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                }
                currentNumber = calculate(s.substring(i + 1, j)); // Recursively calculate the inner expression
                i = j; // Move the index to the position of the closing parenthesis
            }

            // If the character is an operator or the end of the string
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                // Process the previous operation
                if (operation == '+' || operation == '-') {
                    stack.push(operation == '+' ? currentNumber : -currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = ch; // Update operation
                currentNumber = 0; // Reset current number
            }
        }

        // Sum up the results in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        HardBasicCalculator calculator = new HardBasicCalculator();
        String expression = "(1 + (4 + 5 + 2) - 3) + (6 + 8) / (5 * 2)"; // Input expression
        System.out.println(calculator.calculate(expression)); // Output the result
    }
}

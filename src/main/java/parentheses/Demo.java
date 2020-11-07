package parentheses;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		String expression;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an expression with parentheses : ");
		expression = scanner.nextLine();

		if (isValid(expression)) {
			System.out.println("Valid Expression...!!!");
		} else {
			System.out.println("Invalid Expression...!!!");
		}
		scanner.close();
	}

	private static boolean isValid(String expression) {
		StackArray stackArray = new StackArray();
		char ch;

		for (int i = 0; i < expression.length(); i++) {
			// Validation left expressions and Pushing it to stack.
			if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
				stackArray.push(expression.charAt(i));
			}
			// Validation right expressions
			if (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {
				if (stackArray.isEmpty()) {
					System.out.println("Right parentheses is more that left parentheses");
					return false;
				} else {
					ch = stackArray.pop();
					if (!matchparentheses(ch, expression.charAt(i))) {
						System.out.print("Mismatched parentheses are :");
						System.out.println(ch + " and " + expression.charAt(i));
						return false;
					}
				}
			}

		}

		if (stackArray.isEmpty()) {
			System.out.println("Balanced Parentheses");
			return true;
		} else {
			System.out.println("Left parentheses are more than right parentheses");
			return false;
		}
	}

	private static boolean matchparentheses(char leftParentheses, char rightParentheses) {
		if (leftParentheses == '(' && rightParentheses == ')') {
			return true;
		}
		if (leftParentheses == '{' && rightParentheses == '}') {
			return true;
		}
		if (leftParentheses == '[' && rightParentheses == ']') {
			return true;
		}
		return false;
	}

}

package postfix;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		String infix;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an expression with parentheses : ");
		infix = scanner.nextLine();

		String postfix = infixToPostfix(infix);

		System.out.println("Postfix expression is : " + postfix);

		System.out.println("Value of expression is : " + evaluatePostfix(postfix));

		scanner.close();
	}

	private static String infixToPostfix(String infix) {

		String postfix = new String();

		StackChar st = new StackChar(20);

		char next, symbol;

		for (int i = 0; i < infix.length(); i++) {
			symbol = infix.charAt(i);

			/* Ignore blank space and tab */
			if (symbol == ' ' || symbol == '\t') {
				continue;
			}

			switch (symbol) {
			case '(':
				st.push(symbol);
				break;
			case ')':
				while ((next = st.pop()) != '(')
					postfix = postfix + next;
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while (!st.isEmpty() && precedence(st.peek()) >= precedence(symbol)) {
					postfix = postfix + st.pop();
				}
				st.push(symbol);
				break;
			default: /* If symbol is an operand */
				postfix = postfix + symbol;
			}
		}

		while (!st.isEmpty()) {
			postfix = postfix + st.pop();
		}

		return null;
	}

	private static int precedence(char symbol) {
		switch (symbol) {
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 3;
		case '^':
			return 3;
		default:
			return 0;
		}
	}

	private static int evaluatePostfix(String postfix) {
		StackInt stackInt = new StackInt(20);

		int x, y;
		for (int i = 0; i < postfix.length(); i++) {
			if (Character.isDigit(postfix.charAt(i))) {
				stackInt.push(Character.getNumericValue(postfix.charAt(i)));
			} else {
				x = stackInt.pop();
				y = stackInt.pop();

				switch (postfix.charAt(i)) {
				case '+':
					stackInt.push(y + x);
					break;
				case '-':
					stackInt.push(y - x);
					break;
				case '*':
					stackInt.push(y * x);
					break;
				case '/':
					stackInt.push(y / x);
					break;
				case '%':
					stackInt.push(y % x);
					break;
				case '^':
					stackInt.push(power(y, x));
					break;
				}
			}
		}

		return stackInt.pop();
	}

	private static int power(int y, int x) {
		return (int) Math.pow(y, x);
	}

}

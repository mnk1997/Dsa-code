package in.cdac.stack;

import java.util.Stack;

public class CheckTwoBracketExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ans > " + solve("-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)"));
		// System.out.println("ans > "+ solve("-(-a+b)-d+c-q","a-b-d+c+q"));
		// solve("-a-b-c");

	}

	public static int solve(String A, String B) {
		String value1 = new String(modifyString(A));
		System.out.println("value 1 " + value1 + "   length " + value1.length());

		String value2 = new String(modifyString(B));
		System.out.println("value 2 " + value2 + "  length  " + value2.length());
		if (value1.contentEquals(value2))

		{
			System.out.println("equals");
			return 1;
		} else {
			return 0;
		}
	}

	public static String modifyString(String expr) {

		StringBuffer ans = new StringBuffer(" ");
		StringBuffer res = new StringBuffer(" ");
		// char top= '+';
		Stack<Character> operator = new Stack<>();
		Stack<String> operand = new Stack<>();
		operator.push('$');
		// Stack<Integer> operand = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			res = new StringBuffer(" ");

			switch (expr.charAt(i)) {
			case '+':

				operator.push('+');
				break;
			case '-':

				operator.push('-');
				break;
			/*
			 * case '*': if(!operator.isEmpty() && getPriority(operator.peek())<=1) {
			 * while(!operator.isEmpty() && getPriority(operator.peek())<=2) { int
			 * val2=operand.pop(); int val1=operand.pop();
			 * operand.push(getOperationResult(val1, val2,operator.pop()));
			 * 
			 * }
			 * 
			 * } operator.push('*'); break; case '/': if(!operator.isEmpty() &&
			 * getPriority(operator.peek())<=1) { while(!operator.isEmpty() &&
			 * getPriority(operator.peek())<=1) { int val2=operand.pop(); int
			 * val1=operand.pop(); operand.push(getOperationResult(val1,
			 * val2,operator.pop()));
			 * 
			 * }
			 * 
			 * } operator.push('/'); break;
			 */
			case '(':

				operator.push('(');
				break;
			case ')':
				while (operator.peek() != '$' && operator.peek() != '(') {

					char c = operator.pop();
					res.insert(0, c);
				}
				operator.pop();
				if (operator.peek() == '-') {
					//res.trimToSize();
					//StringBuffer tempRes = new StringBuffer(" ");
					for (int it = 0; it < res.length(); it++) {
						if (res.charAt(it) == '-')
							res.replace(it, it + 1, "+");

						else if (res.charAt(it) == '+')
							res.replace(it, it + 1, "-");

						operator.push(res.charAt(it));
					}
					operator.pop();
				}
				else 
				{
					res.trimToSize();
					for (int it = 0; it < res.length(); it++) {
                        // System.out.print("->"+res.charAt(it));
						if(res.charAt(it)==' ')
						{
							continue;
						}
						operator.push(res.charAt(it));
					}
				}
				System.out.println();
				
				break;
			default:
				operator.push(expr.charAt(i));
				break;

			}
		}
		int l = expr.length();
		//System.out.println("l value " + l);
		while (!operator.isEmpty() && operator.peek() != '$' && l >= 0) {
			System.out.println("jj " + operator.peek());
			if (ans.charAt(0) == '+' || ans.charAt(0) == '-') {
				if (operator.peek() == '+' || operator.peek() == '-') {
					operator.pop();
				} else {
					ans.insert(0, operator.pop());
				}
			} else {
				ans.insert(0, operator.pop());
			}

			l--;
		}

	    if(ans.charAt(0)=='+')
	    {
	    	//System.out.println("YEeesssssss");
	    	ans.deleteCharAt(0);
	    }

		return ans.toString().trim();
	}

	public static int evaluateExpression(String expr) {
		StringBuffer res = new StringBuffer(" ");
		char top = '+';
		Stack<Character> operator = new Stack<>();
		Stack<Integer> operand = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			switch (expr.charAt(i)) {
			case '+':
				if (!operator.isEmpty() && getPriority(operator.peek()) <= 2) {
					while (getPriority(operator.peek()) <= 2) {
						int val2 = operand.pop();
						int val1 = operand.pop();
						operand.push(getOperationResult(val1, val2, operator.pop()));

					}

				}
				operator.push('+');

				break;
			case '-':
				if (!operator.isEmpty() && getPriority(operator.peek()) <= 2) {
					while (!operator.isEmpty() && getPriority(operator.peek()) <= 2) {
						int val2 = operand.pop();
						if (operand.isEmpty()) {
							operand.push(-val2);
							operator.pop();
						}

						else {
							int val1 = operand.pop();
							operand.push(getOperationResult(val1, val2, operator.pop()));
						}

					}

				}
				operator.push('-');
				break;
			/*
			 * case '*': if(!operator.isEmpty() && getPriority(operator.peek())<=1) {
			 * while(!operator.isEmpty() && getPriority(operator.peek())<=2) { int
			 * val2=operand.pop(); int val1=operand.pop();
			 * operand.push(getOperationResult(val1, val2,operator.pop()));
			 * 
			 * }
			 * 
			 * } operator.push('*'); break; case '/': if(!operator.isEmpty() &&
			 * getPriority(operator.peek())<=1) { while(!operator.isEmpty() &&
			 * getPriority(operator.peek())<=1) { int val2=operand.pop(); int
			 * val1=operand.pop(); operand.push(getOperationResult(val1,
			 * val2,operator.pop()));
			 * 
			 * }
			 * 
			 * } operator.push('/'); break;
			 */
			case '(':
				if (operator.peek() == '-')
					top = '-';
				operator.push('(');
				break;
			case ')':
				while (!operator.isEmpty() && operator.peek() != '(') {
					int val2 = operand.pop();
					int val1 = operand.pop();
					operand.push(getOperationResult(val1, val2, operator.pop()));
				}
				operator.pop();
			default:
				operand.push((int) expr.charAt(i));
				break;

			}
		}
		while (!operator.isEmpty()) {
			int val2 = operand.pop();
			int val1 = operand.pop();
			operand.push(getOperationResult(val1, val2, operator.pop()));

		}
		return operand.pop();
	}

	public static int getPriority(char c) {
		if (c == '^')
			return 0;
		else if (c == '/' || c == '*')
			return 1;
		else if (c == '+' || c == '-')
			return 2;
		else if (c == '(')
			return 10;
		else
			return -1;
	}

	public static int getOperationResult(int val1, int val2, char op) {
		if (op == '+') {
			return val1 + val2;
		} else if (op == '-')

		{
			return val1 - val2;
		} else if (op == '*') {
			return val1 * val2;
		} else if (op == '/') {
			return val1 / val2;
		} else {
			System.out.println("Something might wrong as operator is different from ");
			return Integer.MAX_VALUE;
		}
	}

}

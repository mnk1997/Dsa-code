package in.cdac.pract.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]*/
public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(1).stream().forEach(e -> System.out.println(e));

	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		StringBuffer res = new StringBuffer();
		result = findAllThePossibleParenthesis(res, result, 2 * n);

		return result;

	}

	// right means ) and left means (
	public static List<String> findAllThePossibleParenthesis(StringBuffer res, List<String> result,
			int maxLengthOfString) {
		//System.out.println("caleed find All" + maxLengthOfString);
		if (res.length()==maxLengthOfString) {
			//System.out.println("Reached ");
			if(checkWhetherStringIsValid(res))
			   {
				//System.out.println("string found"+res);
				result.add(res.toString());
			   }
			return result;
		}

		res.append("(");

		result = findAllThePossibleParenthesis(res, result, maxLengthOfString);
		res.deleteCharAt(res.length() - 1);

		res.append(")");
		result = findAllThePossibleParenthesis(res, result, maxLengthOfString);
		res.deleteCharAt(res.length() - 1);
		return result;

	}

	public static boolean checkWhetherStringIsValid(StringBuffer res) {
		//char c = res.charAt(res.length() - 1);
		if (res.charAt(0)==')') {
			System.out.println("wrong opening"+res);
			return false;
		} 
		else if(res.charAt(res.length()-1)=='('){
			System.out.println("Wrong closing"+res);
			return false;
		}
		else
		{
			
			Stack<Character> parenthesis=new Stack<>();
			for(int i=0;i<res.length();i++)
			{
				if(res.charAt(i)=='(')
				{
					parenthesis.push(res.charAt(i));
				}
				else
				{
					if(parenthesis.isEmpty())
					{
						System.out.println("REturning false for string "+res);
						return false;
					}
					parenthesis.pop();
				}
				
			}
			
			if(!parenthesis.isEmpty())
			{
				System.out.println("parenthesis not empty");
				return false;
			}
				
			return true;
		}
	}

	public static boolean checkWhetherLeftGoesOrNot(StringBuffer res, int maxLength, int left) {
		if (left < 0) {
			return false;
		}
		System.out.println("CAllled left");
		boolean result = res.length() + 1 == maxLength ? false : true;
		System.out.println("Rsult" + result);
		return result;
	}

	public static boolean checkWhetherRightGoesOrNot(StringBuffer res, int right) {
		System.out.println("called right");
		if (right < 0) {
			return false;
		}
		if (res.length() == 0) {
			System.out.println("returning flase");
			return false;
		} else {
			int rCount = 0, lCount = 0;
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) == '(') {
					lCount++;
				} else {
					rCount++;
				}
			}
			if (lCount <= rCount) {
				System.out.println("Returning false");
				return false;
			}
			System.out.println("Returning true;");
			return true;
		}
	}
}

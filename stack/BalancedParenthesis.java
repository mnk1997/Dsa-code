package in.cdac.stack;

import java.util.Stack;

//Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
public class BalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve("{([]{})}"));

	}
	//0 expr wrong
	public static int solve(String A) {
		Stack<Character> st=new Stack<>();
		for(int i=0;i<A.length();i++)
		{
			if(A.charAt(i)=='{' || A.charAt(i)=='[' || A.charAt(i)=='(')
			{
				st.push(A.charAt(i));
			}
			else
			{
				if(st.isEmpty())
				{
					return 0;
				}
				else
				{
					if(A.charAt(i)==')' && st.peek()=='(')
					{
						st.pop();
					}
					else if(A.charAt(i)=='}' && st.peek()=='{')
					{
						st.pop();
					}
					else if(A.charAt(i)==']' && st.peek()=='[')
					{
						st.pop();
					}
					else
					{
						return 0;
					}
					
				}
			}
		}
		if(st.isEmpty())
			  return 1;
		else
			 return 0;
    }

}

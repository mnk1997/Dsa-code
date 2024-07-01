package in.cdac.stack;

import java.util.Stack;

public class InfixToPostfix {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("a+b*(c^d-e)^(f+g*h)-i"));

	}
	  public static String solve(String A) {
		  StringBuffer res=new StringBuffer(" ");
		  Stack<Character> st=new Stack<>();
		for(int i=0;i<A.length();i++)
		{
			int priority=getPriority(A.charAt(i));
			if(A.charAt(i)==')')
			{
				System.out.println("res llll");
				while(st.peek()!='(')
				{
					System.out.println("st peek "+st.peek());
					res.append(st.pop());
				}
				//System.out.println("res "+res);
				System.out.println("pop   "+st.peek());
				st.pop();
			}
			else if(priority==-1)
			{
				res.append(A.charAt(i));
				continue;
			}
			else if(priority==10)
			{
				st.push('(');
			}
			else if(!st.isEmpty() && priority>=getPriority(st.peek()))
			{
			    
			    while(!st.isEmpty() &&  priority>=getPriority(st.peek()))
			    {
			    	res.append(st.pop());
			    }
			    st.push(A.charAt(i));
			}
			
			else if(!st.isEmpty() && priority<getPriority(st.peek()))
			{
				st.push(A.charAt(i));
				
			}
			else
			{
				st.push(A.charAt(i));
			}
			
			
		}
		  while(!st.isEmpty())
		  {
			
			//  System.out.println("res peek "+st.peek());
			  res.append(st.pop());
		  }
		  
		  
		  return res.toString().trim();
	    }
	 
	  
	  public static int getPriority(char c)
	  {
		  if(c=='^')
			  return 0;
		  else if(c=='/' || c=='*')
			  return 1;
		  else if(c=='+' || c=='-')
			  return 2;
		  else if(c=='(')
			  return 10;
		  else
			  return -1;
	  }
	  

}

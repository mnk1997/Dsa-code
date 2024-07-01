package in.cdac.pract;

import java.util.Stack;

public class ReverseStringWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public static String solve(String A) {
		 Stack<Character> st=new Stack<>();
		 StringBuffer res=new StringBuffer(' ');
		 for(int i=A.length()-1;i>=0;i--)
		 {
			 while(A.charAt(i)!= ' ')
			 {
				 st.push(A.charAt(i));
			 }
			 while(A.charAt(i)==' ')
			 {
				 i--;
			 }
			 while(!st.isEmpty())
			 {
				 res.append(st.pop());
			 }
			 res.append(' ');
		 }
		 
		 return res.toString().trim();
	    }

}

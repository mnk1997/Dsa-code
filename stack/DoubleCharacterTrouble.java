package in.cdac.stack;

import java.util.Stack;

/*A = "abccbc"
Input 2:

A = "ab"*/
public class DoubleCharacterTrouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        System.out.println(solve("abccbc"));
	}
	 public static String solve(String A) {
		 Stack<Character> st=new Stack<>();
		
		 for(int i=0;i<A.length();i++)
		 {
			 if(st.isEmpty())
			 {
				 st.push(A.charAt(i));
			 }
			 else
			 {
				 char ch=st.peek();
				 if(ch==A.charAt(i))
				 {
					 st.pop();
				 }
				 else
				 {
					 st.push(A.charAt(i));
				 }
			 }
			 
		 }
		 
		 char[] ans=new char[st.size()];
		 int ptr=st.size()-1;
		 while(ptr>=0)
		 {
			 ans[ptr]=st.pop();
			 ptr--;
		 }
		 
		 return String.copyValueOf(ans);
	    }

}

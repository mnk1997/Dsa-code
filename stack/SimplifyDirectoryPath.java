package in.cdac.stack;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyDirectoryPath {
	 class Stack
	    {
	        int val;
	        Stack next;
	        Stack(int x)
	        {
	            this.val=x;
	        }
	    }
	    Stack head=null;
	    Stack tail=null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/../"));
		st.

	}
	 public static String simplifyPath(String A) {
	        
	      String[] commands=A.split("/");
	      for(String cmd:commands)
	      {
	    	  cmd.trim();
	    	  System.out.println(cmd +" ");
	    	  }
	    	 
	      
	      StringBuffer res=new StringBuffer("");
	      Stack<String> st=new Stack<>();
	      for(String ele:commands)
	      {
	    	  
	          if(ele.contentEquals("..")  && !st.isEmpty())
	          {
	        	  System.out.println("Pop");
	              System.out.println( st.pop());
	          } 
	          else if(ele.contentEquals(".") || ele.contentEquals(".."))
	          {
	              continue;
	          }
	          else{
	            System.out.println(" push "+ st.push(ele));
	          }
	      }
	      Stack<String> aux=new Stack<>();
	      while(!st.isEmpty())
	      {
	          aux.push(st.pop());
	      }
	      while(!aux.isEmpty())
	      {
	          res.append("/"+aux.pop());
	      }
	      if(res.length()==0)
	    	  res.append("/");
	      return res.toString().replace("//", "/");
	      
	    }

}

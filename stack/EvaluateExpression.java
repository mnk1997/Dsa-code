package in.cdac.stack;

import java.util.ArrayList;
import java.util.Stack;

/*An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.*/
public class EvaluateExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<>();
		
		list.add("2");
		list.add("5");
		list.add("*");
		list.add("11");
		list.add("-");
		System.out.println(evalRPN(list));

	}
	
	 public static int evalRPN(ArrayList<String> A) {
		 int ans=0;
		 Stack<String> operands=new Stack<>();
		 for(String value:A)
		 {
			 if(value.equals("+") || value.equals("-")|| value.equals("*")||value.equals("/"))
			 {
				 if(operands.size()<2)
				 {
					 return -1;
				 }
				 else
				 {
					 int x=Integer.valueOf(operands.pop());
					 int y=Integer.valueOf(operands.pop());
					 switch(value)
					 {
					 case "+":
						 operands.push(String.valueOf(x+y));
						 break;
					 case "-":
						 operands.push(String.valueOf(y-x));
						 break;
					 case "*":
						 operands.push(String.valueOf(y*x));
						 break;
					 case "/":
						  operands.push(String.valueOf(y/x));
						  break;
					 }
					 
				 }
			 }
			 else
			 {
				 operands.push(value);
			 }
		 }
		 
		 if(operands.size()==1)
		 {
			 ans=Integer.valueOf(operands.pop());
			 return ans;
		 }
		 else
		 {
			 //invalid expression 
			 return -1;
		 }
	    }

}

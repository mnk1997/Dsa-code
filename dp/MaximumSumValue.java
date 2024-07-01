package in.cdac.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumSumValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(11,-32,34,11,-5,-3,-28,18,31,29));
		int B=-28;
		int C=-15;
		int D=0;
		System.out.println("Answer "+  solve(A,B,C,D));

	}
	
	  public static int solve(ArrayList<Integer> A, int B, int C, int D) {

	       // Collections.sort(A);
		  int[] maxLeft =new int[A.size()];
		  maxLeft[0]=A.get(0)*B;
		  for(int i=1;i<A.size();i++)
		  {
			  maxLeft[i]=Math.max(maxLeft[i-1], A.get(i)*B);
		  }
		  
		  int[] maxMiddle=new int[A.size()];
		  maxMiddle[0]=maxLeft[0];
		  for(int i=1;i<A.size();i++)
		  {
			  maxMiddle[i]=Math.max(maxMiddle[i-1]+C*A.get(i-1),maxMiddle[i-1]+C*A.get(i));
		  }
		  
		  int[] maxRight=new int[A.size()];
		  maxRight[0]= maxMiddle[0];
		  for(int i=1;i<A.size();i++)
		  {
			  maxRight[i]=Math.max(maxRight[i-1]+D*A.get(i-1),maxRight[i-1]+D*A.get(i));
		  }
	       
	        return maxRight[A.size()-1];
	    }
	//this doesn't take care of i<=j
		/*
		 * public static int solve(ArrayList<Integer> A, int B, int C, int D) {
		 * 
		 * // Collections.sort(A); ArrayList<Integer> values=new ArrayList<>();
		 * values.add(B); values.add(C); values.add(D); Collections.sort(values); int
		 * ans=0; for(int i=0;i<values.size();i++) { int tempAns=Integer.MIN_VALUE;
		 * for(int j=0;j<A.size();j++) { tempAns=Math.max(tempAns,
		 * A.get(j)*values.get(i)); } System.out.println("for vlaues "+values.get(i)
		 * +"  max possble vlaue is "+tempAns); ans+=tempAns; } return ans; }
		 */

}

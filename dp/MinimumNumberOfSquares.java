package in.cdac.dp;

import java.util.ArrayList;

/*Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
Minimum count of numbers, sum of whose squares is 6 is 3. */

/*Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.*/
public class MinimumNumberOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ans : "+countMinSquares(122));

	}
	
	 public static int countMinSquares(int A) {
		// int ans=0;
		 if(A<=1)
		 {
			 return A;
		 }
		 ArrayList<Integer> values=new ArrayList<>(A+1);
		 for(int i=0;i<=A;i++)
		 {
			 values.add(0);
		 }
		 return findNumber(A,values);
		 
		 
		 
		 
		// return ans;
	    }
	   public static int findNumber(int N,ArrayList<Integer> list)
	   {
		   if(N<=1)
			   return N;
		   if(list.get(N)>0)
			   return list.get(N);
		   int ans=Integer.MAX_VALUE;
		   for(int i=1;i*i<=N;i++)
		   {
			   ans=Math.min(ans,findNumber(N-(i*i), list)+1);
		   }
		   list.set(N, ans);
		   
		   return ans;
		   
	   }

}

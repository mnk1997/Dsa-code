package in.cdac.dp;

import java.util.ArrayList;

/*Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.*/
/*A = [3, 4, 1, 6, 2]
Input 2:

A = [1, 5, 2, 5, 6]*/


/*Example Output
Output 1:

15
Output 2:

11*/
public class CuttingRod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int solve(ArrayList<Integer> A) {
		 int[] dp=new int[A.size()+1];
		 //it denoted the maximum price we can earn by selling i length of rod
		 dp[0]=0;
		 for(int i=1;i<=A.size();i++)
		 {
			 dp[i]=A.get(i-1);
			 for(int j=1;j<=i;j++)
			 {
				 dp[i]=Math.max(dp[i], dp[i-j]+dp[j]);
			 }
		 }
		 
		 return dp[A.size()];
		 
	    }

}

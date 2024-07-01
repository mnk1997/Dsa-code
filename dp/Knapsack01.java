package in.cdac.dp;

import java.util.ArrayList;
/*Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property)*/

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] dp=new int[A.size()+1][C+1];
        for(int i=0;i<=A.size();i++)
        {
        	for(int wt=0;wt<=C;wt++)
        	{
        		if(i==0 || wt==0)
        		{
        			continue;
        		}
        		else if(B.get(i-1)>wt)
        		{
        			dp[i][wt]=dp[i-1][wt];
        		}
        		else
        		{
        			dp[i][wt]=Math.max(dp[i-1][wt],A.get(i-1)+dp[i-1][wt-B.get(i-1)]);
        		}
        	}
        }
        return dp[A.size()][C];
    }

}

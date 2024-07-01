package in.cdac.dp;

import java.util.ArrayList;

/*
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], 
we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, 
here we are allowed to use unlimited number of instances of an item.*/


/*Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output
Output 1:

 5
Output 2:

14*/
public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int[] dp=new int[A+1];
		dp[0]=0;
		for(int wt=1;wt<=A;wt++)
		{
			for(int idx=0;idx<B.size();idx++)
			{
				if(C.get(idx)>wt)
					continue;
				else 
				{
					dp[wt]=Math.max(dp[wt],B.get(idx)+dp[wt-C.get(idx)]);
				}
			}
		}
		for(int i=dp.length-1;i>=0;i--)
		{
			if(dp[i]>0)
				return dp[i];
		}
		return 0;
		
    }

}

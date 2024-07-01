package in.cdac.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack01Modified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(solve(new ArrayList<>(Arrays.asList(9,3,5,6,6,2,8,2,2,6,3,8,7,2,5,3,4,3,3)),new ArrayList<>(Arrays.asList(22,17,19,46,48,27,22,39,20,13,18,50,36,45,4,12,23,34,24)),513));
		System.out.println(solve(new ArrayList<>(Arrays.asList(6,10,12)),new ArrayList<>(Arrays.asList(10,20,30)),50));

	}
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		//int max=0;
		//as 50 is the max profit and max profit will be all the elements have the same max profit and we select every one of them.
		int maxProfit=A.size()*50;
		
		int maxWt=0;
		for(int ele:B)
		{
			if(ele>maxWt)
			{
				maxWt=ele;
			}
			
		}
		System.out.println("max "+maxProfit);
		int[][] dp=new int[A.size()+1][maxProfit+1];
		
		//initalize
		for(int row=0;row<=A.size();row++)
		{
			for(int col=0;col<=maxProfit;col++)
			{
				dp[row][col]=Integer.MAX_VALUE;
			}
		}
		
		
		
		
		for(int idx=1;idx<=A.size();idx++)
		{
			//currSum+=A.get(idx-1);
			for(int value=1;value<=maxProfit;value++)
			{
				if(value==A.get(idx-1))
				{
					dp[idx][value]=Math.min(dp[idx-1][value], B.get(idx-1));
				}
			else if(value>A.get(idx-1) && dp[idx-1][value-A.get(idx-1)]!=Integer.MAX_VALUE)
				{
					dp[idx][value]=Math.min(B.get(idx-1)+dp[idx-1][value-A.get(idx-1)] //accept 
							,dp[idx-1][value]//reject
									);
				}
				else
				{
					System.out.print("only else ");
					dp[idx][value]=dp[idx-1][value];
				}
				
			}
		}
		System.out.println("Check for dp ");
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[i].length;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		int ans=0;
		for(int i=maxProfit;i>=0;i--)
		{
			if(dp[A.size()][i]<=C)
			{
				System.out.println("kohi na kucho boli");
				return i;
			}
		}
		System.out.println("Maar deb goli");
		return ans;
    }

}

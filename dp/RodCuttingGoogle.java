package in.cdac.dp;
/*There is a rod of length N lying on the x-axis with its left end at x = 0 and right end at x = N. Now,
there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, ..., AM. 
You have to cut the rod at all these weak points. You can perform these cuts in any order. 
After a cut, the rod gets divided into two smaller sub-rods. The cost of making a 
cut is the length of the sub-rod in which you are making a cut.

Your aim is to minimize this cost. 
Return an array denoting the sequence in which you will make cuts.
If two different sequences of cuts give the same cost, return the lexicographically smallest.*/

import java.util.ArrayList;
import java.util.Arrays;

/*N = 6
A = [1, 2, 5]


If we make cuts in order [1, 2, 5], let us see what total cost would be.
For first cut, the length of rod is 6.
For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
So, total cost is 6 + 5 + 4.*/

public class RodCuttingGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rodCut(6,new ArrayList<>(Arrays.asList(1, 2, 5)));

	}
	public static void rodCut(int A, ArrayList<Integer> B) {
	      int[][] dp=new int[B.size()+1][A+1];
	      for(int i=0;i<dp.length;i++)
	      {
	    	  for(int j=0;j<dp[i].length;j++)
	    	  {
	    		  
	    		  if(i==0)
	    		  {
	    			  dp[i][j]=0;
	    		  }
	    		  else if(j==0)
	    		  {
	    			  dp[i][j]=0;
	    		  }
	    		  else
	    		  {
	    			  dp[i][j]=0;
	    		  }
	    		 
	    		 
	    	  }
	      }
	      
	      for(int i=1;i<dp.length;i++)
	      {
	    	  for(int length=1;length<=A;length++)
	    	  {
	    		 
	    		  if(B.get(i-1)<length)
	    		  {
	    			/*  if(dp[i][length-B.get(i-1)]==Integer.MAX_VALUE)
	    				  dp[i][length]=Math.min(dp[i-1][length],length);*/
	    			 
	    				  dp[i][length]=length +Math.max(dp[i-1][(length-B.get(i-1))],dp[i-1][length]);
	    			  
	    			  
	    		  }
	    		 
	    		  else 
	    		  {
	    			  dp[i][length]=0;
	    		  }
	    	  }
	    	  //System.out.println("checkc for dp");
	    	  System.out.println();
	    	  for(int col=0;col<=A;col++)
	    	  {
	    		  System.out.print(dp[i][col]+" ");
	    	  }
	    	  
	      }
	      
	      System.out.println(" Minimum cost to cut the rod is "+dp[B.size()][A]);
    }
	
	public class Solution {
	    ArrayList<Integer> result;
	    int[] cuts;
	    int[][] parent;
	    public ArrayList<Integer> rodCut(int rod, ArrayList<Integer> scores) {
	        int n = scores.size() + 2;
	        cuts = new int[n];
	        cuts[0] = 0;
	        for (int i = 0; i < scores.size(); i++) {
	            cuts[i + 1] = scores.get(i);
	        }
	        cuts[n - 1] = rod;
	        
	        long[][] dp = new long[n][n];
	        parent = new int[n][n];
	        for (int len = 1; len <= n; len++) {
	            for (int s = 0; s < n - len; s++) {
	                int e = s + len;
	                for (int k = s + 1; k < e; k++) {
	                    long sum = cuts[e] - cuts[s] + dp[s][k] + dp[k][e];
	                    if (dp[s][e] == 0 || sum < dp[s][e]) {
	                        dp[s][e] = sum;
	                        parent[s][e] = k;
	                    }                    
	                }
	            }
	        }
	        
	        result = new ArrayList<>();
	        backTrack(0, n - 1);
	        
	        return result;
	    }
	    
	    private void backTrack(int s, int e) {
	        if (s + 1 >= e) {
	            return;
	        }        
	        
	        result.add(cuts[parent[s][e]]);
	        backTrack(s, parent[s][e]);
	        backTrack(parent[s][e], e);
	    }
	}

}

package in.cdac.dp;


/*The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.
*/public class DungeonPrincess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public int calculateMinimumHP(int[][] A) {
		  int rows=A.length;
		  int col=A[0].length;
		  int[][] dp=new int[rows][col];
		  int[][] total=new int[rows][col];
		  dp[0][0]=Math.max(1,1-A[0][0]);
		  total[0][0]=Math.max(1, A[0][0]);
		  for(int i=0;i<rows;i++)
		  {
			  for(int j=0;j<col;j++)
			  {
				  if(i==0)
				  {
					  if(j==0)
						  continue;
					  else
					  {
						  int currHealth=total[i][j-1]+A[i][j];
						  dp[i][j]=Math.max(dp[i][j-1],dp[i][j-1]+ 1-currHealth);
						  if(currHealth<=0)
							  total[i][j]=1;
						  else
							  total[i][j]=dp[i][j]+A[i][j];
					  }
				  }
				  else if(j==0)
				  {
					  if(i==0)
						  continue;
					  else
					  {
						 
						  int currHealth=total[i-1][j]+A[i][j];
						  dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j]+ 1-currHealth);
						  if(currHealth<=0)
							  total[i][j]=1;
						  else
							  total[i][j]=dp[i][j]+A[i][j];
					  }
				  }
				  else
				  {
					 // dp[i][j]=Math.min(Math.max(dp[i][j-1], dp[i][j-1]-A[i][j]), Math.max(dp[i-1][j],dp[i-1][j]-A[i][j]+1));
					  
					  if(dp[i-1][j]<dp[i][j-1])
					  {
						  int currHealth=total[i-1][j]+A[i][j];
						  dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j]+ 1-currHealth);
						  if(currHealth<=0)
							  total[i][j]=1;
						  else
							  total[i][j]+=dp[i][j]+A[i][j];
					  }
					  else
					  {
						  int currHealth=total[i][j-1]+A[i][j];
						  dp[i][j]=Math.max(dp[i][j-1],dp[i][j-1]+ 1-currHealth);
						  if(currHealth<=0)
							  total[i][j]=1;
						  else
							  total[i][j]=dp[i][j]+A[i][j];
					  }
				  }
			  }
		  }
		  
		  return dp[rows-1][col-1];
	    }

}

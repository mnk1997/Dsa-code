package in.cdac.dp;

public class UniquePathsInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int uniquePathsWithObstacles(int[][] A) {
		if(A[0][0]==1)
			return 0;
		int rows=A.length;
		int col=A[0].length;
		int[][] dp=new int[rows][col];
		dp[0][0]=A[0][0]==1?Integer.MAX_VALUE:1;
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==0  && j==0)
					continue;
				else if(j==0)
				{
					
					dp[i][j]=((A[i][j]!=1)?dp[i-1][j]:Integer.MAX_VALUE);
				}
				else if(i==0)
				{
					dp[i][j]=(A[i][j]!=1)?dp[i][j-1]:Integer.MAX_VALUE;
				}
				else
				{
					if(A[i][j]==1)
						dp[i][j]=Integer.MAX_VALUE;
					else
					{
						if(dp[i-1][j]!=Integer.MAX_VALUE && dp[i][j-1]!=Integer.MAX_VALUE)
						{
							dp[i][j]=dp[i-1][j]+dp[i][j-1];
						}
						else
						{
							dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1]);
						}
					}
				}
			}
		}
		
		
		
		
		if(dp[rows-1][col-1]==Integer.MAX_VALUE)
			return 0;
		return dp[rows-1][col-1];
    }

}

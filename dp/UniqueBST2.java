package in.cdac.dp;

/*Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?
*/public class UniqueBST2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(1));

	}
	  public static int numTrees(int A) {
		  if(A<=3)
		  {
			  if(A==0)
				  return 1;
			  else if(A==1)
				   return 1;
			  else if(A==2)
				   return 2;
			  else  if(A==3)
				   return 5;
		  }
		 // int ans=0;
		  int[] dp=new int[A+1];
		  dp[0]=1;
		  dp[1]=1;
		  dp[2]=2;
		  dp[3]=5;
		  
		  for(int i=4;i<=A;i++)
		  {
			  for(int j=1;j<=i;j++)
			  {
				  int leftTree=j-1;
				  int rightSubTree=i-j;
				  dp[i]+=dp[leftTree]*dp[rightSubTree];
			  }
		  }
		  
		  
		  return dp[A];
	    }

}

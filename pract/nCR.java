package in.cdac.pract;

public class nCR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("oooppp"+solve(1000000,1,999999));
		System.out.println("oooppp"+solve(5,2,13));
	}
	
	 public static int solve(int A, int B, int C) {
	       long[][] dp=new long[A+1][B+1];
	       for(int i=0;i<=A;i++)
	       {
	    	   for(int j=0;j<=Math.min(i, B);j++)
	    	   {
	    		   if(j==0 || j==i)
	    		   {
	    			   dp[i][j]=1;
	    		   }
	    		   else
	    		   {
	    			   if(j==0 || i==0)
	    			   {
	    				   System.out.println("j is negative for i"+i);
	    			   }
	    			   long val=((dp[i-1][j-1])%C+(dp[i-1][j])%C)%C;
	    			   dp[i][j]=val;
	    		   }
	    	   }
	       }
	       
	       for(int i=0;i<=A;i++)
	       {
	    	   for(int j=0;j<=B;j++)
	    	   {
	    		   System.out.print(dp[i][j]+ " ");
	    	   }
	    	   System.out.println();
	       }
	       return (int) dp[A][B]%C;

	    }

}

package in.cdac.dp;


/*You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).*/
import java.util.ArrayList;
import java.util.Arrays;

public class CoinSumInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//correct ans:867621
     System.out.println(coinchange2UnOrdered(new ArrayList<>(Arrays.asList(18,24,23,10,16,19,2,9,5,12,17,3,28,29,4,13,15,8)),458));
	}
	//this is for ordered collection
	 public static int coinchange2Ordered(ArrayList<Integer> A, int B) {
		// long ans=0;
		 long[] dp=new long[B+1];
		 dp[0]=0;
		 
		 //above loop will be for sum and inner loop will iterate through number of items in a
		 //the below mentioned code will solve for order matters
		 for(int sum=1;sum<=B;sum++)
		 {
			  for(int ele:A)
			  {
				  if(ele>B || ele >sum)
					  continue;
				  else if (ele<sum)
				  {
					  dp[sum]+=dp[sum-ele];
				  }
				  else if(ele==sum)
				  {
					  dp[sum]+=1;
				  }
			  }
		 }
		 
		 
		 
		 
		 
		 
		 
		 return (int)(dp[B]%1000007);
		 
	    }
	 public static int coinchange2UnOrdered(ArrayList<Integer> A, int B) {
			// long ans=0;
			 long[] dp=new long[B+1];
			 int start=0;
			 dp[0]=0;
			 
			 //above loop will be for sum and inner loop will iterate through number of items in a
			 //the below mentioned code will solve for unordered
			 for(int idx=0;idx<A.size();idx++)
			  {
			 for(int sum=1;sum<=B;sum++)
			 {
				 
				  
					  if(A.get(idx)>B || A.get(idx) >sum)
						  continue;
					  else if (A.get(idx)<sum)
					  {
						  dp[sum]=(dp[sum]+dp[sum-A.get(idx)])%1000007;
					  }
					  else if(A.get(idx)==sum)
					  {
						  dp[sum]=(dp[sum]+1)%1000007;
					  }
				  }
			 
			/* for(int i=0;i<dp.length;i++)
			 {
				 System.out.print(dp[i]+" ");			 }
				 
			 }*/
			 
			 
			 
			 
			 
			 
			 
			 
			 
		    }
			 return (int)(dp[B]%1000006);
	


}
}



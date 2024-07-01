package in.cdac.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class NDigitNumbers {

	static boolean unit=true;
	public static void main(String[] args) {
		int[] inorder = {1,2,4,5,6,8};
		ArrayList<Integer> list=new ArrayList<>();
		
		// TODO Auto-generated method stub
		//System.out.println(solve(75,22));
		//System.out.println(solve(3,19));
          //478432066
		System.out.println(solve(1,75));
		//System.out.println(solve(3,14));
	}
	  public static int solve(int A, int B) {
		  if(B==0 || A==0)
			  return 0;
		  if(A==1)
		  {
			  if(B<=9)
				  return 1;
			  else
				  return 0;
		  }
			  
		  
		  //this technique is used to optimize SC from O(N^2) to O(N)
		  long left=0;
		  long top[][]=new long[A+1][B+1];
		  //initalized with 1 for all the sum value with 1 digit
		  for(int sum=0;sum<=B;sum++)
		  {
			  if(sum==0)
			  {
				  top[0][sum]=0;
				  top[1][sum]=0;
			  }
				 
			  else if(sum<=9)
			  {
				  top[0][sum]=0;
				  top[1][sum]=1;
			  }
				  
			  else 
			  {
				  top[0][sum]=0;
				  top[1][sum]=0;
			  }
				  
		  }
		  for(int digit=0;digit<=A;digit++)
		  {
			  if(digit==0)
			  {
				  top[digit][0]=0;
				  top[digit][1]=0;
			  }
				 
			  else if(digit<=9)
			  {
				  top[digit][0]=0;
				  top[digit][1]=1;
			  }
				  
			  else 
			  {
				  top[digit][0]=0;
				  top[digit][1]=0;
			  }
				  
		  }
		  for(int digit=2;digit<=A;digit++)
		  {
			  for(int sum=1;sum<=B;sum++)
			  {
				  if(sum==1)
					  top[digit][sum]=1;
				  
				  else 
				  {
					  long count=0;
					  for(int i=1;i<=sum;i++)
					  {
						  if(sum-i<10)
							  count=(count+top[digit-1][i])%1000000007;
					  }
					  top[digit][sum]=count;
					  
				  }
					/*
					 * else { top[digit][sum]=((top[digit-1][sum]+ left)%1000000007); //
					 * top[sum]+=left; left=top[digit][sum]; }
					 */
				  
				  
				  
				  if(top[digit][sum]<0)
				       System.out.println("top values"+top[digit][sum]);
			  }
		  }
		  return (int) (top[A][B]%1000000007);

}
	//iterative approach
	  public static int solveOne(int A, int B) {
		  if(B==0)
			  return 0;
		  if(A<=1)
			  return A;
		  
		  //this technique is used to optimize SC from O(N^2) to O(N)
		  long left=0;
		  long top[]=new long[B+1];
		  //initalized with 1 for all the sum value with 1 digit
		  for(int sum=0;sum<=B;sum++)
		  {
			  if(sum==0)
				  top[sum]=0;
			  else if(sum<=9)
				  top[sum]=1;
			  else 
				  top[sum]=0;
		  }
		  for(int digit=2;digit<=A;digit++)
		  {
			  for(int sum=1;sum<=B;sum++)
			  {
				  if(sum==1)
					  left=0;
				  
				  else if(sum>=10)
				  {
					  long count=0;
					  for(int i=1;i<=sum;i++)
					  {
						  if(sum-i<10)
							  count+=top[i];
					  }
					  top[sum]=count+left;
					  
				  }
				  else
				  {
					  top[sum]=top[sum]+ left;
						//  top[sum]+=left;
						  left=top[sum];
				  }
				  
				  
				  
				  if(top[sum]<0)
				       System.out.println("top values"+top[sum]);
			  }
		  }
		  return (int) (top[B]%1000000007);

}
	  
	  //backtracking approach
	  public static int solveRecursive(int A, int B) {
		  if(A==0 && B==0)
			  return 1;
		  else if(A>1 && B==0)
			  return 0;
		  else if (A==0 && B>0)
			  return 0;
		  
		  int number=0;
		  for(int i=0;i<=9;i++)
		  {
			  if(unit)
			  {
				  unit=false;
				  continue;
			  }
			  if(B-i<0)
				  break;
			 
			  number+=solve(A-1,B-i);
		  }
		  return number;

}

}

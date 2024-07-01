package in.cdac.twoPointers;

/*Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.*/
public class ClosestPairFromTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[]A= {1, 2, 3, 4, 5}; int[]B= {2, 4, 6, 8}; int C=9;
		 */
		
		/*
		 * int[]A= {5, 10, 20}; int[]B= {1, 2, 30}; int C=13;
		 */
		
		/*
		 * int[]A= {1,3,5,7,9}; int[]B= {2,4,6,8,10}; int C=10;
		 */
		
		int[]A= {1};
		int[]B= {2,4};
		int C=4;
		int[] res=solve(A,B,C);
		//System.out.println(solve(A,B,C));
		for(int ele:res)
		{
			System.out.print(ele+" ");
		}

	}
	public static int[] solve(int[] A, int[] B, int C) {
		int[] ans=new int[2];
		ans[0]=-1;
		ans[1]=-1;
		int currMin=Integer.MAX_VALUE;
		int i=0;
		int j=B.length-1;
		while((i<A.length) && (j>=0))
		{
			System.out.println(" A[i]: "+A[i]+"   B[j] :"+B[j]+"  C "+C +"  currMin: "+currMin);
			if((A[i]+B[j])>C)
			{
				int close=Math.abs((A[i]+B[j])-C);
				if(close < currMin)
				{
					System.out.println("here updating");
					currMin=close;
					ans[0]=i;
					while((i<A.length-1) && A[i]==A[i+1])
					{
						i++;
					}
					while((j>0) && B[j]==B[j-1])
					{
						j--;
					}
					ans[1]=j;
				
					
				}
				else if(close == currMin)
				{
					if(i==ans[0])
					{
						ans[1]=j;
					}
				}
				
				
					j--;
				
			}
			else if((A[i]+B[j]) < C)
			{
				
				int close=Math.abs((A[i]+B[j])-C);
				System.out.println(" with "+A[i]+  "  "+B[j]+" C : "+C+"  close "+close);
				if(close < currMin)
				{
					System.out.println("updating with "+A[i]+  "  "+B[j]);
					currMin=close;
					ans[0]=i;
					while((i<A.length-1) && (A[i]==A[i+1]))
					{
						i++;
					}
					while((j>0) &&( B[j]==B[j-1]))
					{
						j--;
					}
					ans[1]=j;
					
				}
				else if(close == currMin)
				{
					if(i==ans[0])
					{
						ans[1]=j;
					}
				}
			
				
					i++;
				
			}
			else
			{
				System.out.println("Inside else ");
				//int close=Math.abs(A[i]+A[j]-C);
				
				if(currMin > 0)
				{
					currMin=0;

					System.out.println("updating the value ");
					     
					
					ans[0]=i;
					while((i<A.length-1) && (A[i]==A[i+1]))
					{
						i++;
					}
					while((j>0) && (B[j]==B[j-1]))
					{
						j--;
					}
					ans[1]=j;
				}
				
				j--;
				i++;
				
			}
		}
		
		
		ans[0]=A[ans[0]];
		ans[1]=B[ans[1]];
		
		return ans;
    }

}

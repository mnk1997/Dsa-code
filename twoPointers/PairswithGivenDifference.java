package in.cdac.twoPointers;

import java.util.Arrays;

/*Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.*/
public class PairswithGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A= {8, 12, 16, 4, 0, 2,20};
		//int B=4;
		/*
		 * int[] A= {1,3,1,5,4}; int B=2;
		 */
		
		  int[] A= {1,1,1,2,2};
		  
		  int B=1;
		 
		
			/*
			 * int[] A= {1}; int B=0;
			 */
		/*
		 * int[] A= {1,1,1,1,1}; int B=0;
		 */
		System.out.println(solve(A,B));

	}
	 public static int solve(int[] A, int B) {
		 if((A.length<=1))
		 {
             
                return 0;
            
		 }
         int countEle=0;
		 for(int i=0;i<A.length-1;i++)
		 {
			 if(A[i]==A[i+1])
			 {
				 countEle++;
			 }
		 }
		// System.out.println("count ele"+countEle);
		 if(countEle==A.length-1)
		 {
			 return 1;
		 }
         
        
         	 Arrays.sort(A);
		 
		 int n=A.length;
		 int ans=0;
		 int leftPointer=0;
		 int rightPointer=leftPointer+1;
		 while((leftPointer<n ) && (rightPointer<n)   )
		 {
			// System.out.println("left Pointer "+leftPointer+"   Right Pointer "+rightPointer+"  n"+n);
			 if(A[rightPointer]-A[leftPointer]<B)
			 {
				 rightPointer++;
			 }
			 else if(A[rightPointer]-A[leftPointer]>B)
			 {
				  leftPointer++;
			 }
			 else
			 {
				 if(leftPointer!=rightPointer)
				 {
					 if(A[leftPointer]==A[rightPointer])
					 {
						 while((rightPointer<n) && (A[leftPointer]==A[rightPointer]) )
						 {
							 rightPointer++;
						
						 }	 
						 int count=(rightPointer-1)-leftPointer+1;
						 count=(count*(count-1))/2;
						// ans+=count;
                        ans+=1;
						 leftPointer=rightPointer-1;
						 
						
					
						 
					 }
					 else if(((leftPointer < n-1) && (A[leftPointer]==A[leftPointer+1]))|| ((rightPointer<n-1) && (  A[rightPointer]==A[rightPointer+1])))
					 {
						 int countRight=0;
						 int countLeft=0;
						 while((rightPointer<n-1) && (A[rightPointer+1]==A[rightPointer]) )
						 {
							 countRight++;
							 rightPointer++;
						
						 }	
						 while((leftPointer<n-1) && (A[leftPointer+1]==A[leftPointer]) )
						 {
							 countLeft++;
							 leftPointer++;
						
						 }	
						  ans+=1;
						 leftPointer++;
						 rightPointer++;
						 
					 }
					 
					 else
					 {
						
						 ans++;
						 leftPointer++;
						 rightPointer++;
						 
					 }
					
				 }
				 else
				 {
					 rightPointer++;
				 }
				
			 }
		 }
		 
		 
		 
		 
		 return ans;
	    }

}

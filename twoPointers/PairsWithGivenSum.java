package in.cdac.twoPointers;

import java.util.Arrays;

/*Given a sorted array of integers (not necessarily distinct) A and an integer B, 
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7)*/
public class PairsWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[] A = { 1, 1, 1};
		 * 
		 * int B = 2;
		 */
		/*
		 * int[] A= {1,2,3,3,4,6,7}; int B=13;
		 */
			
			
			int[] A= {1,2,6,6,7,9};
			int B=13;
			/*
			 * int[] A = { 1, 5, 7, 10};
			 * 
			 * int B = 8;
			 */
			System.out.println(solve(A,B));
	}
	
	 public static int solve(int[] A, int B) {
		 if((A.length<=1))
		 {
			 System.out.println("size is 1");
            	 
            	 return 0;        
		 }
		 //corner case if all the elements are same in array
		
		// System.out.println("count ele"+countEle);
		
		 int n=A.length;
		 long ans=0;
		 int leftPointer=0;
		 int rightPointer=n-1;
		 while(leftPointer<rightPointer)
		 {
			// System.out.println("left Pointer "+leftPointer+"   Right Pointer "+rightPointer+"  n"+n);
			 if(A[rightPointer]+A[leftPointer]<B)
			 {
				 leftPointer++;
			 }
			 else if(A[rightPointer]+A[leftPointer]>B)
			 {
				  rightPointer--;
			 }
			 else
			 {
				 if(leftPointer!=rightPointer)
				 {
					 if(A[leftPointer]==A[rightPointer])
					 {	 
						 long count=rightPointer-leftPointer+1;
						 count=(count*(count-1))/2;
						 ans+=count;
						// ans+=1;
						 leftPointer=rightPointer;
						 
						 
						 System.out.println("  ans mod "+ans);
					
						 
					 }
					 else if(((leftPointer < n-1) && (A[leftPointer]==A[leftPointer+1]))|| ((rightPointer>=1) && (  A[rightPointer]==A[rightPointer-1])))
					 {
						 long countRight=1;
						 long countLeft=1;
						 while((rightPointer>=1) && (A[rightPointer-1]==A[rightPointer]) )
						 {
							 countRight++;
							 rightPointer--;
						
						 }	
						 while((leftPointer<n-1) && (A[leftPointer+1]==A[leftPointer]) )
						 {
							 countLeft++;
							 leftPointer++;
						
						 }	
						 System.out.println("this ");
						 System.out.println("Pair { "+A[leftPointer]+", "+A[rightPointer]+" }");
						 ans+=countLeft*countRight;
						 //ans+=1;
						 leftPointer++;
						 rightPointer --;
						// continue;
						 
					 }
					 
					 else
					 {
						 System.out.println("Pair { "+A[leftPointer]+", "+A[rightPointer]+" }");
						 ans++;
						 leftPointer++;
						 rightPointer--;
						 
					 }
					
				 }
				 else
				 {
					 rightPointer--;
				 }
				
			 }
		 }
		 
		 
		 
		 
		 return (int)  (ans%1000000007);
	    }

}

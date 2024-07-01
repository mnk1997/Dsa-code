package in.cdac.pract;

import java.util.ArrayList;

public class MaximumSubArrayEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maxSubarray(int A, int B, ArrayList<Integer> C) {
		 if(C.size()==0)
			 return 0;
		 if(C.size()==1)
			 return  C.get(0)<=B?C.get(0):0;
		 int leftPtr=0;
		 int rightPtr=0;
		 int ans=0;
		 int currSum=0;
		 while(rightPtr<C.size())
		 {
             	currSum+=C.get(rightPtr);
              while(currSum>B && leftPtr<C.size())
			 {
				 currSum-=C.get(leftPtr);
				 leftPtr++;
			 }
             
		  if(currSum==B)
			 {
				 return B;
			 }
			
			 ans=(currSum<=B)?Math.max(ans, currSum):ans;
				 
				
				 rightPtr++;
				 
			 
			
			
			 
			
		 }
         	//ans=(currSum<=B)?Math.max(ans, currSum):ans;
		 return ans;
		 
	    }

}

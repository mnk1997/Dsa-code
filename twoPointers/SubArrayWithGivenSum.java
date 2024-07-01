package in.cdac.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(5,10,20,100,105));
        int B=110;
        solve(list,B);
	}
	 public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

	        int firstPtr=0;
	        int secondPtr=0;
	        int currSum=A.get(0);
	       
	        while(secondPtr<A.size() && firstPtr <A.size())
	        {
	        	System.out.println("currSum"+currSum);
	            
	             if(currSum==B)
	             {
	            	 System.out.println(" first Ptr"+firstPtr +" second Ptr"+secondPtr);
                	// System.out.println();
	                 ArrayList<Integer> result=new ArrayList<>();
	                 for(int i=firstPtr;i<=secondPtr;i++)
	                 {
	                	 
	                     result.add(A.get(i));
	                     
	                 }
	                 return result;
	             }
	             else if(currSum <B)
	             {
	            	 System.out.println("Curr sum is less than B");
	                 secondPtr+=1;
	                 if(secondPtr<A.size())
	                  currSum+=A.get(secondPtr);
	             }
	             else 
	             {
	            	 System.out.println("Curr sum is greater than B"+currSum);
	                 currSum=currSum-A.get(firstPtr);
	                // System.out.println("Subtracted ");
	                 firstPtr=firstPtr+1;
	             }
	             
	             System.out.println("--------------------------------------------------");
	        }
	        return new ArrayList<>(Arrays.asList(-1));
	    }

}

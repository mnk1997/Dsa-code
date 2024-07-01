package in.cdac.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ans=threeSumClosest(new ArrayList<Integer>(new HashSet<>(Arrays.asList(-5,1,4,-7,10,-7,0,7,3,0,-2,-5,-3,-6,4,-7,-8,0,4,9,4,1,-8,-6,-6,0,-9,5,3,-9,-5,-9,6,3,8,-10,1,-2,2,1,-9,2,-3,9,9,-10,0,-9,-2,7,0,-4,-3,1,6,-3))), -1);
          System.out.println("answre"+ans);
	}
	 public static int threeSumClosest(ArrayList<Integer> A, int B) {
		 
	        Collections.sort(A);
	        int firstPtr=-1;
	        int lastPtr=-1;
	        int currDif=Integer.MAX_VALUE;
	        int ans=0;
	       for(int i=0;i<A.size();i++)
	       {
	    	   firstPtr=i+1;
	    	   lastPtr=A.size()-1;
	    	 //  int sum= A.get(i);
	    	   while(firstPtr<lastPtr)
	    	   {
	    		   if(Math.abs(A.get(i)+A.get(firstPtr)+A.get(lastPtr)-B)<currDif)
	    		   {
	    			   ans=A.get(i)+A.get(firstPtr)+A.get(lastPtr);
	    			   firstPtr+=1;
	    			   lastPtr-=1;
	    		   }
	    		   else if((A.get(i)+A.get(firstPtr)+A.get(lastPtr))>B)
	    		   {
	    			   lastPtr=lastPtr-1;
	    		   }
	    		   else if((A.get(i)+A.get(firstPtr)+A.get(lastPtr))<B)
	    		   {
	    			   firstPtr=firstPtr+1;
	    		   }
	    		   else
	    		   {
	    			   System.out.println("lets see what is in this case");
	    		   }
	    			   
	    	   }
	       }
	       
	       return ans;
	    }
}

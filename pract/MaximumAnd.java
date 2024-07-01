package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(13,18,23,56,81,20,4,24,93));
		System.out.println(solve(A));

	}
	 public static int solve(ArrayList<Integer> A) {
	        int ans=0;
	        for(int i=30;i>=0;i--)
	        {
	            int count=0;
	            for(int j=0;j<A.size();j++)
	            {
	                //check for count 
	                
	                if((A.get(j) & 1<<i) >=1)
	                {
	                    count++;
	                }
	            }
	            if(count>=2)
	            {
	                ans=ans | (1<<i);
	                  for(int val=0;val<A.size();val++)
	            {
	                //check for count 
	                
	                if((A.get(val) & 1<<i) ==0)
	                {
	                     A.set(val,0);
	                }
	            }
	            }
	        }
	        return ans;
	    }
}

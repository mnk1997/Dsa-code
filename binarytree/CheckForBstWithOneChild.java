package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckForBstWithOneChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(25,2,42,49,44))));

	}
	  public static String solve(ArrayList<Integer> A) {

	        ArrayList<Integer> minInRight=new ArrayList<>();
	        ArrayList<Integer> maxInRight=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	            minInRight.add(0);
	            maxInRight.add(0);
	        }
	        for(int i=A.size()-1;i>=0;i--)
	        {
	            if(i==A.size()-1)
	            {
	                minInRight.set(i,A.get(i));
	                maxInRight.set(i,A.get(i));
	            }
	            else
	            {
	                if(A.get(i)<minInRight.get(i+1))
	                {
	                    minInRight.set(i,A.get(i));
	                    //maxInRight.set(i,maxInRight.get(i+1));
	                }
	                else
	                {
	                    minInRight.set(i,minInRight.get(i+1));
	                    //maxInRight.set(i,A.get(i));
	                }
	                if(A.get(i)>maxInRight.get(i+1))
	                {
	                	maxInRight.set(i,A.get(i));
	                }
	                else
	                {
	                	maxInRight.set(i,maxInRight.get(i+1));
	                }
	            }
	        }
	        //
	        for(int i=0;i<A.size();i++)
	        {
	        	System.out.print("min --> "+minInRight.get(i) +"   max--> "+maxInRight.get(i));
	        	System.out.println();
	        }

	        for(int i=0;i<A.size()-1;i++)
	        {
	                if(A.get(i+1)>A.get(i))
	                {
	                    if(minInRight.get(i)<A.get(i))
	                    {
	                        return "NO";
	                    }
	                }
	                else{
	                      if(maxInRight.get(i)>A.get(i))
	                      {
	                          return "NO";
	                      }
	                }
	        }
	        return "YES";
	    }

}

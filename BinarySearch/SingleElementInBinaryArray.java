package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInBinaryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArrayList<Integer> list=new ArrayList<>(Arrays.asList(13,13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493));
	  System.out.println(solve(list));
	}
	 public static int solve(ArrayList<Integer> A) {
	        int l=0;
	        int r=A.size()-1;
	        while(l<=r)
	        {
	        	
	            int mid=l +(r-l)/2;
	            System.out.println("mid  "+A.get(mid)+ "    "+mid+ " mid-1 "+A.get(mid-1)+"  mid +1 "+A.get(mid+1));
	            System.out.println(A.get(mid-1).equals(A.get(mid)));
	            System.out.println(A.get(mid-1)==(A.get(mid)));
	            if((mid==0|| ! A.get(mid-1).equals(A.get(mid))) && (mid==A.size()-1 ||! A.get(mid+1).equals(A.get(mid))) )
	            {
	            	System.out.println("returning");
	                return A.get(mid);
	            }
	            if(mid%2==0)
	            {
	                if(A.get(mid).equals(A.get(mid+1)) && ! A.get(mid-1).equals( A.get(mid)))
	                {
	                    l=mid+2;
	                }
	                else if(A.get(mid).equals( A.get(mid-1)) && !A.get(mid+1).equals( A.get(mid)))
	                {
	                    r=mid-2;
	                }
	            }
	            else{
	                if(A.get(mid).equals( A.get(mid-1))  && !A.get(mid+1).equals( A.get(mid)))
	                {
	                    l=mid+1;
	                }
	                else if(A.get(mid).equals( A.get(mid+1)) && !A.get(mid-1).equals( A.get(mid)))
	                {
	                    r=mid-1;
	                }
	            }

	        }
	        return A.get(0);
	    }
}

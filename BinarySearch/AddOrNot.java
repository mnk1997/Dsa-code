package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*Given an array of integers A of size N and an integer B.

In a single operation, any one element of the array can be
increased by 1. You are allowed to do at most B such operations.

Find the number with the maximum number of occurrences and
return an array C of size 2, where C[0] is the number of occurrences,
		and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.*/
public class AddOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
	        HashMap<Integer,Integer> hm=new HashMap<>();
	        for(int i=0;i<A.size();i++)
	        {
	            if(hm.containsKey(A.get(i)))
	            {
	                int val=hm.get(A.get(i));
	                hm.put(A.get(i),val+1);
	            }
	            else{
	                  hm.put(A.get(i),1);
	            }
	        }
	        //sort the array 
	        Collections.sort(A);
	        int firstPtr=0;
	        int secondPtr=0;
	        int ansFreq=0;
	        int ansVal=0;
	        while(secondPtr<A.size())
	        {
	            while(secondPtr<A.size() && A.get(firstPtr)==A.get(secondPtr))
	            {
	                secondPtr++;
	            }
	            
	            int freq=hm.get(A.get(firstPtr));
	            int diff=0;
	            if(secondPtr==A.size())
	            { 
	               
	               secondPtr-=1;
	            }
	            
	                diff=A.get(secondPtr)-A.get(firstPtr);
	                int count=0;
	            if(diff==0)
	            {
	               count=freq;
	            }
	            else
	            {
	                  count=Math.min(freq,B/diff)+hm.get(A.get(secondPtr));
	            }
	            
	            if(count>ansFreq)
	            {
	                ansFreq=count;
	                ansVal=A.get(secondPtr);
	            }
	            firstPtr=secondPtr;
	            secondPtr++;
	        }
	        if(secondPtr==A.size() && firstPtr==0)
	        {
	            ansFreq=A.size();
	            ansVal=A.get(firstPtr);
	        }
	        ArrayList<Integer> output=new ArrayList<>();
	        output.add(ansFreq);
	        output.add(ansVal);
	        return output;
	    }

}

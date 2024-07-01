package in.cdac.pract;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {
		int ans=Integer.MAX_VALUE;
		//sort each row TC:O(A * B* LogB)
		for (int i=0;i<C.size();i++)
		        Collections.sort(C.get(i));
		
		//now for each row we have to find the best element
		for(int i=0;i<C.size();i++)
		{
			for(int j=0;j<C.get(i).size();j++)
			{
			      
			}
		}
		
		
		
		
		
		
		
		return ans;
	    }

}

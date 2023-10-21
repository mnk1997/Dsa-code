package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(0, 4, 7, 9));
		System.out.println(findMinXor(A));

	}
	 public static int findMinXor(ArrayList<Integer> A) {
	        Collections.sort(A);
	        int ans=Integer.MAX_VALUE;
	        for(int i=0;i<A.size()-1;i++)
	        {
	            ans=Math.min(ans,(A.get(i)^A.get(i+1)));
	        }
	        
	        return ans;
	    }
}

package in.cdac.pract;

import java.util.HashMap;
import java.util.HashSet;

public class CountPairDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {2,1,2,1,2,1,2,1,2};
		int B=1;
		System.out.println(solve(A,B));

	}
	 public static int solve(int[] A, int B) {
	        long count=0;
	        HashMap<Integer,Long> uniq=new HashMap<>();
	        for(int ele:A)
	        {
	            if(uniq.containsKey(ele+B))
	            {
	                count=count+uniq.get(ele+B);
	            }
	            if(uniq.containsKey(ele-B))
	            {
	                count=count+uniq.get(ele-B);
	            }
	            
	            if(uniq.containsKey(ele))
	            {
	            	uniq.put(ele,uniq.get(ele)+1);
	            }
	            else
	            {
	            	uniq.put(ele,1l);
	            }
	        }

	        return (int)count%1000000007;
	    }

}

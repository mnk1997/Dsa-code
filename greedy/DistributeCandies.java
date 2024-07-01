package in.cdac.greedy;

import java.util.ArrayList;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int candy(ArrayList<Integer> A) {
		ArrayList<Integer> minCandies=new ArrayList<>();
		//initialized all the students with 1
		for(int i=0;i<A.size();i++)
		{
			minCandies.add(1);
		}
		//stabling from left side
		for(int i=1;i<A.size();i++)
		{
			   if(A.get(i)>A.get(i-1) && minCandies.get(i)<=minCandies.get(i-1))
			   {
				   minCandies.set(i,minCandies.get(i-1)+1);
			   }
		}
		
		//stabling right side
		for(int i=A.size()-2;i>=0;i--)
		{
			if(A.get(i)>A.get(i+1) && minCandies.get(i)<=minCandies.get(i+1))
			{
				minCandies.set(i,minCandies.get(i+1)+1);
			}
		}
		
		int ans=0;
		for(int ele:minCandies)
		{
			ans+=ele;
		}
		return ans;
	    }

}

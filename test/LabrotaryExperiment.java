package in.cdac.test;

import java.util.ArrayList;
import java.util.Arrays;

public class LabrotaryExperiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A=new ArrayList<>();
		A.add(new ArrayList<>(Arrays.asList(1,2)));
		/*
		 * A.add(new ArrayList<>(Arrays.asList(2,3))); A.add(new
		 * ArrayList<>(Arrays.asList(3,1)));
		 */
		ArrayList<Integer> B=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
	   System.out.println(solve(A,B));

	}
	 public static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
		 int ans=0;
		 ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
		 initializeAdjacencyList(adjList,B.size());
		 buildAdjacencyListUsingRelation(A,adjList);
		 boolean visited[] =new boolean[B.size()];
		 for(int i=0;i<adjList.size();i++)
		 {
			 if(!visited[i])
			 {
				 ans+=dfs(i,adjList,visited,B);
			 }
			// System.out.println("ans "+ans);
		 }
		 
		 
		 
		 return ans;
	    }
	private static int dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> b) {
		    if(visited[i])
		    	return b.get(i);
		    else
		    {
		    	//System.out.println("Current "+(i+1));
		    	int currMin=b.get(i);
		    	visited[i]=true;
		    	for(int idx=0;idx<adjList.get(i).size();idx++)
		    	{
		    		
		    	     currMin=Math.min(currMin,dfs(adjList.get(i).get(idx),adjList,visited,b));	
		    	    // System.out.println("curr min"+currMin);
		    	}
		    	return currMin;
		    }
		
	}
	private static void buildAdjacencyListUsingRelation(ArrayList<ArrayList<Integer>> a,
			ArrayList<ArrayList<Integer>> adjList) {
		
		
		// TODO Auto-generated method stub
		for(int i=0;i<a.size();i++)
		{
			//System.out.println("hello");
				int x=a.get(i).get(0);
				int y=a.get(i).get(1);
				//System.out.println("x :"+x +" y:"+y );
				
				adjList.get(x-1).add(y-1);
				adjList.get(y-1).add(x-1);
			
		}
	}
	private static void initializeAdjacencyList(ArrayList<ArrayList<Integer>> adjList, int size) {
		// TODO Auto-generated method stub
		//adjList=new ArrayList<>(10);
		//System.out.println("Called initialize "+adjList.size());
		for(int i=0;i<size;i++)
		{
			 adjList.add( new ArrayList<>());
		}
		//System.out.println("size afterward "+adjList.size());
	}

}

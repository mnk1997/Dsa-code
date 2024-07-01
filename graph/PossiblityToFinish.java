package in.cdac.graph;

import java.util.ArrayList;

/*There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, 
which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.*/
public class PossiblityToFinish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public int solve(int A, int[] B, int[] C) {
		   ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
		   for(int i=0;i<A;i++)
		   {
			   adjList.add(new ArrayList<Integer>());
		   }
	        boolean[] visited=new boolean[A];
	        initializeAdjMatrix(adjList,B,C);
	        boolean cycle=false;
	        for(int i=0;i<A;i++)
	        {
	            
	          cycle=cycle|  dfs(i,adjList,visited,A);
	          if(cycle)
	        	  break;
	        }
 
	        
	        if(cycle)
	          return 0;
	        else 
	        	return 1;
	    }
	private boolean dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,int A) {
		// TODO Auto-generated method stub
		if(i>=A)
			return false;
		else if(visited[i])
		{
			return true;
		}
		visited[i]=true;
		for(int ele:adjList.get(i))
		{
			
				
			    if(dfs(ele,adjList,visited,A))
			    	return true;
			   
			
		}
		visited[i]=false;
		
		return false;
	}
	private void initializeAdjMatrix(ArrayList<ArrayList<Integer>> adjList, int[] b, int[] c) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.length;i++)
		{
			int source=b[i];
			int dest=c[i];
			adjList.get(source-1).add(dest-1);
		}
		
	}

}

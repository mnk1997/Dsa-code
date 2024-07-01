package in.cdac.graph;

import java.util.ArrayList;

public class MinimumNumberOfSemester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMinNumberOfSemester(int A,int[][] B)
	{
		ArrayList<ArrayList<Integer>> adjList=new ArrayList();
		 int[] indegree=new int[A];
		buildAdjacenyListUsingInput(adjList,B,A,indegree);
		int ans=1;
		
		
			if(detectCycle(adjList))
				return -1;
		
	   
	   // initializeInDegree(adjList);
	    int totalNumberOfNodesAccessed=0;
		ArrayList<Integer> minHeap=new ArrayList<>();
		totalNumberOfNodesAccessed+=findNumberOfNodesWithZeroDegreeAndInsertIntoHeap(adjList,indegree,minHeap);
	    while(totalNumberOfNodesAccessed!=A  && !minHeap.isEmpty())
	    {
	    	getMinAndReduceIndegreeOfAttachedNodes(minHeap,adjList,indegree);
	    	int numberOfEleWithZero=findNumberOfNodesWithZeroDegreeAndInsertIntoHeap(adjList,indegree,minHeap);
	    	if(numberOfEleWithZero==0)
	    		break;
	    	totalNumberOfNodesAccessed+=numberOfEleWithZero;
	    	ans+=1;
	    }
		
		
		
		
		return ans;
	}
	private void getMinAndReduceIndegreeOfAttachedNodes(ArrayList<Integer> minHeap,
			ArrayList<ArrayList<Integer>> adjList, int[] indegree) {
		// TODO Auto-generated method stub
		
		int node=minHeap.get(0)
		
	}
	private int findNumberOfNodesWithZeroDegreeAndInsertIntoHeap(ArrayList<ArrayList<Integer>> adjList, int[] indegree,
			ArrayList<Integer> minHeap) {
		// TODO Auto-generated method stub
		int countNumberWithZeroIndegree=0;
		for(int i=0;i<indegree.length;i++)
		{
			if(indegree[i]==0)
			{
				countNumberWithZeroIndegree+=1;
				insertIntoHeap(minHeap,i);
			}
				
			
		}
		return countNumberWithZeroIndegree;
	}
	private boolean detectCycle( ArrayList<ArrayList<Integer>> adjList) {
		// TODO Auto-generated method stub
		boolean[] visited=new boolean[adjList.size()];
		for(int i=0;i<adjList.size();i++)
		{
			visited[i]=true;
			 if(dfsToDetectCycle(adjList,i,visited));
				 visited[i]=false;
		}
		
		return false;
	}
	private boolean dfsToDetectCycle(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		boolean result=false;
		     for(int ele:adjList.get(i))
		     {
		    	 if(visited[ele])
		    		 result= true;
		    	 visited[ele]=true;
		    	  result=result| dfsToDetectCycle(adjList, ele, visited);
		    	  visited[ele]=false;
		    	  if(result)
		    		  return true;
		    	 
		     }
		return result;
	}
	private void buildAdjacenyListUsingInput(ArrayList<ArrayList<Integer>> adjList, int[][] b, int a, int[] indegree) {
		// TODO Auto-generated method stub
		for(int i=0;i<a;i++)
		{
			adjList.add(new ArrayList<>());
		}
		for(int i=0;i<b.length;i++)
		{
			int source=b[i][0];
			int dest=b[i][1];
			adjList.get(source-1).add(dest-1);
			indegree[dest-1]+=1;
			
		}
		
	}

}

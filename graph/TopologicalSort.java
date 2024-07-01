package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(1,4)));
		list.add(new ArrayList<>(Arrays.asList(1,2)));
		list.add(new ArrayList<>(Arrays.asList(4,2)));
		list.add(new ArrayList<>(Arrays.asList(4,3)));
		list.add(new ArrayList<>(Arrays.asList(3,2)));
		list.add(new ArrayList<>(Arrays.asList(5,2)));
		list.add(new ArrayList<>(Arrays.asList(3,5)));
		list.add(new ArrayList<>(Arrays.asList(8,2)));
		list.add(new ArrayList<>(Arrays.asList(8,6)));
		
		for(int ele:solveUsingMinHep(8,list))
		{
			System.out.print(ele+" ");
		}

	}
	
	
	//if the quesiton asks for lexiographically sorted order then we have to use minHeap instead of any other DS, so that we can extract
	//on the basis of node number
	public static ArrayList<Integer> solveUsingMinHep(int A, ArrayList<ArrayList<Integer>> B) {
		   
		/*
		 * //find Adjacency List by given method // ArrayList<ArrayList<Integer>>
		 * adjList=new ArrayList<>(); for(int i=0;i<A;i++) { adjList.add(new
		 * ArrayList<>()); } makeAdjacencyList(adjList,B);
		 */
	   
	   
	   //calculate inDegree for all the nodes and insert into Queue having all the nodes with 0 indegree.
	        int[] inDegree=new int[A];
	        boolean[] visited=new boolean[A];
	        ArrayList<Integer> minHeap=new ArrayList<>();
	       //function for calculating inDegree and inserting to Deque
	       findInDegreeForAllNode(inDegree,B);
	       insertIntoHeap(inDegree, minHeap,visited);
	       //check whether graph has cycle or not,then every nodee  wil have atleast 1 indegree
	         if(minHeap.isEmpty())
	        	 return new ArrayList<>();
	   // pop the nodes with 0 degree and reduce the indegree of the subsequent nodes 
	         ArrayList<Integer> topologicalOrder=new ArrayList<>();
	        while(!minHeap.isEmpty())
	        {
	        	int minEle=minHeap.get(0);
	        	removeFromHeap(minHeap);
	        	//reduce the indegree for attached nodes and if 0 insert into dequeu
	        	     manipulateIndegreeForReachedNodes(B,inDegree,minEle);
	        	     insertIntoHeap(inDegree,minHeap,visited);
	        	     //+1 because vertex are from 1
	        	     System.out.println("adding int answeer "+minEle);
	        	     topologicalOrder.add(minEle);
	        	     
	        	     
	        }
	        
	        return topologicalOrder;
	   
    }
	
	private static void removeFromHeap(ArrayList<Integer> minHeap) {
		// TODO Auto-generated method stub
		
		minHeap.set(0, minHeap.get(minHeap.size()-1));
		minHeap.remove(minHeap.size()-1);
		int currIdx=0;
		int lc=2*currIdx+1;
		int rc=2*currIdx+2;
		while(lc<minHeap.size())
		{
			int leftVal=minHeap.get(lc);
			int currVal=minHeap.get(currIdx);
			int rightVal=rc<minHeap.size()?minHeap.get(rc):Integer.MAX_VALUE;
			if(leftVal<currVal && leftVal<=rightVal)
			{
				minHeap.set(lc, currVal);
				minHeap.set(currIdx, leftVal);
				currIdx=lc;
			}
			else if(rightVal<currVal && rightVal<leftVal)
			{
				minHeap.set(rc, currVal);
				minHeap.set(currIdx, rightVal);
				currIdx=rc;
			}
			else
			{
				break;
			}
			lc=2*currIdx+1;
			 rc=2*currIdx+2;
		}
		
		System.out.println("citnent of minHeap");
		for(int ele:minHeap)
		{
			System.out.print(ele+" ");
		}
		
	}


	//solve using queue was giving me correct answer only if the question doesn't ask for lexiographically sorted order.....
	   public static ArrayList<Integer> solveUsingQueue(int A, ArrayList<ArrayList<Integer>> B) {
		   
			/*
			 * //find Adjacency List by given method // ArrayList<ArrayList<Integer>>
			 * adjList=new ArrayList<>(); for(int i=0;i<A;i++) { adjList.add(new
			 * ArrayList<>()); } makeAdjacencyList(adjList,B);
			 */
		   
		   
		   //calculate inDegree for all the nodes and insert into Queue having all the nodes with 0 indegree.
		        int[] inDegree=new int[A];
		        boolean[] visited=new boolean[A];
		        Deque<Integer> q=new LinkedList<>();
		       //function for calculating inDegree and inserting to Deque
		       findInDegreeForAllNode(inDegree,B);
		       insertIntoDeque(inDegree, q,visited);
		       //check whether graph has cycle or not,then every nodee  wil have atleast 1 indegree
		         if(q.isEmpty())
		        	 return new ArrayList<>();
		   // pop the nodes with 0 degree and reduce the indegree of the subsequent nodes 
		         ArrayList<Integer> topologicalOrder=new ArrayList<>();
		        while(!q.isEmpty())
		        {
		        	
		        	//reduce the indegree for attached nodes and if 0 insert into dequeu
		        	     manipulateIndegreeForReachedNodes(B,inDegree,q.peek());
		        	     insertIntoDeque(inDegree,q,visited);
		        	     //+1 because vertex are from 1
		        	     topologicalOrder.add(q.poll());
		        	     
		        }
		        
		        return topologicalOrder;
		   
	    }
	private static void insertIntoDeque(int[] inDegree, Deque<Integer> q,boolean[] visited) {
		// TODO Auto-generated method stub
		for(int i=0;i<inDegree.length;i++)
		{
			if(inDegree[i]==0 && visited[i]==false)
			{
				System.out.print("Addign into queeu  "+(i+1));
				visited[i]=true;
				q.add(i+1);
				//insertIntoHeap(i+1,minHeap);
				
			}
		}
		System.out.println();
	}
	private static void insertIntoHeap(int[] inDegree, ArrayList<Integer> minHeap,boolean[] visited) {
		// TODO Auto-generated method stub
		for(int i=0;i<inDegree.length;i++)
		{
			if(inDegree[i]==0 && visited[i]==false)
			{
				System.out.print("Addign into heap  "+(i+1));
				visited[i]=true;
				//q.add(i+1);
				insertIntoHeap(i+1,minHeap);
				
			}
		}
		System.out.println();
	}
	private static void insertIntoHeap(int i, ArrayList<Integer> minHeap) {
		// TODO Auto-generated method stub
		if(minHeap.size()==0)
		{
			minHeap.add(i);
			return;
		}
		minHeap.add(i);
		int currIndex=minHeap.size()-1;
		int currParentIndex=(currIndex-1)/2;
		while(currIndex>0)
		{
			if(minHeap.get(currParentIndex)>minHeap.get(currIndex))
			{
				int temp=minHeap.get(currParentIndex);
				minHeap.set(currParentIndex, minHeap.get(currIndex));
				minHeap.set(currIndex, temp);
				currIndex=currParentIndex;
				currParentIndex=(currIndex-1)/2;
				
			}
			else
			{
				break;
			}
		}
			
		
	}


	private static void manipulateIndegreeForReachedNodes(ArrayList<ArrayList<Integer>> b, int[] inDegree, Integer head) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.size();i++)
		{
			int source=b.get(i).get(0);
			int dest=b.get(i).get(1);
			if(source==head)
			{
				inDegree[dest-1]-=1;
			}
		}
		
		
	}

	private static void findInDegreeForAllNode(int[] inDegree, ArrayList<ArrayList<Integer>> b) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.size();i++)
		{
			//int source=b.get(i).get(0);
			int dest=b.get(i).get(1)-1;
			inDegree[dest]+=1;
		}
		
		for(int i:inDegree)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}


}

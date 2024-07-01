package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
*/
/*Input 1:

	 A = [1, 1, 2]
	 B = 1
	 C = 2
	Input 2:

	 A = [1, 1, 2]
	 B = 2
	 C = 1


	Example Output
	Output 1:

	 0
	Output 2:

	 1*/
public class FirstDepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1,1,2));
		System.out.println("answer "+solve(A,2,1));

	}
	 public static int solve(ArrayList<Integer> A, final int B, final int C) {
		 if(B==C)
			 return 0;
		 ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
		 initializeAdjacencyList(adjList,A);
		 boolean[] visited=new boolean[A.size()];
		 int source=C;
		 Queue<Integer> q=new LinkedList<>();
		 for(int ele:adjList.get(source-1))
		 {
			 
			 insertIntoQueue(q,ele);
			 visited[ele]=true;
		 }
		 while(!q.isEmpty() && !visited[B-1])
		 {
			 int currNode=q.poll();
			 for(int ele:adjList.get(currNode))
			 {
				 if(!visited[ele])
				 {
					 insertIntoQueue(q,ele);
					 visited[ele]=true;
				 }
					 
			 }
		 }
		 
		 if(visited[B-1])
			 return 1;
		 return 0;
	    }
	private static void insertIntoQueue(Queue<Integer> q, int ele) {
		// TODO Auto-generated method stub
		q.offer(ele);
		
	}
	
	private static void initializeAdjacencyList(ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.size();i++)
		{
			adjList.add(new ArrayList<>());
		}
		for(int i=1;i<a.size();i++)
		{
			int source=a.get(i)-1;
			int dest=i;
			adjList.get(source).add(dest);
		}
		
	}

}

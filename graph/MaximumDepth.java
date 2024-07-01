package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*Given a Tree of A nodes having A-1 edges.
 *  Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X.
 Find the value of such node which lies at level L mod (MaxDepth + 1)
 and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints

2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106*/

/*A = 5
B = [1, 4, 3, 1]
C = [5, 2, 4, 4]
D = [7, 38, 27, 37, 1]
E = [1, 1, 2]
F = [32, 18, 26]
Input 2:

A = 3
B = [1, 2]
C = [3, 1]
D = [7, 15, 27]
E = [1, 10, 1]
F = [29, 6, 26]


Example Output

Output 1:

[37, 37, 27]
Output 2:

[-1, 7, 27]*/
public class MaximumDepth {

	static class Node {
		int node;
		int val;

		Node(int n, int v) {
			this.node = n;
			this.val = v;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int ele : solve(3, new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(3, 1)),
				new ArrayList<>(Arrays.asList(7, 15, 27)), new ArrayList<>(Arrays.asList(1, 10, 1)),
				new ArrayList<>(Arrays.asList(29, 6, 26)))) {
			System.out.println(ele + " ");
		}

	}

	public static ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D,
			ArrayList<Integer> E, ArrayList<Integer> F) {

		ArrayList<ArrayList<Node>> adjList = new ArrayList<>(A);
		for (int i = 0; i < A; i++) {
			adjList.add(new ArrayList<>());
		}
		constructAdjacencyList(adjList, B, C, D);
		// for every query if we traverse the entire adjList TC will be O(q*E)
		// therefore we will keep in arrayList all the nodes in ascending order while
		// traversing only
		ArrayList<ArrayList<Integer>> nodesWithRespectiveLevels = new ArrayList<>();
		nodesWithRespectiveLevels.add(new ArrayList<>());
		nodesWithRespectiveLevels.get(0).add(D.get(0));
		// nodesWithRespectiveLevels.add(new ArrayList<>());
		//System.out.println("calling ");
		 putNodesValueInTheirLevels(nodesWithRespectiveLevels, adjList);
		 int maxDepth=-1;
		for(int i=0;i<nodesWithRespectiveLevels.size();i++)
		{
			if(nodesWithRespectiveLevels.get(i).size()>0)
			{
				maxDepth+=1;
			}
		}
		System.out.println("callled " + maxDepth);
		for (ArrayList<Integer> innerList : nodesWithRespectiveLevels) {
			Collections.sort(innerList);
		}
	
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < E.size(); i++) {
			System.out.println(" e.get(i)" +E.get(i)+"  maxDepth "+(maxDepth+1));
			int level = (E.get(i)) % (maxDepth + 1);
			System.out.println(" level" +level);
			int val = F.get(i);
			output.add(getNearestMaxValueAtMentionedLevel(level, val, nodesWithRespectiveLevels));
		}
		return output;

	}

	private static Integer getNearestMaxValueAtMentionedLevel(int level, int val,
			ArrayList<ArrayList<Integer>> nodesWithRespectiveLevels) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = nodesWithRespectiveLevels.get(level).size()-1;
		while (left <= right) {
			//System.out.println("level " + level + " nodes sze " + nodesWithRespectiveLevels.size());
			int mid = left + (right - left) / 2;
			if (nodesWithRespectiveLevels.get(level).get(mid) >= val
					&& (mid == 0 || nodesWithRespectiveLevels.get(level).get(mid - 1) < val)) {
				return nodesWithRespectiveLevels.get(level).get(mid);
			} else if (mid == 0 || nodesWithRespectiveLevels.get(level).get(mid - 1) < val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	private static int putNodesValueInTheirLevels(ArrayList<ArrayList<Integer>> nodesWithRespectiveLevels,
			ArrayList<ArrayList<Node>> adjList) {
		Deque<Node> q = new LinkedList<>();
	 boolean[] visited=new boolean[adjList.size()];
		q.add(new Node(0, nodesWithRespectiveLevels.get(0).get(0)));
		visited[0]=true;
		int last = 0;
		int level = 1;
		nodesWithRespectiveLevels.add(new ArrayList<>());
		while (!q.isEmpty()) {
			Node source = q.pollFirst();
			
			for (Node ele : adjList.get(source.node)) {
				
				
				      if(!visited[ele.node])
				      {
				    	  System.out.println("added in queeue " + ele.node);
				    	  nodesWithRespectiveLevels.get(level).add(ele.val);
				    	  q.add(new Node(ele.node, ele.val));
				    	  visited[ele.node]=true;
				      }
				     
				
			}
			
				
			if (last == source.node) {
				System.out.println(" size " + last);
				level++;
				nodesWithRespectiveLevels.add(new ArrayList<>());
				// nodesWithRespectiveLevels.add(new ArrayList<>());
				if (!q.isEmpty())
					last = q.peekLast().node;
			}
			

		}
		System.out.println("nodes size " + nodesWithRespectiveLevels.size());
		for (ArrayList<Integer> innerList : nodesWithRespectiveLevels) {
			for (int ele : innerList) {
				System.out.print(ele + " ");
			}
			System.out.println("--------------------------");
		}

		return level;
		// TODO Auto-generated method stub

	}

	private static void constructAdjacencyList(ArrayList<ArrayList<Node>> adjList, ArrayList<Integer> b,
			ArrayList<Integer> c, ArrayList<Integer> d) {
		for (int i = 0; i < b.size(); i++) {
			int source = b.get(i) - 1;
			int dest = c.get(i) - 1;
			//System.out.println("source "+source +" dest "+dest);
			adjList.get(source).add(new Node(dest, d.get(dest)));
			adjList.get(dest).add(new Node(source,d.get(source)));

		}

		/*
		 * for (ArrayList<Node> innerList : adjList) { for (Node n : innerList) {
		 * System.out.print("node " + n.node + " val " + n.val + "  "); }
		 * System.out.println("-------------------"); }
		 */

		// TODO Auto-generated method stub

	}

}

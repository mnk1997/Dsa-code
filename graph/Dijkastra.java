package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
/*
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.*/
import java.util.Deque;
import java.util.LinkedList;

public class Dijkastra {
	static class Node
	{
		int node;
		int wt;
		Node(int n,int w)
		{
			this.node=n;
			this.wt=w;
		}
	}
	static class Pair
	{
		int node1;
		int node2;
		int wt;
		Pair(int n1,int n2,int w)
		{
			this.node1=n1;
			this.node2=n2;
			this.wt=w;
		}
		 @Override
	        public String toString()
	        {
	        return node1+" -> "+node2+" : "+wt;
	        }
	}
//	[2,4,8],[4,5,3],[1,2,6],[1,5,8],[0,2,4],[3,4,5],[0,5,10],[2,3,10]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		
		list.add(new ArrayList<Integer>(Arrays.asList(2,4,8)));
		list.add(new ArrayList<Integer>(Arrays.asList(4,5,3)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,2,6)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,5,8)));

		list.add(new ArrayList<Integer>(Arrays.asList(0,2,4)));

		list.add(new ArrayList<Integer>(Arrays.asList(3,4,5)));

		list.add(new ArrayList<Integer>(Arrays.asList(0,5,10)));
		list.add(new ArrayList<Integer>(Arrays.asList(2,3,10)));
//		//list.add(new ArrayList<Integer>(Arrays.asList(1,2,6)));
		
		System.out.println(solve(6,list,1));

	}
	//the problem here is when we are setting the minimum value of another node there can be the possiblity of that particular node
	//doesnt have the minimum distance from source node till that time. hence we have to use minHeap which guarantees that 
	//particular node is minimum
	 public static ArrayList<Integer> solveUsingQueue(int A, ArrayList<ArrayList<Integer>> B, int C) {
	        ArrayList<Integer> res=new ArrayList<>();
	       ArrayList< ArrayList<Node>> adjList=new ArrayList<>();
	       for(int i=0;i<A;i++)
			  {
				  adjList.add(new ArrayList<>());
				  if(i==C)
		               res.add(i,0);
				  else
					  
				     res.add(i, Integer.MAX_VALUE);
			  }
	      //  initialize adjList from the given edges B
	        initializeAdjList(adjList,B);
	        boolean[] visited=new boolean[A];
	        //intital every node is intialized to -1
	       
	        Deque<Integer> q=new LinkedList<>();
	        q.push(C);
	       
	        while(!q.isEmpty())
	        {
	        	 visited[q.peek()]=true;
	        	for(Node ele:adjList.get(q.peek()))
	        	{
	        		res.set(ele.node,Math.min(res.get(ele.node), res.get(q.peek())+ele.wt));
	        		if(!visited[ele.node])
	        		    q.add(ele.node);
	        	}
	        	q.poll();
	        }
	        for(int i=0;i<res.size();i++)
	        {
	        	if(res.get(i)==Integer.MAX_VALUE)
	        	{
	        		res.set(i,-1);
	        	}
	        }
	        
       return res;
	    }
	 //the below function will be solved using minHeap
	 public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
	        ArrayList<Integer> res=new ArrayList<>();
	       ArrayList< ArrayList<Node>> adjList=new ArrayList<>();
	       for(int i=0;i<A;i++)
			  {
				  adjList.add(new ArrayList<>());
				  if(i==C)
		               res.add(i,0);
				  else
					  
				     res.add(i, Integer.MAX_VALUE);
			  }
	      //  initialize adjList from the given edges B
	        initializeAdjList(adjList,B);
	        boolean[] visited=new boolean[A];
	        //intital every node is intialized to -1
	       
	        ArrayList<Pair> minHeap=new ArrayList<>();
	        for(Node ele:adjList.get(C))
	        {
	        	insertIntoHeap(minHeap,new Pair(C,ele.node,ele.wt));
	        	//visited[ele.node]=true;
	        }
	       visited[C]=true;
	        while(!minHeap.isEmpty())
	        {
	        	Pair p=getMin(minHeap);
	        	visited[p.node2]=true;
	        	res.set(p.node2,Math.min(res.get(p.node2), res.get(p.node1)+p.wt));
	        	//res.set(p.node2, p.wt);
	        	for(Node ele:adjList.get(p.node2))
	        	{
	        		res.set(ele.node,Math.min(res.get(ele.node), res.get(p.node2)+ele.wt));
	        		if(!visited[ele.node])
	        		{
	        			 insertIntoHeap(minHeap,new Pair(p.node2,ele.node,res.get(p.node2)+ele.wt));
	        		//	 visited[ele.node]=true;
	        		}
	        		   
	        	}
	        	//q.poll();
	        }
	        for(int i=0;i<res.size();i++)
	        {
	        	if(res.get(i)==Integer.MAX_VALUE)
	        	{
	        		res.set(i,-1);
	        	}
	        }
	        
    return res;
	    }
	private static Pair getMin(ArrayList<Pair> minHeap) {
		
		System.out.println();
		for(Pair p :minHeap)
		{
			System.out.println(p.toString());
		}
		// TODO Auto-generated method stub
		Pair p=minHeap.get(0);
		minHeap.set(0,minHeap.get(minHeap.size()-1));
		minHeap.remove(minHeap.size()-1);
		int currIndex=0;
		int lc=2*currIndex+1;
		int rc=2*currIndex+2;
		while(lc<minHeap.size())
		{
			Pair currVal=minHeap.get(currIndex);
			Pair leftVal=minHeap.get(lc);
			Pair rightVal=rc<minHeap.size()?minHeap.get(rc):new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
			if(leftVal.wt<currVal.wt && leftVal.wt<=rightVal.wt)
			{
				minHeap.set(currIndex, leftVal);
				minHeap.set(lc,currVal);
				currIndex=lc;
				
			}
			else if(rightVal.wt<currVal.wt && rightVal.wt<=leftVal.wt)
			{
				minHeap.set(currIndex, rightVal);
				minHeap.set(rc, currVal);
				currIndex=rc;
			}
			else
				
			{
				break;
			}
			lc=2*currIndex+1;
			rc=2*currIndex+2;
		}
		System.out.println(" min pair"+p.toString());
		
		return p;
	}
	private static void insertIntoHeap(ArrayList<Pair> minHeap, Pair pair) {
		// TODO Auto-generated method stub
		if(minHeap.size()==0)
		{
			minHeap.add(pair);
			return ;
		}
		minHeap.add(pair);
		int lastIndex=minHeap.size()-1;
		int lastParentIndex=(lastIndex-1)/2;
        int currIndex=lastIndex;
		while(currIndex>0)
		{
			
			Pair currVal=minHeap.get(currIndex);
            Pair parentVal=minHeap.get(lastParentIndex);
            if(currVal.wt<parentVal.wt)
            {
                minHeap.set(lastParentIndex,currVal);
                minHeap.set(currIndex,parentVal);
                currIndex=lastParentIndex;
                lastParentIndex=(currIndex-1)/2;
            }
            else{
                break;
            }
				
				
		
		  	
		}	
		}
		
	
	private static void initializeAdjList(ArrayList<ArrayList<Node>> adjList, ArrayList<ArrayList<Integer>> b) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.size();i++)
		{
			int n1=b.get(i).get(0);
			int n2=b.get(i).get(1);
			int w=b.get(i).get(2);
			adjList.get(n1).add(new Node(n2,w));
			adjList.get(n2).add(new Node(n1,w));
		}
		
	}

}

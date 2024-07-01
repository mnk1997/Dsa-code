package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
//[1,2,3],[2,3,4],[3,4,5],[4,5,6],[5,1,2],[2,4,3],[2,5,5],[1,3,2]
public class CommutableIslands {
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
		    int wt;
	        int source;
	        int destn;
	        Pair(int s,int d,int w)
	        {
	            this.source=s;
	            this.destn=d;
	            this.wt=w;
	        }
	        @Override
	        public String toString()
	        {
	        return source+" -> "+destn+" : "+wt;
	        }
	    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		
			list.add(new ArrayList<Integer>(Arrays.asList(1,2,10)));
			list.add(new ArrayList<Integer>(Arrays.asList(2,3,5)));
			list.add(new ArrayList<Integer>(Arrays.asList(3,1,9)));
			/*
			 * list.add(new ArrayList<Integer>(Arrays.asList(4,5,6))); list.add(new
			 * ArrayList<Integer>(Arrays.asList(5,1,2))); list.add(new
			 * ArrayList<Integer>(Arrays.asList(2,4,3))); list.add(new
			 * ArrayList<Integer>(Arrays.asList(2,5,5))); list.add(new
			 * ArrayList<Integer>(Arrays.asList(1,3,2)));
			 */
			
			System.out.println(solveFinalOneModified(3,list));
			

		}
	  public static int solve(int A, ArrayList<ArrayList<Integer>> B)
	  {
		  ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
		  
			  for(int i=0;i<B.size();i++)
			  {
				  edges.add(new ArrayList<>(Arrays.asList(B.get(i).get(0),B.get(i).get(1),B.get(i).get(2))));
				  edges.add(new ArrayList<>(Arrays.asList(B.get(i).get(1),B.get(i).get(0),B.get(i).get(2))));
			  }
			  ArrayList<Pair> minHeap=new ArrayList<>();
		       
		        boolean[] visited=new boolean[A+1];
		        int source=1;
		        for(int i=0;i<edges.size();i++)
		        {
		        	if(edges.get(i).get(0)==source && !visited[edges.get(i).get(1)])
		        	{
		        		insert(minHeap,new Pair(source,edges.get(i).get(1),edges.get(i).get(2)));
		        	}
		        }
		        visited[source]=true;
		        int sum=0;
		        while(!minHeap.isEmpty())
		        {
		            Pair p=getMin(minHeap);//logN
		           
		            	
		            
		            source=p.destn;
		            for(int i=0;i<edges.size();i++)
			        {
		            	if(edges.get(i).get(0)==source)
		            	{
		            		if(!(visited[edges.get(i).get(1)]))
				        	{
				        		insert(minHeap,new Pair(source,edges.get(i).get(1),edges.get(i).get(2)));
				        	}
		            	}
			        	//System.out.println(B.get(i).get(0)+"  value of " +(!(visited[B.get(i).get(1)])));
			        	
			        }
		            if(!visited[p.destn])
		            {
		            	System.out.println("sum will be added by "+p.wt);
		            	sum+=p.wt;
		            	visited[p.destn]=true;
		            }
		            
		        }

		        //minHeap=buildHeap(minHeap);
		       
		        //int sum=findWeightForMinimumSpanningTree(minHeap,visited,A);
		        return sum;
		        
		  }
	 //the below method is  correct it only gives out of memory for hard test cases
	  public static int solveFinalOne(int A, ArrayList<ArrayList<Integer>> B)
	  {
		  int[][] edges=new int[A+1][A+1];
		//  ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
		  
		 
		  for(int i=0;i<B.size();i++)
		  {
			  int n1=B.get(i).get(0);
			  int n2=B.get(i).get(1);
			  int wt=B.get(i).get(2);
			  edges[n1][n2]=wt;
			  edges[n2][n1]=wt;
		  }
			  
			  ArrayList<Pair> minHeap=new ArrayList<>();
		       
		        boolean[] visited=new boolean[A+1];
		        int source=1;
		        for(int i=2;i<edges[source].length;i++)
		        {
		        	if(edges[source][i]>0)
		        	{
		        		insert(minHeap,new Pair(source,i,edges[source][i]));
		        	}
		        }
		        visited[source]=true;
		        int sum=0;
		        while(!minHeap.isEmpty())
		        {
		            Pair p=getMin(minHeap);//logN
		           
		            	
		            
		            source=p.destn;
		            for(int i=0;i<edges[source].length;i++)
			        {
		            	if(i==source)
		            	{
		            		continue;
		            	}
			        	//System.out.println(B.get(i).get(0)+"  value of " +(!(visited[B.get(i).get(1)])));
			        	if(!(visited[i]) && edges[source][i]>0)
			        	{
			        		insert(minHeap,new Pair(source,i,edges[source][i]));
			        	}
			        }
		            if(!visited[p.destn])
		            {
		            	System.out.println("sum will be added by "+p.wt);
		            	sum+=p.wt;
		            	visited[p.destn]=true;
		            }
		            
		        }

		        //minHeap=buildHeap(minHeap);
		       
		        //int sum=findWeightForMinimumSpanningTree(minHeap,visited,A);
		        return sum;
		        
		  }
	  // the below method is used to overcome TLE facing in above method
	  public static int solveFinalOneModified(int A, ArrayList<ArrayList<Integer>> B)
	  {
		 // int[][] matrix=new int[A+1][A+1];
		  ArrayList<ArrayList<Node>> adjList=new ArrayList<>();
		  for(int i=0;i<A;i++)
		  {
			  adjList.add(new ArrayList<>());
		  }
		  
		 
		  for(int i=0;i<B.size();i++)
		  {
			  int n1=B.get(i).get(0);
			  int n2=B.get(i).get(1);
			  int wt=B.get(i).get(2);
			  adjList.get(n1-1).add(new Node(n2,wt));
			  adjList.get(n2-1).add(new Node(n1,wt));
		  }
			  
			  ArrayList<Pair> minHeap=new ArrayList<>();
		       
		        boolean[] visited=new boolean[A+1];
		        int source=1;
		        for(int i=0;i<adjList.get(source-1).size() ;i++)
		        {
		        	
		        		insert(minHeap,new Pair(source,adjList.get(source-1).get(i).node,adjList.get(source-1).get(i).wt));
		        	
		        }
		        visited[source]=true;
		        int sum=0;
		        while(!minHeap.isEmpty())
		        {
		            Pair p=getMin(minHeap);//logN
		           
		            	
		            
		            source=p.destn;
		            for(Node ele:adjList.get(source-1))
			        {
		            	if(ele.node==source)
		            	{
		            		System.out.println("impossible");
		            		continue;
		            	}
			        	//System.out.println(B.get(i).get(0)+"  value of " +(!(visited[B.get(i).get(1)])));
			        	if(!(visited[ele.node]) && ele.wt>0)
			        	{
			        		insert(minHeap,new Pair(source,ele.node,ele.wt));
			        	}
			        }
		            if(!visited[p.destn])
		            {
		            	System.out.println("sum will be added by "+p.wt);
		            	sum+=p.wt;
		            	visited[p.destn]=true;
		            }
		            
		        }

		        //minHeap=buildHeap(minHeap);
		       
		        //int sum=findWeightForMinimumSpanningTree(minHeap,visited,A);
		        return sum;
		        
		  }
	  
	 //using prims algorithm
	    public static int solveOne(int A, ArrayList<ArrayList<Integer>> B) {
	        HashMap<Pair,Integer> mapToAvoidMultipleEdges=new HashMap<>();
	        mapToAvoidMultipleEdges=functionToFillTheMapWithoutMultipleEdges(B);
	        //the below minHeap is used I have used the same class as i need only 2 things 1. connecting vertex and 2. wt. 
	        //nomenclature is wrong but we can manage
	        ArrayList<Pair> minHeap=new ArrayList<>();
	        //initializing minHeap
	        boolean[] visited=new boolean[A+1];
	        int source=1;
	       // insert(minHeap,new Pair(source,B.get(0).get(1),B.get(0).get(2)));
	        for(Map.Entry<Pair, Integer> e : mapToAvoidMultipleEdges.entrySet())
	        {
	        	//System.out.println(B.get(i).get(0)+"  value of " +(!(visited[B.get(i).get(1)])));
	        	if(e.getKey().source==source && !(visited[e.getKey().destn]))
	        	{
	        		insert(minHeap,new Pair(source,e.getKey().destn,e.getValue()));
	        	}
	        }
	        System.out.println("first node all edges inserted "+minHeap.size());
	        visited[source]=true;
	        int sum=0;
	        while(!minHeap.isEmpty())
	        {
	            Pair p=getMin(minHeap);//logN
	           
	            	
	            
	            source=visited[p.destn]==false?p.destn:p.source;
	            for(Map.Entry<Pair, Integer> e : mapToAvoidMultipleEdges.entrySet())
		        {
		        	//System.out.println(B.get(i).get(0)+"  value of " +(!(visited[B.get(i).get(1)])));
		        	if(e.getKey().source==source && !(visited[e.getKey().destn]))
		        	{
		        		insert(minHeap,new Pair(source,e.getKey().destn,e.getValue()));
		        	}
		        }
	            if(!visited[p.destn] || !visited[p.source])
	            {
	            	System.out.println("sum will be added by "+p.wt);
	            	sum+=p.wt;
	            	visited[p.destn]=true;
	            }
	            
	        }

	        //minHeap=buildHeap(minHeap);
	       
	        //int sum=findWeightForMinimumSpanningTree(minHeap,visited,A);
	        return sum;

	    }
	    public static void insert(ArrayList<Pair> minHeap,Pair p)
	    {
	    	if(minHeap.size()==0)
	    		minHeap.add(p);
	    	else
	    	{
	    		minHeap.add(p);
	    		int lastParentIndex=(minHeap.size()-2)/2;
	    		 while(lastParentIndex>=0)
	 	        {
	 	            int currIndex=lastParentIndex;
	 	            int lc=2*currIndex+1;
	 	            int rc=2*currIndex+2;
	 	            while(lc<minHeap.size())
	 	            {
	 	                Pair leftVal=minHeap.get(lc);
	 	                Pair currVal=minHeap.get(currIndex);
	 	                Pair rightVal=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE);
	 	                if(rc<minHeap.size())
	 	                  rightVal=minHeap.get(rc);

	 	                  if(leftVal.wt<currVal.wt && leftVal.wt<=rightVal.wt)
	 	                     {
	 	                         minHeap.set(lc,currVal);
	 	                         minHeap.set(currIndex,leftVal);
	 	                         currIndex=lc;
	 	                     }
	 	                     else if(rightVal.wt<currVal.wt && rightVal.wt<leftVal.wt)
	 	                     {
	 	                         minHeap.set(rc,currVal);
	 	                         minHeap.set(currIndex,rightVal);
	 	                         currIndex=rc;
	 	                     }
	 	                     else 
	 	                     {
	 	                         break;
	 	                     }
	 	                     lc=2*currIndex+1;
	 	                     rc=2*currIndex+2;
	 	                     
	 	            }
	 	            lastParentIndex-=1;
	    		
	    	}
	    		
	    }
	    }
	    public static HashMap<Pair,Integer>  functionToFillTheMapWithoutMultipleEdges(  ArrayList<ArrayList<Integer>> B)
	    {
	    	 HashMap<Pair,Integer> m=new HashMap<>();
	        for(int i=0;i<B.size();i++)
	        {
	            int s=B.get(i).get(0);
	            int d=B.get(i).get(1);
	            int w=B.get(i).get(2);
	            if(s==d)
	              continue;
	            Pair p=null;
	            if(s<d)
	              p=new Pair(s,d,w);
	            else if(s>d)
	            	p=new Pair(d,s,w);
	            
	            if(p!=null && m.containsKey(p))
	            {
	                m.put(p,Math.min(m.get(p),w));
	            }
	           
	            else
	            {
	                m.put(p,w);
	            }
	        }
	       // System.out.println("map size "+m.size());
	        return m;
	    }
	    public static ArrayList<Pair> buildHeap(ArrayList<Pair> minHeap)
	    {
	        int lastParentIndex=(minHeap.size()-1)/2;
	        while(lastParentIndex>=0)
	        {
	            int currIndex=lastParentIndex;
	            int lc=2*currIndex+1;
	            int rc=2*currIndex+2;
	            while(lc<minHeap.size())
	            {
	                Pair leftVal=minHeap.get(lc);
	                Pair currVal=minHeap.get(currIndex);
	                Pair rightVal=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE);
	                if(rc<minHeap.size())
	                  rightVal=minHeap.get(rc);

	                  if(leftVal.wt<currVal.wt && leftVal.wt<=rightVal.wt)
	                     {
	                         minHeap.set(lc,currVal);
	                         minHeap.set(currIndex,leftVal);
	                         currIndex=lc;
	                     }
	                     else if(rightVal.wt<currVal.wt && rightVal.wt<leftVal.wt)
	                     {
	                         minHeap.set(rc,currVal);
	                         minHeap.set(currIndex,rightVal);
	                         currIndex=rc;
	                     }
	                     else 
	                     {
	                         break;
	                     }
	                     lc=2*currIndex+1;
	                     rc=2*currIndex+2;
	                     
	            }
	            lastParentIndex-=1;
	        }
	        for(int i=0;i<minHeap.size();i++)
	    	{
	    		System.out.println(minHeap.get(i).toString());
	    	}
	        return minHeap;
	    }
	    public static int findWeightForMinimumSpanningTree(ArrayList<Pair> minHeap,boolean[] v,int A)
	    {
	    	
	        int sum=0;
	            while(!minHeap.isEmpty())
	            {
	            	System.out.println("he");
	                     Pair p=getMin(minHeap);
	                     
	                         if(!(v[p.source]) || !(v[p.destn]))
	                         {
	                        	 sum+=p.wt;
	                             v[p.source]=true;
	                             v[p.destn]=true;
	                         }
	                            
	                     
	                   //  A-=1;
	            }
	            return sum;
	            
	    }
	    public static Pair getMin(ArrayList<Pair> minHeap)
	    {
	    	for(int i=0;i<minHeap.size();i++)
	    	{
	    		System.out.println(minHeap.get(i).toString());
	    	}
	        Pair p=minHeap.get(0);
	        minHeap.set(0,minHeap.get(minHeap.size()-1));
	        minHeap.remove(minHeap.size()-1);
	        int currIndex=0;
	         int lc=2*currIndex+1;
	            int rc=2*currIndex+2;
	            while(lc<minHeap.size())
	            {
	                Pair leftVal=minHeap.get(lc);
	                Pair currVal=minHeap.get(currIndex);
	                Pair rightVal=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE);
	                if(rc<minHeap.size())
	                  rightVal=minHeap.get(rc);

	                  if(leftVal.wt<currVal.wt && leftVal.wt<=rightVal.wt)
	                     {
	                         minHeap.set(lc,currVal);
	                         minHeap.set(currIndex,leftVal);
	                         currIndex=lc;
	                     }
	                     else if(rightVal.wt<currVal.wt && rightVal.wt<leftVal.wt)
	                     {
	                         minHeap.set(rc,currVal);
	                         minHeap.set(currIndex,rightVal);
	                         currIndex=rc;
	                     }
	                     else 
	                     {
	                         break;
	                     }
	                     lc=2*currIndex+1;
	                     rc=2*currIndex+2;
	                     
	            }
	            
	            System.out.println("min pair "+p.toString());
	            System.out.println();
	        return p;
	    }

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		

	}
	

}

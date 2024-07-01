package in.cdac.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructionCost {
	static class Pair
	{
		int dest;
		int wt;
		Pair(int d,int w)
		{
			this.dest=d;
			this.wt=w;
		}
		@Override
		public String toString()
		{
		   return this.dest+" "+this.wt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(1,2,14)));
		list.add(new ArrayList<>(Arrays.asList(2,3,7)));
		list.add(new ArrayList<>(Arrays.asList(3,1,2)));
		
		System.out.println(solve(3,list));

	}
	 public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
		 //make adjacency list using given edges
		 ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
		 for(int i=0;i<A;i++)
		 {
			 adjList.add(new ArrayList<>());
		 }
		 intializeAdjacencyList(B,adjList);
		 //insert all the nodes for given Node
		 boolean[] visited=new boolean[A];
		 ArrayList<Pair> minHeap=new ArrayList<>();
		 insertIntoHeap(minHeap,0,adjList.get(0),visited);
		 //minHeap.add(new Pair(0,0));
		 long ans=0;
		 visited[0]=true;
		 while(!minHeap.isEmpty())
		 {
			 Pair p=getMin(minHeap);
			 if(visited[p.dest]==false)
				 ans+=p.wt;
			 visited[p.dest]=true;
			 //System.out.println("for node "+p.dest);
			 for(Pair ele:adjList.get(p.dest))
			 {
				 //System.out.print( ele +" -->");
				 if(!visited[ele.dest])
				 {
					 
					 //System.out.println("ans "+ans);
					 insertIntoHeap(minHeap,p.dest,adjList.get(p.dest),visited);
				 }
			 }
			 System.out.println();
			 
			
		 }
		 
		 return (int)  (ans%1000000007);
	    }
	 private static Pair getMin(ArrayList<Pair> minHeap) {
		// TODO Auto-generated method stub
		 for(Pair p:minHeap)
		 {
			 System.out.println(p);
		 }
		 Pair p=minHeap.get(0);
		 minHeap.set(0, minHeap.get(minHeap.size()-1));
		 minHeap.remove(minHeap.size()-1);
		 int currIndex=0;
		 int lc=2*currIndex+1;
		 int rc=2*currIndex+2;
		 while(lc<minHeap.size())
			 
		 {
			 Pair leftVal=minHeap.get(lc);
			 Pair currVal=minHeap.get(currIndex);
			  Pair rightVal=rc<minHeap.size()?minHeap.get(rc):new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
			  if(leftVal.wt<currVal.wt && leftVal.wt<=rightVal.wt)
			  {
				  minHeap.set(lc, currVal);
				  minHeap.set(currIndex, leftVal);
				  currIndex=lc;
			  }
			  else if(rightVal.wt<currVal.wt && rightVal.wt<leftVal.wt)
			  {
				  minHeap.set(rc, currVal);
				  minHeap.set(currIndex, rightVal);		
				  currIndex=rc;
			  }
			  else 
			  {
				  break;
			  }
			  lc=2*currIndex+1;
				 rc=2*currIndex+2;
					 
		 }
		 //System.out.println("min ele "+p);
		return p;
	}
	private static void insertIntoHeap(ArrayList<Pair> minHeap, int  node, ArrayList<Pair> arrayList, boolean[] visited) {
		// TODO Auto-generated method stub
		 //visited[node]=true;
		 //System.out.println("making node true visiteid "+node +"   val "+visited[node]);
		 for(Pair p:arrayList)
		 {
			 if(!visited[p.dest])
			 {
				 
				 if(minHeap.size()==0)
				 {
					 minHeap.add(p);
					 continue;
				 }
				 else
				 {
					 minHeap.add(p);
					 int currIndex=minHeap.size()-1;
					 int currParentIndex=(currIndex-1)/2;
					 while(currIndex>0)
					 {
						 if(minHeap.get(currParentIndex).wt>minHeap.get(currIndex).wt)
						 {
							 Pair temp=minHeap.get(currParentIndex);
							 minHeap.set(currParentIndex, minHeap.get(currIndex));
							 minHeap.set(currIndex, temp);
							 currIndex=currParentIndex;
							 currParentIndex=(currIndex-1)/2;;
						 }
						 else
						 {
							 break;
						 }
					 }
				 }
			 }
		 }
		
	}
	public static void intializeAdjacencyList(ArrayList<ArrayList<Integer>> b,ArrayList<ArrayList<Pair>> list)
	 {
		 
		 for(int i=0;i<b.size();i++)
		 {
			 int source=b.get(i).get(0);
			 int dest=b.get(i).get(1);
			 int wt=b.get(i).get(2);
			 list.get(source-1).add(new Pair(dest-1,wt));
			 list.get(dest-1).add(new Pair(source-1,wt));
			 
		 }
	 }

}

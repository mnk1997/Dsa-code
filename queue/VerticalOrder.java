package in.cdac.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;


public class VerticalOrder {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	class NodePosition
	{
		TreeNode node;
		int pos;
		NodePosition(TreeNode n,int pos)
		{
			this.node=n;
			this.pos=pos;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		Deque<NodePosition> dq=new LinkedList<>();
		HashMap<Integer,ArrayList<Integer>> distNode=new HashMap<>();
		int minDist=0;
		int maxDist=0;
	    dq.add(new NodePosition(A,0));
	    while(!dq.isEmpty())
	    {
	    	TreeNode currNode=dq.peek().node;
	    	int currPos=dq.peek().pos;
	    	if(currNode.left!=null)
	    	{
	    		dq.add(new NodePosition(currNode.left, currPos-1));
	    		if(minDist>currPos-1)
	    		{
	    			minDist=currPos-1;
	    		}
	    	}
	    	if(currNode.right!=null)
	    	{
	    		dq.add(new NodePosition(currNode.right, currPos+1));
	    		if(maxDist<currPos+1)
	    		{
	    			maxDist=currPos+1;
	    		}
	    	}
	    	if(dq.isEmpty()==false)
	    	{
	    		if(distNode.containsKey(currPos))
	    		{
	    			distNode.get(currPos).add(currNode.val);
	    		}
	    		else
	    		{
	    			ArrayList<Integer> list=new ArrayList<>();
	    			list.add(currNode.val);
	    			distNode.put(currPos,list);
	    		}
	    	    dq.poll();
	    	}
	    	
	    }
	    System.out.println("dist map size "+distNode.size());
	    //NOW FETCHING EACH VALUES FROM MAP
	     
		return fetchValuesFromMap(minDist,maxDist,distNode);
    }
	public ArrayList<ArrayList<Integer>> fetchValuesFromMap(int minDist,int maxDist,HashMap<Integer,ArrayList<Integer>> map)
	{
		System.out.println("called fetchValues");
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		for(int i=minDist;i<=maxDist;i++)
		{
			ArrayList<Integer> result=new ArrayList<>();
			for(int ele:map.get(i))
			{
				result.add(ele);
			}
			res.add(result);
			
		}
		System.out.println("res size"+res.size());
		
		return res;
	}

}


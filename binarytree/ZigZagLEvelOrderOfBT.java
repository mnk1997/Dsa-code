package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZagLEvelOrderOfBT {
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) {
		       val = x;
		       left=null;
		       right=null;
		      }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
	       Deque<TreeNode> dq=new LinkedList<>();
	       dq.add(A);
	       //0 :left to right 1:right to left;
	       //change direction after the last node of that level;
	       int currDirecn=1;
	       int lastNode=A.val;
	       ArrayList<ArrayList<Integer>> output=new ArrayList<>();
	       ArrayList<Integer> resForEachRow=new ArrayList<>();
	       while(!dq.isEmpty())
	       {
	    	   TreeNode  curr=dq.poll();
	    	   resForEachRow.add(curr.val);
	    	   if(currDirecn==0)
	    	   {
	    		   //insert left child first and then right child
	    		   if(curr.left !=null)
	    		   {
	    			   dq.add(curr.left);
	    		   }
	    		   if(curr.right!=null)
	    		   {
	    			   dq.add(curr.right);
	    		   }
	    		   
	    	   }
	    	   else
	    	   {
	    		   //insert right child first and then left child;
	    		   if(curr.right!=null)
	    		   {
	    			   dq.add(curr.right);
	    			   
	    		   }
	    		   if(curr.left !=null)
	    		   {
	    			   dq.add(curr.left);
	    		   }
	    		   
	    		   
	    	   }
	    	   if(lastNode==curr.val)
	    	   {
	    		  // resForEachRow.add(dq.po)
	    		   output.add(new ArrayList<>(resForEachRow));
	    		   resForEachRow=new ArrayList<>();
	    		   if(!dq.isEmpty())
	    		      lastNode=dq.peekLast().val;
	    		   currDirecn=1-currDirecn;
	    	   }
	    	   
	       }
	       
	       return output;

	    }
	  
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrderOne(TreeNode A) {
	       Deque<TreeNode> dq=new LinkedList<>();
	       dq.add(A);
	       //0 :left to right 1:right to left;
	       //change direction after the last node of that level;
	      // int currDirecn=1;
	       int lastNode=A.val;
	       ArrayList<ArrayList<Integer>> output=new ArrayList<>();
	       ArrayList<Integer> resForEachRow=new ArrayList<>();
	       while(!dq.isEmpty())
	       {
	    	   TreeNode  curr=dq.poll();
	    	   resForEachRow.add(curr.val);
	    	   if(curr.left !=null)
    		   {
    			   dq.add(curr.left);
    		   }
    		   if(curr.right!=null)
    		   {
    			   dq.add(curr.right);
    		   }
	    	   if(lastNode==curr.val)
	    	   {
	    		  // resForEachRow.add(dq.po)
	    		   output.add(new ArrayList<>(resForEachRow));
	    		   resForEachRow=new ArrayList<>();
	    		   if(!dq.isEmpty())
	    		      lastNode=dq.peekLast().val;
	    		  // currDirecn=1-currDirecn;
	    	   }
	    	   
	       }
	       for(int i=0;i<output.size();i++)
	       {
	    	   if(i%2==1)
	    	   {
	    		   Collections.reverse(output.get(i));
	    	   }
	       }
	       
	       return output;

	    }

}

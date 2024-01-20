package in.cdac.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class NextPointerBinaryTree {
	static public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public static void connect(TreeLinkNode root) {
		 Deque<TreeLinkNode> dq=new LinkedList<>();
		 TreeLinkNode curr=root;
		 dq.add(curr);
		 TreeLinkNode lastNodeOfLevel=root;
		 while(!dq.isEmpty() && curr!=null)
		 {
			 curr=dq.poll();
			 if(curr.left !=null)
				 dq.add(curr.left);
			 if(curr.right!=null)
				 dq.add(curr.right);
			 if(curr==lastNodeOfLevel)
			 {
				 lastNodeOfLevel=dq.peekLast();
				 
			 }
				
			 else
			 {
				 
				 curr.next=dq.peek();
			 }
				
		 }
		 
		 
	        
	    }

}

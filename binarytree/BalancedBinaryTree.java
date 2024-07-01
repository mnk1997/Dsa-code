package in.cdac.binarytree;

import java.util.Scanner;

public class BalancedBinaryTree {
	boolean isBalanced=true;
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
	 public int isBalanced(TreeNode A) {
	         findHeight(A);
	         if(isBalanced)
	        	 return 1;
	         else 
	        	 return 0;
	 }
	 public int findHeight(TreeNode A) {
		 //int res=1;
		 if(A==null)
			 return -1;
		 
		 int heightLeft=findHeight(A.left);
		 int heightRight=findHeight(A.right);
		 if(Math.abs(heightRight-heightLeft)>1)
			 isBalanced=false;
		 
			 return  Math.max(heightLeft, heightRight)+1;
		 
		 
	    }

}

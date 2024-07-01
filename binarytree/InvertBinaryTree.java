package in.cdac.binarytree;

public class InvertBinaryTree {
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
	//this method is using Recursion which will have some space complextiyt 
	
	 public TreeNode invertTree(TreeNode A) {
		 
		 if(A==null)
			 return null;
		
		TreeNode l= invertTree(A.left);
		TreeNode r= invertTree(A.right);
		  if(l==null && r==null)
		 {
			 return A;
			 
		 }
		 else if(l!=null &&r==null)
		 {
			 TreeNode temp=l;
			 A.left=r;
			 A.right=temp;
			 return A;
		 }
		 else if(r!=null && l==null)
		 {
			 TreeNode temp=r;
			 A.left=r;
			 A.right=null;
			 return A;
		 }
		 else
		 {
			 TreeNode temp=r;
			 A.right=l;
			 A.left=temp;
			 return A;
		 }
    }
		 
		 
		 
		 
		
	    }



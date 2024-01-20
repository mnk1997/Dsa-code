package in.cdac.binarytree;

import java.util.Arrays;
import java.util.List;

import in.cdac.binarytree.MorrisInOrderTraversal.TreeNode;

public class ConstructBSTFromSortedArray {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=sortedArrayToBST(Arrays.asList(1,2,3,4,5));
         inOrderTraversal(root);		

	}

	public static TreeNode sortedArrayToBST(final List<Integer> A) {
		if (A.size() == 0) {
			return null;
		}
		if (A.size() == 1) {
			TreeNode newNode = new TreeNode(A.get(0));
			return newNode;
		}
		else if(A.size()==2)
		{
			TreeNode newNode=new TreeNode(A.get(1));
			newNode.left=new TreeNode(A.get(0));
			return newNode;
		}
		else if(A.size()==3)
		{
			TreeNode newNode=new TreeNode(A.get(1));
			newNode.left=new TreeNode(A.get(0));
			newNode.right=new TreeNode(A.get(2));
			return newNode;
		}
		else
		{
			System.out.println("");
		}
		
		return constructBST(A, 0, A.size() - 1);

	}

	public static TreeNode constructBST(List<Integer> A, int start, int end) {
		//System.out.println("A.size" +A.size()+"  start "+start +" endd "+end);
		 if(start-end==0)
		{
			TreeNode newNode=new TreeNode(A.get(start));
			return newNode;
		}
		 else if (end <start || end >= A.size() || start >= A.size() || end < 0 || start < 0) {
				return null;
			} 
		int mid = start + ((end - start) / 2);
		//System.out.println("A.size" +A.size()+"  start "+start +" endd "+end +" mid "+mid);
		TreeNode newNode = new TreeNode(A.get(mid));
		newNode.left = constructBST(A, start, mid - 1);
		newNode.right = constructBST(A, mid + 1, end);

		return newNode;
	}

	public static void inOrderTraversal(TreeNode root) {
                      if(root==null)
                    	  return;
                     TreeNode curr=root;
                      while(curr!=null)
                      {
                    	  if(curr.left==null)
                    	  {
                    		  System.out.print("  "+ curr.val);
                    		  curr=curr.right;
                    	  }
                    	  else
                    	  {
                    		  TreeNode temp=curr.left;
                    		  while(temp.right!=null && temp.right!=curr)
                    		  {
                    			  temp=temp.right;
                    			  
                    		  }
                    		  if(temp.right==null)
                    		  {
                    			  temp.right=curr;
                    			  curr=curr.left;
                    		  }
                    		  else
                    		  {
                    			  temp.right=null;
                    			  System.out.print(" "+curr.val);
                    			  curr=curr.right;
                    		  }
                    	  }
                      }
	}

}

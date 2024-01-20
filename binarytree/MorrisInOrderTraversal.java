package in.cdac.binarytree;

import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class MorrisInOrderTraversal {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) {
		       val = x;
		       left=null;
		       right=null;
		      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> solve(TreeNode A) {
		
		ArrayList<Integer> nodes=new ArrayList<>();
		if(A==null)
			return nodes;
		TreeNode currNode=A;
		while(currNode!=null)
		{
			if(currNode.left==null)
			{
				nodes.add(currNode.val);
				currNode=currNode.right;
			}else
			{
				TreeNode temp=currNode.left;
				while(temp.right!=null && temp.right!=currNode)
				{
					temp=temp.right;
				}
				if(temp.right==null)
				{
					temp.right=currNode;
					currNode=currNode.left;
				}
				else
				{
					temp.right=null;
					nodes.add(currNode.val);
					currNode=currNode.right;
				}
			}
		}
		
		
		
		
		
		
		return nodes;
    }
    
}
}

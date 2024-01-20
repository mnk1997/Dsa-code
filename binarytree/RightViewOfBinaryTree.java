package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import in.cdac.binarytree.LevelOrderTraversal.TreeNode;

public class RightViewOfBinaryTree {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ArrayList<Integer> solve(TreeNode A) {
		 Deque<TreeNode> nodes = new LinkedList<>();
			//ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			nodes.add(A);
			TreeNode lastNodeOfLevel = A;
			ArrayList<Integer> result = new ArrayList<>();
			while (!nodes.isEmpty()) {
				TreeNode currNode=nodes.peek();
				if (currNode.left != null)
					nodes.add(currNode.left);
				if (currNode.right != null)
					nodes.add(currNode.right);
				if (currNode == lastNodeOfLevel) {
					result.add(nodes.poll().val);
		            	 
					//res.add(result);
					//result=new ArrayList<>();
					lastNodeOfLevel = nodes.peekLast();

				}
	            else
	            {
	                if(!nodes.isEmpty())
				       nodes.poll();
	            }
			}
			return result;
	    }

}

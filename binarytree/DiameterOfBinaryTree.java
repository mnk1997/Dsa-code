package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}

		public static TreeNode setTreeNode(ArrayList<Integer> list) {
			System.out.println("list size" + list.size());
			TreeNode head = null;
			Queue<TreeNode> q = new LinkedList<>();
			for (int i = 0; i < list.size(); i += 2) {

				if (i == 0) {
					head = new TreeNode(list.get(0));
					if (list.get(i + 1) == -1)
						head.left = null;
					else {
						head.left = new TreeNode(list.get(i + 1));
						q.add(head.left);
					}
					if (list.get(i + 2) == -1)
						head.right = null;
					else {
						head.right = new TreeNode(list.get(i + 2));
						q.add(head.right);
					}

				} else {
					if (q.isEmpty()) {
						break;
					}
					TreeNode curr = q.poll();
					if (i + 1 >= list.size()) {
						curr.left = null;
						curr.right = null;
						continue;
					}

					if (i + 1 < list.size() && list.get(i + 1) == -1)
						curr.left = null;
					else {
						curr.left = new TreeNode(list.get(i + 1));
						q.add(curr.left);
					}
					if (i + 2 >= list.size()) {
						curr.right = null;
						continue;
					}
					if (i + 2 < list.size() && list.get(i + 2) == -1)
						curr.right = null;
					else {
						curr.right = new TreeNode(list.get(i + 2));
						q.add(curr.right);
					}

				}
			}
			return head;
		}
	}
    static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A=TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(26,-1,-1)));
		
		System.out.println("diameter "+solve(A));
	

	}
	public static int solve(TreeNode A) {
		
		if(A==null)
			return 0;
		findDiameter(A);
		System.out.println("ans "+ans);
		return ans;
		/*
		 * int numOfEdgesOnLeftPart=calculateFarthestNodeFromThis(A.left)+1; int
		 * numOfEdgesOnRightPart=calculateFarthestNodeFromThis(A.right)+1;
		 * if(numOfEdgesOnLeftPart+numOfEdgesOnRightPart > ans)
		 * ans=numOfEdgesOnRightPart+numOfEdgesOnLeftPart;
		 */
		
		
    }
	public static int findDiameter(TreeNode A)
	{
		if(A==null)
			return 0;
		
		int left=0;
		int right=0;
		if(A.left!=null)
		{
			left=1+findDiameter(A.left);
		}
		if(A.right!=null)
		{
			right=1+findDiameter(A.right);
		}
		 if(left+right>ans)
			 ans=left+right;
		 
		 return (left>right?left:right);
	}

}

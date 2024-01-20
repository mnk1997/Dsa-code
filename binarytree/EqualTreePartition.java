package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import in.cdac.binarytree.RecoverBSTOne.TreeNode;

public class EqualTreePartition {
	static boolean result = false;

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

	public static void main(String[] args) {
		TreeNode A1=TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(999999518,999999649,-1,999999906,999999844,999999529,999999514,999999806,999999654,-1,-1,999999900,999999963,999999608,-1,999999830,-1,999999560,-1,-1,-1,-1,999999632,-1,999999855,999999508,-1,-1,-1,-1,-1,999999669,-1,-1,999999677,-1,999999886,999999523,999999657,-1,-1,-1,999999974,-1,-1)));
		// TODO Auto-generated method stub
		 TreeNode A=TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(999999518,999999649,-1,999999906,999999844,999999529,999999514,999999806,999999654,-1,-1,999999900,999999963,999999608,-1,999999830,-1,999999560,-1,-1,-1,-1,999999632,-1,999999855,999999508,-1,-1,-1,-1,-1,999999669,-1,-1,999999677,-1,999999886,999999523,999999657,-1,-1,-1,999999974,-1,-1)));
		//TreeNode A=TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(331,36,-1,86,-1,155,-1,372,-1,-1,485,-1,23,-1,478,358,292,-1,-1,263,305,451,339,-1,-1,161,467,-1,305,42,360,-1,408,-1,-1,94,259,-1,-1,189,470,31,-1,331,-1,-1,367,81,29,311,-1,-1,99,-1,-1,-1,-1,-1,50,10,12,38,-1,-1,186,437,-1,-1,-1,-1,-1,-1,470,-1,350,195,68,115,31,248,90,-1,93,493,-1,53,447,17,-1,331,66,-1,242,-1,-1,-1,-1,-1,-1,-1,-1,-1,284,9,-1,468,331,-1,-1,438,-1,220,373,-1,170,-1,-1,23,15,-1,-1,-1,-1,-1,398,228,14,129,399,79,115,189,25,-1,28,-1,499,356,-1,-1,135,316,329,229,234,-1,344,-1,-1,-1,194,51,341,225,49,-1,-1,447,469,-1,273,-1,-1,-1,392,-1,142,476,-1,53,109,-1,-1,233,-1,199,-1,232,-1,-1,142,-1,-1,305,-1,271,-1,-1,321,-1,-1,177,-1,-1,255,40,-1,158,207,-1,-1,461,-1,3,-1,-1,-1,347,-1,-1,-1,-1,283,428,-1,116,283,-1,115,500,261,143,360,-1,248,-1,-1,124,-1,-1,-1,-1,302,286,-1,208,-1,12,186,10,-1,-1,-1,473,-1,488,-1,-1,-1,78,-1,272,81,457,-1,-1,299,221,-1,160,371,-1,76,-1,-1,327,97,-1,424,196,54,-1,-1,260,171,414,79,80,-1,471,251,-1,0,-1,-1,-1,-1,132,330,460,224,18,-1,-1,-1,-1,-1,-1,486,3,-1,410,211,-1,431,-1,135,322,-1,-1,237,273,-1,-1,-1,-1,416,86,-1,436,283,117,-1,-1,275,-1,303,-1,223,-1,341,28,-1,60,-1,-1,23,81,244,91,-1,-1,-1,377,256,86,-1,340,-1,-1,355,409,74,154,-1,216,385,-1,112,-1,366,-1,-1,124,-1,260,-1,137,-1,4,193,-1,499,-1,330,31,-1,380,-1,-1,78,-1,-1,-1,-1,-1,442,-1,75,90,-1,-1,178,52,-1,-1,-1,38,-1,405,-1,-1,-1,439,-1,-1,12,494,-1,-1,213,-1,-1,192,-1,9,108,68,352,150,216,-1,437,-1,-1,102,193,222,-1,216,-1,-1,-1,-1,-1,320,244,-1,451,36,-1,-1,469,481,-1,485,472,-1,-1,108,461,-1,-1,287,-1,-1,497,259,-1,-1,283,-1,462,-1,403,-1,413,201,-1,-1,233,-1,-1,-1,-1,-1,-1,163,-1,-1,230,51,-1,-1,-1,238,-1,-1,-1,314,-1,-1,-1,251,-1,269,230,-1,301,-1,-1,37,-1,-1,-1,-1,97,198,-1,-1,-1)));
		/*
		 * TreeNode A = TreeNode.setTreeNode(new ArrayList<Integer>( Arrays.asList(204,
		 * 81, 120, 322, -1, 190, 455, -1, -1, 366, -1, -1, 236, -1, 224, 313, 456, -1,
		 * -1, 244, 315, -1, 146, 284, -1, 319, -1, 150, 268, -1, 132, 18, -1, -1, -1,
		 * -1, 263, 9, -1, -1, -1, 208, -1, 251, -1, 350, 61, -1, -1, 429, -1, -1, -1,
		 * 139, 123, -1, -1, -1, -1)));
		 */

		System.out.println("Answer " + solve(A1));
	}

	public static int solve(TreeNode A) {
		if (A == null)
			return 0;

		long totalSum = findTotalSum(A);
		if(totalSum%2!=0)
			return 0;
		
		Deque<TreeNode> q=new LinkedList<>();
		//q.add(A);
		if(A.left!=null)
			q.add(A.left);
		if(A.right!=null)
			q.add(A.right);
		System.out.println("totalSum "+totalSum);
		while(!q.isEmpty())
		{
			TreeNode curr=q.poll();
			long subTreeVal=findTotalSum(curr);
			System.out.println("subTree Sym : "+subTreeVal);
			if(subTreeVal==(totalSum/2))
				return 1;
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
			
			
		}
		 
			 return 0;
		
	}


	public static long findTotalSum(TreeNode A) {

		if (A == null)
			return 0;

	  return A.val+findTotalSum(A.left)+findTotalSum(A.right);
	}

}

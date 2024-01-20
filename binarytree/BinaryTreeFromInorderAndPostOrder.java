package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;

import in.cdac.binarytree.RightViewOfBinaryTree.TreeNode;

public class BinaryTreeFromInorderAndPostOrder {
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
		int[] arr=new int[5];
		//Arrays.copyOfRange(arr, startIndex, endIndex);
		// TODO Auto-generated method stub
		//buildTree(new ArrayList<>(Arrays.asList(2,1,3)),new ArrayList<>(Arrays.asList(2,3,1)));
		buildTree(new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)));
	}
	  public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		  System.out.println(A.size()+" is A size"+ " B size "+B.size());
		  if(A.isEmpty() || B.isEmpty())
		  {
			  return null;
		  }
		  TreeNode node=new TreeNode(B.get(B.size()-1));
		  System.out.println("Root for this funciton "+node.val);
		  if(A.size()==1)
		  {
			 
			  return node;
		  }
		  
		  int nodeIndxInA=A.indexOf(node.val);
		//  System.out.println("called node"+node.val);
		   node.left=buildTree(new ArrayList<>(A.subList(0,nodeIndxInA)),new ArrayList<>(B.subList(0, nodeIndxInA)));
		   if(node.left!=null)
		     System.out.println("node left"+node.left.val);
		   node.right=buildTree(new ArrayList<>(A.subList(nodeIndxInA+1,A.size())),new ArrayList<>(B.subList(nodeIndxInA,B.size()-1)));
		   if(node.right !=null)
		     System.out.println("node right"+node.right.val);
		   return node;
	    }

}

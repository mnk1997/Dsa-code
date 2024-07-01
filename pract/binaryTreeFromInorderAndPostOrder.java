package in.cdac.pract;

import java.util.ArrayList;

//import in.cdac.binarytree.BinaryTreeFromInorderAndPostOrder.TreeNode;

public class binaryTreeFromInorderAndPostOrder {
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
        int[] inorder= {9,3,15,20,7};
        int[] postorder= {9,15,7,20,3};
        System.out.println("build tree "+buildTree(inorder,postorder));
	}
	 public static TreeNode buildTree(int[] inorder, int[] postorder) {
	       
	        if(inorder.length != postorder.length)
	           return null;
	        if(inorder.length==1 && postorder.length==1)
	              return new TreeNode(postorder[0]);
	        ArrayList<Integer> in=convertToList(inorder);
	        ArrayList<Integer> po=convertToList(postorder);
	        TreeNode root=constructBinaryTree(in,po);
	        return root;
	        

	        
	    }
	    public static TreeNode constructBinaryTree(ArrayList<Integer> inOrder,ArrayList<Integer> postOrder)
	    {
	    	System.out.println("------------------------------------------------------------------------");
	    	System.out.println("called for inorder size "+inOrder.size()+"   postOrder size "+postOrder.size());
	        if(inOrder.size()==0 || postOrder.size()==0)
	             return null;
	        if(inOrder.size()==1 || postOrder.size()==1)
	        {
	            return new TreeNode(postOrder.get(0));
	        }

	        int rootValue=postOrder.get(postOrder.size()-1);
	        int indexOfRootInInOrder=inOrder.indexOf(rootValue);
	        TreeNode root=new TreeNode(rootValue);
	        root.left=constructBinaryTree(new ArrayList<>(inOrder.subList(0,indexOfRootInInOrder)),new ArrayList<>(postOrder.subList(0,indexOfRootInInOrder)));
	        root.right=constructBinaryTree(new ArrayList<>(inOrder.subList(indexOfRootInInOrder+1,inOrder.size())),new ArrayList<>(postOrder.subList(indexOfRootInInOrder,postOrder.size()-1)));
   System.out.println("------------------------------------------------------------------");
	        return root;

	        
	    }
	    public static ArrayList<Integer> convertToList(int[] arr)
	    {
	         ArrayList<Integer>list=new ArrayList<>();
	           for(int ele:arr)
	        {
	            list.add(ele);
	        }
	        return list;
	    }

}

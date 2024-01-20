package in.cdac.binarytree;
import java.util.Arrays;
import in.cdac.binarytree.BinaryTreeFromInorderAndPostOrder.TreeNode;

public class BinaryTreeFromInorderPreOrder {
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
		int[] preorder= {3,9,20,15,7};
		int[] inorder= {9,3,15,20,7};
		buildTree(preorder,inorder);

	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
	if(inorder.length==0 || preorder.length==0)
	{
		System.out.println("inorder len"+inorder.length+" preorder len"+preorder.length);
		return null;
	}
        
        TreeNode node=new TreeNode(preorder[0]);

      if(inorder.length==1)
      {
    	  System.out.println("return as len 1 :"+node.val);
          return node;
      }
      System.out.println("node is"+node.val+" inorder len"+inorder.length);
		  int nodeIndxInA=findIndexOfEle(node.val,inorder);
		  System.out.println("node indx in inorder" + nodeIndxInA+" for value"+node.val);
        if(nodeIndxInA==-1)
           return null;
		//  System.out.println("called node"+node.val);
            System.out.println("calling left");
		   node.left=buildTree(Arrays.copyOfRange(preorder,1,nodeIndxInA+1),Arrays.copyOfRange(inorder,0, nodeIndxInA));
		   System.out.println("caalling right");
		   node.right=buildTree(Arrays.copyOfRange(preorder,nodeIndxInA+1,preorder.length),Arrays.copyOfRange(inorder,nodeIndxInA+1,inorder.length));
		   return node;

      
  }
  public static int findIndexOfEle(int ele,int[] inorder)
  {
      for(int i=0;i<inorder.length;i++)
      {
           if(inorder[i]==ele)
               return i;
      }
      System.out.println("ele which was not founded "+ele +" inorder.length-->"+inorder.length);
      for(int ee:inorder)
      {
    	  System.out.println(ee);
      }
      return -1;
  }

}

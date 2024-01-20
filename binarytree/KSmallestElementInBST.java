package in.cdac.binarytree;

public class KSmallestElementInBST {
  static class TreeNode {
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
	 public int kthsmallest(TreeNode A, int B) {
		int k=0;
		int ans=Integer.MAX_VALUE;
		TreeNode curr=A;
		while(k!=B && curr!=null)
		{
			if(curr.left==null)
			{
				k++;
				ans=curr.val;
				curr=curr.right;
			}
			else
			{
				TreeNode pred=curr.left;
				while(pred.right!=null && pred.right!=curr)
				{
					pred=pred.right;
				}
				if(pred.right==null)
				{
					pred.right=curr;
					curr=curr.left;
				}
				else
				{
					pred.right=null;
					k++;
					ans=curr.val;
					curr=curr.right;
				}
			}
		}
		
		if(k!=B)
			return -1;
		return ans;
	    }

}

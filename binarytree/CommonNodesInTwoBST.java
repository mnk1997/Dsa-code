package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class CommonNodesInTwoBST {
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
		// TODO Auto-generated method stub
		
		
		System.out.println("Ans"+ solve(TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(25,18,30,14,21,28,33,6,17,20,22,27,29,31,43,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1))),
				TreeNode.setTreeNode(new ArrayList<>(Arrays.asList(18,11,24,6,14,21,28,4,7,12,16,19,22,25,31,-1,5,-1,9,-1,13,15,17,-1,20,-1,23,-1,26,30,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)))));
      System.out.println("-------------------------");
	}public static int solve(TreeNode A, TreeNode B) {
        //first arrange all the nodes in ascending order of first bst
        ArrayList<Integer> nodesPresentInBst=new ArrayList<>();
       int size1= inOrderTraversalOfBST(A,nodesPresentInBst);
      
        ArrayList<Integer> nodesPresentInSecondBst=new ArrayList<>();
       int size2= inOrderTraversalOfBST(B,nodesPresentInSecondBst);
     
        //System.out.println("size 1 "+size1+" size 2 "+size2);
        //int endIdx=size1<size2?size1:size2;
         long sum=0;
       int ptr1=0;
       int ptr2=0;
       while(ptr1<size1 && ptr2<size2)
       {
    	  
    	   if(nodesPresentInBst.get(ptr1)==nodesPresentInSecondBst.get(ptr2))
    	   {
    		   System.out.println("Hurrayy");
    		   sum=(sum+nodesPresentInBst.get(ptr1))%1000000007;
    		   ptr1++;
    		   ptr2++;
    	   }
    	   else if(nodesPresentInBst.get(ptr1) < nodesPresentInSecondBst.get(ptr2))
    	   {
    		   ptr1++;
    	   }
    	   else
    	   {
    		   ptr2++;
    	   }
       }
        return (int) (sum%1000000007);
    }
    public static int inOrderTraversalOfBST(TreeNode a,ArrayList<Integer> nodesInAscOrder)
    {
        if(a==null)
          return 0;
       int leftSize= inOrderTraversalOfBST(a.left,nodesInAscOrder);
        nodesInAscOrder.add(a.val);
      int rightSize= inOrderTraversalOfBST(a.right,nodesInAscOrder);
      return 1+leftSize+rightSize;
        
    }

}

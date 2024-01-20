package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import in.cdac.binarytree.RecoverBSTOne.TreeNode;

public class DeleteANodeInBST {
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
		TreeNode A=TreeNode.setTreeNode(new ArrayList<Integer>(Arrays.asList(3,1,-1,-1,2,-1,-1 )));  //2,1,3,-1,-1,-1,-1
		//4 3 1 2 6 5 8 
		System.out.println("Before Deleting");
		System.out.println();
		inOrderTraversal(A);
		System.out.println();
		preOrderTraversal(A);
		System.out.println("----------------------------------------------------------------");
		 A=solve(A,3);
		 System.out.println();
		 System.out.println("Inorder Traversal ----------------------------------------------------------------------"); 
		 inOrderTraversal(A);
		 System.out.println();
		 System.out.println("PreOrder Traversal ----------------------------------------------------------------------");
		 preOrderTraversal(A);

	}
	public static TreeNode solve(TreeNode A, int B) {
        if(A==null)
           return null;
        //check for root node 
        if(A.val==B)
        {
        	System.out.println(" root node");
        	if(findChildOfNodeToBeDeleted(A, B)==1)
        	{
        		if(A.left==null)
        			A=A.right;
        		else
        			A=A.left;
        		
        		
        		return A;
        	}
        	
            //search for inorder predecessor
            if(A.left!=null)
            {
               TreeNode temp=A.left;
               TreeNode prev=A;
               while(temp.right!=null)
               {
                   prev=temp;
                   temp=temp.right;
                   
               }
               int data=temp.val;
               A.val=data;
               temp.val=B;
               if(temp.left==null && temp.right==null)
               {
            	   if(prev.left==temp)
            		   prev.left=null;
            	   else if(prev.right==temp)
            		   prev.right=null;
               }
               //for 1 child
               else
               {
            	  int child= findChildOfNodeToBeDeleted(temp, B);
            	  System.out.println("child is"+child);
            	  if(child==1)
            	  {
            		  if(prev.left==temp)
                		  prev.left=deleteIfOneChild(temp, B);
                	  else
                		  prev.right=deleteIfOneChild(temp, B);
            	  }
            	  
            	 
               }
            }
            else
            {
                A=A.right;
            }
        }

        else{
        	
        		
            int child=findChildOfNodeToBeDeleted(A,B);
            System.out.println("child "+child);
           if(child==0)
           {
        	   System.out.println("zero");
        	   A=deleteIfZeroChild(A, B);
           }
           else if(child==1)
           {
        	   System.out.println("one");
        	   A=deleteIfOneChild(A, B);
        	   
           }
           else if(child==2)
           {
        	   System.out.println("two");
        	   A=deleteIfTwoChild(A, B);
           }
         
        	
           
        }
        return A;
        
    }
    public static int findChildOfNodeToBeDeleted(TreeNode root,int B)
    {
    	System.out.println("callled tofind delete node");
                 TreeNode curr=root;
                 int child =0;
                 while(curr!=null)
                 {
                     if(curr.val==B)
                     {
                         if(curr.left!=null)
                             child+=1;
                         if(curr.right!=null)
                              child+=1;
                         
                         return child;
                     }
                     else if(curr.val<B)
                     {
                         curr=curr.right;
                     }
                     else{
                         curr=curr.left;
                     }
                 }
                 return -1;
    }
    public static TreeNode deleteIfZeroChild(TreeNode root,int B)
    {
    	System.out.println("For zero child");
        TreeNode curr=root;
        TreeNode prev=null;
        while(curr.val!=B)
        {
            prev=curr;
            if(curr.val>B)
            {
               // prev=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(prev.left==curr)
            prev.left=null;
        else
             prev.right=null;

        return root;
    }
     public static TreeNode deleteIfOneChild(TreeNode root,int B)
    {
    	 System.out.println("For single chld");
        TreeNode curr=root;
        TreeNode prev=null;
        if(curr.val==B)
        {
        	System.out.println("rooot is the same");
        	if(curr.right!=null)
        	{
        		return curr.right;
        	}
        	else
        	{
        		return curr.left;
        	}
        	//return root;
        }
        while(curr.val!=B)
        {
            prev=curr;
            if(curr.val>B)
            {
               // prev=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(prev.left==curr)
            {
                if(curr.left!=null)
                   prev.left=curr.left;
                else 
                  prev.left=curr.right;
            }
        else
           {
               if(curr.left!=null)
                   prev.right=curr.left;
                else 
                  prev.right=curr.right;
           }

        return root;
    }
     public static TreeNode deleteIfTwoChild(TreeNode root,int B)
    {
    	 //System.out.println("For two child");
    	 System.out.println("Deleting for two childdd");
        TreeNode curr=root;
       // TreeNode prev=null;
        while(curr.val!=B)
        {
           // prev=curr;
            if(curr.val>B)
            {
               // prev=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(curr.left!=null)
            {
               TreeNode temp=curr.left;
               TreeNode prev=curr;
               while(temp.right!=null)
               {
                   prev=temp;
                   temp=temp.right;
                   
               }
               int data=temp.val;
               curr.val=data;
               temp.val=B;
               //for 0 child
               if(temp.left==null && temp.right==null)
               {
            	   if(prev.left==temp)
            		   prev.left=null;
            	   else if(prev.right==temp)
            		   prev.right=null;
               }
               //for 1 child
               else
               {
            	  int child= findChildOfNodeToBeDeleted(temp, B);
            	  System.out.println("child is"+child);
            	  if(child==1)
            	  {
            		  if(prev.left==temp)
                		  prev.left=deleteIfOneChild(temp, B);
                	  else
                		  prev.right=deleteIfOneChild(temp, B);
            	  }
            	  
            	 
               }
             
				/*
				 * if(prev.left==temp) prev.left=null; else prev.right=null;
				 */
             //  prev.right=temp.right;
               //temp=null;
            }
        else
        {
            curr=curr.right;
        }
           
        return root;
    }
     public static void inOrderTraversal(TreeNode A)
     {
    	 if(A==null)
    		 return;
    	    inOrderTraversal(A.left);
    	    System.out.print(" "+A.val);
    	    inOrderTraversal(A.right);
    	    
     }
     public static void preOrderTraversal(TreeNode A)
     {
    	 if(A==null)
    		 return;
    	    System.out.print(" "+A.val);
    	    preOrderTraversal(A.left);
    	   
    	    preOrderTraversal(A.right);
    	    
     }

}

package in.cdac.LinkedList;

import java.util.ArrayList;

//Given a linked list where every node represents a linked list and contains two pointers of its type:
/*
Pointer to next node in the main list (right pointer)
Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.

1 <= Total nodes in the list <= 100000

1 <= Value of node <= 109



Input Format
The only argument given is head pointer of the doubly linked list.



Output Format
Return the head pointer of the Flattened list.
//challenges head pointer


Example Input
Input 1:

   3 -> 4 -> 20 -> 20 ->30
   |    |    |     |    |
   7    8   22    20   31
   |               |    |
   7               28   39
   |               |
  11               39
Input 2:

   2 -> 4 
   |    |       
   7    11    
   |            
   7


Example Output
Output 1:

 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 
Output 2:

 2 -> 4 -> 7 -> 7 -> 11*/
public class FlattenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	class ListNode {
	    int val;
	    ListNode right, down;
	    ListNode(int x) {
	        val = x;
	        right = down = null;
	    }
	}
	//approach 1:
//	        make another linked list having all the down nodes
//	then compare with two head pointers 
	 //problem in approach 1: this method doesn't guaranteees that the other(new created) list is sorted.
	ListNode flatten(ListNode root) {  
		ListNode headSorted=null;
		ArrayList<Integer> minHeap=new ArrayList<>();
		//initialize minHeap with all the values in linkedlist
		initializeMinHeap(minHeap,root);
		//build minHeap:O(N+M)
		buildMinHeap(minHeap);
		//we will use the below mentioned variable tail for adding into new list
		
		ListNode tail=null;
		//fetch the next smallest element till the minHeap becomes empty
		
		while(minHeap.size()>0)
		{
			int minEle=getMin(minHeap);
			ListNode newNode=new ListNode(minEle);
			if(headSorted==null)
			{
				headSorted=newNode;
				tail=headSorted;
				tail=headSorted;
			}
			else
				
			{
				tail.right=newNode;
				tail=tail.right;
			}
		}
		
		
		
		
		
		
		return headSorted;
	    
	}
	private int getMin(ArrayList<Integer> minHeap) {
	   int minEle=minHeap.get(0);
	   int lastChildVal=minHeap.get(minHeap.size()-1);
	   minHeap.set(0, lastChildVal);
	   minHeap.remove(minHeap.size()-1);
	   int currIdx=0;
	   int lc=2*currIdx+1;
	   int rc=2*currIdx+2;
	   while(lc<minHeap.size())
	   {
		   int lVal=minHeap.get(lc);
			int rVal=rc<minHeap.size()?minHeap.get(rc):Integer.MAX_VALUE;
			int currVal=minHeap.get(currIdx);
			if(lVal<currVal && lVal<=rVal)
			{
				minHeap.set(lc, currVal);
				minHeap.set(currIdx, lVal);
				currIdx=lc;
			}
			else if(rVal<currVal && rVal<lVal)
			{
			      minHeap.set(rc,currVal);
			      minHeap.set(currIdx, rVal);
			      currIdx=rc;
			}
			else
			{
				break;
			}
			
			lc=2*currIdx+1;
			 rc=2*currIdx+2;
	   }
	   
		return minEle;
	}
	private void buildMinHeap(ArrayList<Integer> minHeap) {
		int lastChildIndex=minHeap.size()-1;
		int lastChildParent=(lastChildIndex)/2;
		for(int i=lastChildParent;i>=0;i--)
		{
			int lc=2*lastChildParent+1;
			int rc=2*lastChildParent+2;
			while(lc<minHeap.size())
			{
				int lVal=minHeap.get(lc);
				int rVal=rc<minHeap.size()?minHeap.get(rc):Integer.MAX_VALUE;
				int currVal=minHeap.get(lastChildParent);
				if(lVal<currVal && lVal<=rVal)
				{
					minHeap.set(lc, currVal);
					minHeap.set(lastChildParent, lVal);
					lastChildParent=lc;
				}
				else if(rVal<currVal && rVal<lVal)
				{
				      minHeap.set(rc,currVal);
				      minHeap.set(lastChildParent, rVal);
				      lastChildParent=rc;
				}
				else
				{
					break;
				}
				
				lc=2*lastChildParent+1;
				 rc=2*lastChildParent+2;
			}
			
		}
		
		
		
	}
	private void initializeMinHeap(ArrayList<Integer> minHeap, ListNode root) {
		// TODO Auto-generated method stub
		ListNode temp=root;
		while(temp!=null)
		{
			minHeap.add(temp.val);
			ListNode downPtr=temp.down;
			while(downPtr!=null)
			{
				minHeap.add(downPtr.val);
				downPtr=downPtr.down;
			}
			temp=temp.right;
		}
		
	}

}

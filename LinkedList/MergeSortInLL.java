package in.cdac.LinkedList;

import in.cdac.pract.MergeLinkedList.ListNode;

public class MergeSortInLL {
	static class ListNode {
	      public int val;
	     public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public ListNode sortList(ListNode A) {
	       if(A==null || A.next==null )
	             return A;
	        ListNode mid=findMiddleNode(A);
	        ListNode first=sortList(A);
	        ListNode second=sortList(mid.next);
	        mid.next=null;
	        return merge(first,second);
	        
	    }

	    public ListNode findMiddleNode(ListNode head)
	    {
	        ListNode fastPtr=head;
	        ListNode slowPtr=head;
	        while(fastPtr != null)
	        {
	            slowPtr=slowPtr.next;
	            fastPtr=fastPtr.next.next;
	        }
	        return slowPtr;
	    }

	    public ListNode merge(ListNode first,ListNode second)
	    {
	        if(first == null )
	           return second;
	        if(second == null)
	            return first;
	        
	        ListNode head=null;
	        ListNode temp1=first;
	        ListNode temp2=second;
	        if(temp1.val<=temp2.val)
	           {
	               head=first;
	               temp1=temp1.next;
	           }
	        else
	        {
	            head=second;
	            temp2=temp2.next;
	        }
	         ListNode curr=head;
	        while(temp1 != null && temp2 !=null)
	        {
	                 if(temp1.val <= temp2.val)
	                 {
	                     curr.next=temp1;
	                     temp1=temp1.next;
	                     
	                 }
	                 else{
	                     curr.next=temp2;
	                     temp2=temp2.next;
	                 }

	                 curr=curr.next;
	                 curr.next=null;

	        }

	        return head;
	    }

}

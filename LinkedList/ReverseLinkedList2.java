package in.cdac.LinkedList;

import in.cdac.LinkedList.ReverseKNodeAtTime.ListNode;

public class ReverseLinkedList2 {
	static class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp1 = new ListNode(2);
		ListNode temp2 = new ListNode(3);
		ListNode temp3 = new ListNode(4);
		ListNode temp4 = new ListNode(5);
		ListNode temp5 = new ListNode(6);
		head.next = temp1;
		temp1.next = temp2;
		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;

		ListNode head1 = reverseBetween(head, 2,4);
		while (head1 != null) {
			System.out.print(head1.val + " ");
			head1 = head1.next;
		}
		// TODO Auto-generated method stub

	}
	 public static ListNode reverseBetween(ListNode A, int B, int C) {
		 ListNode start=getStartNode(A,B);
		 ListNode end=getEndNode(A,C);
		 reverseList(start,end);
		 return A;
	    }
	 public static ListNode getStartNode(ListNode A, int B) {
			if (A == null)
				return null;
			ListNode temp = A;
			for (int i = 1; i <B; i++) {
				if (temp.next != null)
					{
					   temp = temp.next;
					}
				else
				{
				System.out.println("In else part "+temp.val);
					
					break;
				}
					
			}
			return temp;
		}
	 public static ListNode getEndNode(ListNode A, int B) {
			if (A == null)
				return null;
			ListNode temp = A;
			for (int i = 1; i <B; i++) {
				if (temp.next != null)
					{
					   temp = temp.next;
					}
				else
				{
				System.out.println("In else part "+temp.val);
					
					break;
				}
					
			}
			return temp;
		}
	 public static void reverseList(ListNode start, ListNode end) {
			if(start==null)
				return ;
			//System.out.println("start "+start.val+" end"+end.val);
			ListNode st = start;
			ListNode en = end;
			while (en != null && st.next != en) {

				ListNode temp = st;
				//System.out.println("temp data" + temp.val);
				while (temp != null && temp.next != en) {
					temp = temp.next;
				}
				int tempData=st.val;
				System.out.println("St before "+st.val +" corresponding en  "+en.val);
				st.val = en.val;
				en.val=tempData;
				en = temp;
				
				st = st.next;
			
				//System.out.println("St after "+st.val);
			}
			if(st!=null && en!=null)
			{
				 int tempData=st.val;
					st.val=en.val;
					en.val=tempData;
			}
			  
			

		}

}

package in.cdac.LinkedList;

import java.util.List;
import java.util.Stack;

/*Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.*/
public class PallindromeList {
	static class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		ListNode temp1=new ListNode(2);
		ListNode temp2=new ListNode(3);
		ListNode  temp3=new ListNode(3);
		ListNode temp4=new ListNode(2);
		ListNode temp5=new ListNode(1);
		ListNode temp6=new ListNode(0);
		
		head.next=temp1;
		temp1.next=temp2;
		temp2.next=temp3;
		temp3.next=temp4;
		temp4.next=temp5;
		temp5.next=temp6;
		
		temp6.next=null;
   System.out.println(lPalin(head));
	}
	  public static int lPalin(ListNode A) {
		  Stack<Integer> lst=new Stack<>();
		  ListNode slowPtr=A;
		  ListNode fastPtr=A;
		  lst.push(A.val);
		  while(fastPtr.next!=null && fastPtr.next.next!=null)
		  {
			 
			  slowPtr=slowPtr.next;
			  lst.push(slowPtr.val);
			  fastPtr=fastPtr.next.next;
		  }
		  System.out.println("size of stack"+lst.size());
		  if(fastPtr!=null)
		     System.out.println("FAst ptr value"+fastPtr.val);
		  System.out.println("Slow ptr value"+slowPtr.val +" next val"+slowPtr.next.val);
		  if(fastPtr.next!=null)
		         slowPtr=slowPtr.next;
		  while(slowPtr!=null)
		  {
			  if(lst.isEmpty()==false && lst.peek()==slowPtr.val)
			  {
				  System.out.println("Poping "+lst.peek());
				  lst.pop();
			  }
			  else
			  {
				  System.out.println("returning 0 when "+slowPtr.val);
				  return 0;
			  }
			  slowPtr=slowPtr.next;
		  }
		return 1;
		  
	    }
	

}

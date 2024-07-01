package in.cdac.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class DoubleNumberRepresentedAsLL {
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(9);
		ListNode first=new ListNode(9);
		ListNode second=new ListNode(6);
		head.next=first;
		first.next=second;
		ListNode temp=doubleIt(head);
		while(temp!=null)
		{
			System.out.print(temp.val+" ");
			temp=temp.next;
		}

	}
    public static ListNode doubleIt(ListNode head) {
    	  if(head==null)
    		  return null;
        Deque<Integer> dq=new LinkedList<>();
        ListNode temp=head;
       
        while(temp!=null)
        {
        	dq.push(temp.val);
        	temp=temp.next;
        	//System.out.println("dq element added "+dq.peek());
        }
        //check the sizes 
         int size=dq.size();
         int carryOver=0;
         while(size>0)
         {
        	 int number=dq.pop();
        	// System.out.println("number poped "+number);
        	 number=(number*2)+carryOver;
        	  carryOver=number/10;
        	 int digit=number%10;
        	 dq.add(digit);
        	 size-=1;
         }
         if(carryOver>=1)
        	 dq.add(carryOver);
         ListNode itr=head;
         while(!dq.isEmpty())
         {
        	 int currDigit=dq.pollLast();
        	 itr.val=currDigit;
        	 if(itr.next==null && dq.size()>0)
        	 {
        		 itr.next=new ListNode();
        	 }
        		 itr=itr.next;
        	 
         }
         return head;
        
    }

}

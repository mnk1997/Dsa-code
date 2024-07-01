package in.cdac.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveNodeFromLL {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args)
	{
		
	}
	public ListNode removeNodes(ListNode head) {
        //we will iterate first so that we can find next greater element using deque
		
		Deque<ListNode>  dq=new LinkedList<>();
		ListNode temp=head;
		while(temp!=null)
		{
			if(dq.isEmpty())
				dq.add(temp);
			else
			{
				while(!dq.isEmpty() && dq.peekLast().val<temp.val)
				{
					dq.pollLast();
				}
				dq.add(temp);
			}
			temp=temp.next;
		}
		if(dq.isEmpty())
			return null;
		else
		{
			temp=head;
			ListNode headNew=null;
			ListNode prev=null;
			while(!dq.isEmpty() && temp!=null)
			{
				if(dq.peekFirst()==temp)
				{
					if(headNew==null)
					{
						headNew=new ListNode(temp.val);
						prev=headNew;
						
					}
					else
					{
						prev.next=new ListNode(temp.val);
						prev=prev.next;
					}
					dq.pollFirst();
					
				}
				
					temp=temp.next;
				
			}
			return headNew;
		}
		
		
        
    }

}

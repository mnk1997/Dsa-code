package in.cdac.pract;

public class MergeLinkedList {
    
	static class ListNode {
		      public int val;
		     public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A=getFirstList();
		ListNode B=getSecondList();
		
		ListNode head=mergeTwoLists(A, B);
		ListNode temp=head;
		
		  while(temp!=null) { System.out.println(temp.val); temp=temp.next; }
		 

	}
	public static ListNode getFirstList()
	{
		ListNode A=new ListNode(12);
		ListNode temp=new ListNode(22);
		ListNode temp2=new ListNode(46);
		A.next=temp;
		temp.next=temp2;
		temp2.next=null;
		
		
		return A;
	}
	public static ListNode getSecondList()
	{
		ListNode A=new ListNode(7);
		ListNode temp=new ListNode(12);
		ListNode temp2=new ListNode(26);
		A.next=temp;
		temp.next=temp2;
		temp2.next=null;
		
		
		
		return A;
		
	}
	
	 public static ListNode mergeTwoLists(ListNode A, ListNode B) {

	        if(A==null)
	           return B;
	        if(B==null)
	           return A;
	        ListNode head=null;
	        ListNode temp1=A;
	        ListNode temp2=B;
	        if(A.val<B.val)
	        {
	        	head=A;
	        	temp1=temp1.next;
	        }
	            
	        else
	        {
	        	 head=B;
	        	 temp2=temp2.next;
	        }
	          
	        ListNode curr=head;
	        
	      //  ListNode prevTemp=null;
	        while(temp1 !=null  && temp2 !=null)
	        {
	            
	            if(temp1.val <= temp2.val)
	            {
	                curr.next=temp1;
	                temp1=temp1.next;
	               
	            }
	            else{
	            	curr.next=temp2;
	                temp2=temp2.next;
	                
	                //curr=curr.next;
	                
	            }
	             curr=curr.next;
	             curr.next=null;

	        }

	        if(temp1!= null)
	        {
	            curr.next=temp1;
	        }
	        else if(temp2 != null)
	        {
	            curr.next=temp2;
	        }
	        else
	        {

	        }
	        //prevTemp.next=temp2;
	        System.out.println("returning @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        return head;
	    }


}

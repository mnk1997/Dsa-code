package in.cdac.test;

/*Input:	head = [1,2,3,4,5], n = 2
Output:	[1,2,3,5]*/

public class RemveNthNode {
	static class LinkedList
	{
		int val;
		LinkedList nextPtr;
		public LinkedList(int val)
		{
			this.val=val;
			this.nextPtr=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     LinkedList head=new LinkedList(1);
     LinkedList l2=new LinkedList(2);
     
     LinkedList l3=new LinkedList(3);
     LinkedList l4=new LinkedList(4);
     LinkedList l5=new LinkedList(5);
     head.nextPtr=l2;
     l2.nextPtr=l3;
     l3.nextPtr=l4;
     l4.nextPtr=l5;
     
     head=removeNthNodeFromEnd(head,2);
     LinkedList temp=head;
     while(temp!=null)
     {
    	 System.out.print(temp.val+" ");
    	 temp=temp.nextPtr;
     }
     
	}
	
	public static LinkedList removeNthNodeFromEnd(LinkedList head,int n)
	{
		if(head==null)
			return null;
		// 2 ptr point to node
		//forward will be iterating and we wil be n
		//precivous ptr jsut storing alst 
		
		//1-->2-->3--->4--->5 at single iteration
		
		
	
			
			
		
		
		//1. try to find the size of the linked list
		LinkedList temp=head;
		int size=0;
		while(temp!=null)
		{
		   size++;
		   temp=temp.nextPtr;
		}
		System.out.println("size "+size);
		int nodeFromHead=size -n;
		LinkedList forwardPtr=head;
		System.out.println("node from head"+nodeFromHead);
		//LinkedList backPtr=null;
		//check for 1st node
		if(nodeFromHead==1)
		{
			head=head.nextPtr;
			return head;
		}
		
		while(nodeFromHead>1)
		{// 2-3
			
			forwardPtr=forwardPtr.nextPtr;
			nodeFromHead-=1;
			
		}
		System.out.println("forward Ptr"+forwardPtr.val);
		if(forwardPtr.nextPtr!=null)
		     forwardPtr.nextPtr=forwardPtr.nextPtr.nextPtr;
		else 
			forwardPtr.nextPtr=null;
		
		
		return head;
	}
	
	public static LinkedList deleteNthNodeFromEnd(LinkedList head,int key)
	{
		// First pointer will point to
        // the head of the linked list
        LinkedList first = head;
 
        // Second pointer will point to the
        // Nth node from the beginning
        LinkedList second = head;
        for (int i = 0; i < key; i++) {
 
            // If count of nodes in the given
            // linked list is <= N
            if (second.nextPtr == null) {
 
                // If count = N i.e. delete the head node
                if (i == key - 1)
                    head = head.nextPtr;
                return null;
            }
            second = second.nextPtr;
        }
 
        // Increment both the pointers by one until
        // second pointer reaches the end
        while (second.nextPtr != null) {
            first = first.nextPtr;
            second = second.nextPtr;
        }
 
        return head;
	}
	
	

}

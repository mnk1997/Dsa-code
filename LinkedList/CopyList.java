package in.cdac.LinkedList;



public class CopyList {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode head=makeList();
		RandomListNode head2=copyRandomList(head);
		RandomListNode temp=head2;
		while(temp!=null)
		{
			System.out.println(temp.label);
		}

	}
	public static RandomListNode makeList()
	{
		//i/p:   83 188 253 281 254 56 70 3 276 233 280 224 16 173 183 193 44 184 33 213 134 95 213 48 300 62 237 63
		//d o/p: 83 281 188 173 253 0 281 254 254 281 56 281 70 0 3 56 276 281 233 281 280 83 224 253 16 16 173 281 
		//m o/p: 83 281 188 0 253 0 281 254 254 281 56 281 70 0 3 56 276 281 233 281 280 83 224 253 16 16 
		RandomListNode head=new RandomListNode(14);
		RandomListNode temp=new RandomListNode(83);
	}
	  public static RandomListNode copyRandomList(RandomListNode head) {
	        RandomListNode temp=head;
	        RandomListNode head2=null;
	        while(temp!=null && temp.next.next!=null)
	        {
	            RandomListNode newNode=new RandomListNode(temp.label);
	            if(head2==null)
	               head2=newNode;
	            newNode.next=temp.next;
	            temp.next=newNode;
	            temp=newNode.next;
	        }
	        temp=head;
	        //now updating random node of all newly created 
	        while(temp!=null && temp.next!=null)
	        {
	            if(temp.random==null)
	               temp.next.random=null;
	            else
	                temp.next.random=temp.random.next;
	            
	            temp=temp.next.next;
	        }
	        //now removing deep copy node from list
	        temp=head;
	        RandomListNode temp2=head2;
	        while(temp!=null && temp.next!=null && temp2!=null && temp2.next!=null)
	        {
	            temp.next=temp2.next;
	            temp2.next=temp2.next.next;
	            temp=temp.next;
	            temp2=temp2.next;
	        }

	        return head2;
	    }
	  
	  
	  public RandomListNode solutionTwo(RandomListNode head)
	  {
		  if (head == null) return null;

		// Create a new node for each original node and insert it next to the original node

		RandomListNode temp = head;

		while (temp != null) {

		RandomListNode newNode = new RandomListNode(temp.label);

		newNode.next = temp.next;

		temp.next = newNode;

		temp = newNode.next;

		}

		// Update the random pointers of the new nodes

		temp = head;

		while (temp != null) {

		if (temp.random != null) {

		temp.next.random = temp.random.next;

		}

		temp = temp.next.next;

		}

		// Separate the original list and the copied list

		temp = head;

		RandomListNode newHead = temp.next;

		RandomListNode tempNew = newHead;

		while (temp != null) {

		temp.next = temp.next.next;

		temp = temp.next;

		if (tempNew.next != null) {

		tempNew.next = tempNew.next.next;

		tempNew = tempNew.next;

		}

		}

		return newHead;
	  }

}

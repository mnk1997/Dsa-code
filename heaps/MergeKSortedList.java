package in.cdac.heaps;

import java.util.ArrayList;
import java.util.Arrays;


/*1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9*/
public class MergeKSortedList {
	 public static class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	public static class Data
	{
		int val;
		ListNode curr;
		public Data(int val,ListNode node)
		{
			this.val=val;
			this.curr=node;
		}
		public Data fetchnext()

		{
			
			if(curr.next!=null)
			{
				Data newData=new Data(curr.next.val,curr.next);
				return newData;
				
				
			}
			else 
			{
				return null;
			}
		}
		public boolean hasNext()
		{
			if(this.curr.next!=null)
				return true;
			else 
				return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1=new ListNode(1);
		head1.next=new ListNode(10);
		head1.next.next=new ListNode(20);
		ListNode head2=new ListNode(4);
		head2.next=new ListNode(11);
		head2.next.next=new ListNode(13);
		ListNode head3=new ListNode(3);
		head3.next=new ListNode(8);
		head3.next.next=new ListNode(9);
		
		ListNode head=mergeKLists(new ArrayList<ListNode>(Arrays.asList(head1,head2,head3)));
		ListNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.val);
			temp=temp.next;
		}

	}
	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		System.out.println("called mergerKlList");
		ListNode head=null;
		ListNode curr=null;
		
		ArrayList<Data> heap=new ArrayList<>();
		//initialize the heap
		initializeHeapArray(a,heap);
		heapify(heap);
		System.out.println("heap size "+heap.size());
		while(heap.size()!=0)
		{
			System.out.println("heap size "+heap.size());
		     Data minNode=getMin(heap);
		     if(head==null)
		     {
		    	 ListNode newNode=new ListNode(minNode.val);
		    	 head=newNode;
		    	 curr=head;
		     }
		     else
		     {
		    	 ListNode newNode=new ListNode(minNode.val);
		    	 curr.next=newNode;
		    	 curr=newNode;
		     }
		     
			
		}
		
		
		
		return head;
		
	}
	public static void initializeHeapArray(ArrayList<ListNode> a, ArrayList<Data> heap)
	{
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)!=null)
			{
				heap.add(new Data(a.get(i).val,a.get(i)));
			}
		}
		System.out.println("okay returning from initialize heap ");
	}
	public static void heapify(ArrayList<Data> lst)
	{
		System.out.println("called heapify");
		int numberOfNodes=lst.size();
		int numberOfLeaf=(numberOfNodes+1)/2;
		for(int i=1;i<=numberOfLeaf;i++)
		{
			
			int leafIndex=lst.size()-i;
			System.out.println("leaf index "+leafIndex);
			int parentIndex=(leafIndex-1)/2;
			int currIndex=leafIndex;
			while(currIndex>0)
			{
				//System.out.println("parent index "+parentIndex);
				if(lst.get(parentIndex).val>lst.get(currIndex).val)
				{
					Data temp=lst.get(currIndex);
					lst.set(currIndex,lst.get(parentIndex));
					lst.set(parentIndex, temp);
					
				}
				currIndex=parentIndex;
				parentIndex=(currIndex-1)/2;
				
				
				
			}
		}
		System.out.println();
		for(int i=0;i<lst.size();i++)
		{
			System.out.print (" "+lst.get(i).val);
		}
		
		//System.out.println("returning from hepaify");
		
	}
	public static Data getMin(ArrayList<Data> heap)
	{
		Data minData=heap.get(0);
		int lastIndex=heap.size()-1;
		//Data temp=minData;
		heap.set(0,heap.get(lastIndex));
		
		if(minData.hasNext())
		{
			heap.set(lastIndex, minData.fetchnext());
			System.out.println("calling heapify");
			
		}
		else
		{
			heap.set(lastIndex, minData);
			heap.remove(lastIndex);
			
		}
			
		heapify(heap);
		
		return minData;
		
	}
	
	

}

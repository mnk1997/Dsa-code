package in.cdac.pract;

import java.util.LinkedList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
}

public class SolutionOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> sampleList = new LinkedList<>();
		sampleList.add(5);
		sampleList.add(9);
		sampleList.add(8);
		//System.out.println(addTwoNumbers(sampleList, sampleList));

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int currentQuotient = 0;
		int currentRemainder = 0;

		l1 = reverseListUsingRecursion(l1);
		ListNode newHead = l1.next;
		l1.next = null;
		l1 = newHead;
		l2 = reverseListUsingRecursion(l2);
		newHead = l2.next;
		l2.next = null;
		l2 = newHead;
		//ListNode newList = new ListNode();
		ListNode head=null;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode prevNode=null;
		int tempSum = 0;
		while (temp1 != null && temp2 != null)

		{
			ListNode newList = new ListNode();
			tempSum = (temp1.val + temp2.val + currentQuotient);
			currentQuotient = tempSum / 10;
			currentRemainder = currentQuotient >= 1 ? tempSum % 10 : tempSum;
			newList.val = currentRemainder;
			prevNode.next=newList;
			newList.next=null;
			temp1 = temp1.next;
			temp2 = temp2.next;
			if(head==null)
			{
				head=newList;
			}
               prevNode=newList;
		}
		if (temp1 != null) {
			while (temp1 != null) {
				ListNode newList = new ListNode();
				tempSum = (temp1.val + currentQuotient);
				currentQuotient = tempSum / 10;
				currentRemainder = currentQuotient >= 1 ? tempSum % 10 : tempSum;
				newList.val = currentRemainder;
				prevNode.next=newList;
				newList.next=null;
				temp1 = temp1.next;
				prevNode=newList;
			}
		} else if (temp2 != null)

		{
			while (temp2 != null) {
				ListNode newList = new ListNode();
				tempSum = (temp2.val + currentQuotient);
				currentQuotient = tempSum / 10;
				currentRemainder = currentQuotient >= 1 ? tempSum % 10 : tempSum;
				newList.val = currentRemainder;
				prevNode.next=newList;
				newList.next=null;
				temp2 = temp2.next;
				prevNode=newList;
			}
		}
		return head;
	}

	public ListNode reverseListUsingRecursion(ListNode l) {
		if (l == null) {

			return null;
		} else if (l.next == null) {
			// newHead=l;
			l.next = l;
			return l;
		}
		// ListNode prevLink=l;
		ListNode parentLink = reverseListUsingRecursion(l.next);
		l.next = parentLink.next;
		parentLink.next = l;

		return l;

	}
}

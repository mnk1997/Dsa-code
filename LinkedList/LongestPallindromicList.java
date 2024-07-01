package in.cdac.LinkedList;

import in.cdac.LinkedList.ReverseLinkedList2.ListNode;

/*i/p: 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2*/
/*o/p:5*/
public class LongestPallindromicList {
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		ListNode temp1 = new ListNode(1);
		 ListNode temp2 = new ListNode(2);
		ListNode temp3 = new ListNode(1);
		ListNode temp4 = new ListNode(2);
		ListNode temp5 = new ListNode(2);
		ListNode temp6 = new ListNode(1);
		ListNode temp7 = new ListNode(3);
		ListNode temp8 = new ListNode(2);
		ListNode temp9 = new ListNode(2);
		head.next = temp1;
		 temp1.next = temp2;

		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;
		temp5.next = temp6;

		temp6.next = temp7;
		 temp7.next = temp8;
		 temp8.next=temp9;

		System.out.println(solve(head));

	}

	public static int solve(ListNode A) {
		int maxLen = 0;
		int oddLen = calculateMaxOddLenPallindrome(A, maxLen);
		int evenLen = calculateMaxEvenLenPallindrome(A, 0);
		// int evenLen=2;
		return oddLen > evenLen ? oddLen : evenLen;
	}

	public static int calculateMaxOddLenPallindrome(ListNode A, int max) {

		ListNode currNode = A.next;
		ListNode leftItr = A, rightItr = currNode.next;
		while (currNode != null) {

			int currLen = 1;
			while (rightItr != null && leftItr.val == rightItr.val) {
				currLen += 2;
				ListNode temp = A;
				if (leftItr == A) {
					break;
				}
				while (temp.next != leftItr) {
					temp = temp.next;

				}
				leftItr = temp;
				rightItr = rightItr.next;

			}
			if (max < currLen)
			{
				
				max = currLen;
			}
				
			leftItr = currNode;
			currNode = currNode.next;
			if(currNode !=null)
			     rightItr=currNode.next;
		}
		System.out.println("ODd length" + max);

		return max;

	}

	public static int calculateMaxEvenLenPallindrome(ListNode A, int max) {
		ListNode leftItr = A, rightItr = A;
		ListNode currLeft = A, currRight = A.next;
		while (currRight != null) {

			rightItr = currRight;
			leftItr = currLeft;
			int currLen = 0;
			while (rightItr != null && leftItr.val == rightItr.val) {
				currLen += 2;
				ListNode temp = A;
				if (leftItr == A) {
					break;
				}
				while (temp.next != leftItr) {
					temp = temp.next;

				}
				leftItr = temp;
				rightItr = rightItr.next;

			}
			if (max < currLen)
				max = currLen;
			currLeft = currLeft.next;
			currRight = currRight.next;
		}
		System.out.println("Even length" + max);
		return max;

	}

}

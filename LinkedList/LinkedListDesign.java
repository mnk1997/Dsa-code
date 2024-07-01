package in.cdac.LinkedList;

import java.util.LinkedList;

public class LinkedListDesign {
	int val;
	LinkedListDesign next;

	public LinkedListDesign(int val) { // TODO Auto-generated constructor stub
		this.val = val;
		next = null;
	}

	LinkedListDesign head = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListDesign head = new LinkedListDesign(0);
		head.insert_node(1, 12);
		head.insert_node(2, 24);
		head.insert_node(3, 48);
		head.insert_node(4, 60);
		head.insert_node(5, 72);
		head.print_ll();
		head.insert_node(3, 36);
		head.print_ll();
		head.insert_node(7, 84);
		head.print_ll();
		head.delete_node(8);
		head.print_ll();
		head.insert_node(17, 96);
		head.print_ll();

	}

	public void insert_node(int position, int value) {
		// @params position, integer
		// @params value, integer
		LinkedListDesign newNode = new LinkedListDesign(value);
		if (head == null) {
			System.out.println("headis nulll");
			head = newNode;
			return;
		} else if (position == 1) {
			System.out.println("position is 1");
			newNode.next = head;
			head = newNode;
		} else {
			System.out.println("in    else");
			LinkedListDesign temp = head;
			for (int i = 1; i < position - 1; i++) {
				if (temp.next == null) {
					temp.next = newNode;
					return;
				}
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;

		}
	}

	public void delete_node(int position) {

		// @params position, integer
		LinkedListDesign temp = head;
		if (temp == null) {
			return;
		} else if (position == 1) {
			head = head.next;
		} else {
			for (int i = 1; i < position - 1; i++) {
				if (temp == null)
					return;
				temp = temp.next;

			}
			if (temp.next != null)
				temp.next = temp.next.next;
		}

	}

	public void print_ll() {
		// Output each element followed by a space
		LinkedListDesign temp = head;
		if (temp == null) {
			System.out.println("is null");
		}
		System.out.println("callled");
		while (temp != null) {
			System.out.println("hhhe");
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

	}
}

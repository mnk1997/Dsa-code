package in.cdac.heaps;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.*/
/*A = 4  
B = [1 2 3 4 5 6] 
		[-1, -1, -1, 1, 2, 3]*/
//----------------------------------

/*A = 2
B = [15, 20, 99, 1]
		 [-1, 15, 20, 20]*/

//for Ath LArgest can be deduced to smallest In All the elements till A.
//therefore we will use minHeap of A size , and after removing we will insert new eleemtns
//what i will do is use the windows of size A , slide it , and at every slide we will remove the start index of window, also we will use 
//minHeap here , 
public class ALargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int ele : solve(5, new ArrayList<Integer>(Arrays.asList(7, 6, 5, 4, 3, 2, 1)))) {
			System.out.println(ele);
		}

	}

	public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		ArrayList<Integer> minHeap = new ArrayList<>(A);
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < A; i++) {
			minHeap.add(B.get(i));

		}
		for (int i = 0; i < A - 1; i++) {
			ans.add(-1);
		}
		heapify(minHeap);
		ans.add(minHeap.get(0));
		for (int i = A; i < B.size(); i++) {
			if (B.get(i) > minHeap.get(0)) {
				removeMin(minHeap);
				insertIntoHeap(B.get(i), minHeap);
			}
			ans.add(minHeap.get(0));
		}

		return ans;

	}

	public static void heapify(ArrayList<Integer> heap) {
		int lastIndex = heap.size() - 1;
		int lastParentIndex = (lastIndex - 1) / 2;
		
		for (int i = lastParentIndex; i >= 0; i--) {
			int currIndex = i;
			int lc = (2 * currIndex) + 1;
			int rc = (2 * currIndex) + 2;
			while (lc < heap.size()) {
				int leftVal = heap.get(lc);
				int rightVal = Integer.MAX_VALUE;
				int currVal = heap.get(currIndex);
				if (rc < heap.size())
					rightVal = heap.get(rc);
				if (currVal > leftVal && leftVal <= rightVal) {
					heap.set(currIndex, leftVal);
					heap.set(lc, currVal);
					currIndex = lc;
				} else if (currVal > rightVal && rightVal < leftVal) {
					heap.set(currIndex, rightVal);
					heap.set(rc, currVal);
					currIndex = rc;
				} else {
					break;
				}
				lc = (2 * currIndex) + 1;
				rc = (2 * currIndex) + 2;

			}
		}
		System.out.println("---------------------------------------");
		for (int ele : heap) {
			System.out.print(ele);
		}
		System.out.println("------------------------------------");
	}

	public static void removeMin(ArrayList<Integer> heap) {
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int currIndex = 0;
		int lc = (2 * currIndex) + 1;
		int rc = (2 * currIndex) + 2;
		while (lc < heap.size()) {
			int leftVal = heap.get(lc);
			int rightVal = rc < heap.size() ? heap.get(rc) : Integer.MAX_VALUE;
			int currVal = heap.get(currIndex);
			if (currVal > leftVal && leftVal <= rightVal) {
				heap.set(currIndex, leftVal);
				heap.set(lc, currVal);
				currIndex = lc;
			} else if (currVal > rightVal && rightVal <= leftVal) {
				heap.set(currIndex, rightVal);
				heap.set(rc, currVal);
				currIndex = rc;
			} else {
				break;

			}
			lc = (2 * currIndex) + 1;
			rc = (2 * currIndex) + 2;

		}
	}

	public static void insertIntoHeap(int ele, ArrayList<Integer> heap) {
		heap.add(ele);

		int currIndex = heap.size() - 1;
		int parentIndex = (currIndex - 1) / 2;
		while (currIndex > 0) {
			if (heap.get(parentIndex) > heap.get(currIndex)) {
				int temp = heap.get(currIndex);
				heap.set(currIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
			}
			currIndex = parentIndex;
			parentIndex = (currIndex - 1) / 2;
		}

	}

}

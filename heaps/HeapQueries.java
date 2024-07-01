package in.cdac.heaps;

import java.util.ArrayList;

/*You have an empty min heap. 
 * You are given an array A consisting of N queries.
 *  Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.*/

/*[[1, -1], [2, 2], [2, 1], [1, -1]]  : [-1,1]
		
		[[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]] :[1,3]*/
public class HeapQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> minHeap = new ArrayList<>();
		for (ArrayList<Integer> a : A) {
			int p = a.get(0);
			int q = a.get(1);
			if (p == 1) {
				list.add(popMin(minHeap));
			} else {
				insertIntoHeap(q, minHeap);
			}
		}

		return list;
	}

	public int popMin(ArrayList<Integer> heap)
	 {
		 int minEle=heap.get(0);
		 heap.set(0,heap.get(heap.size()-1));
		 heap.remove(heap.size()-1);
		 int currIdx=0;
		 int lc=2*currIdx+1;
		 int rc=2*currIdx+2;
		 while(lc<heap.size())
		 {
			 int leftVal=heap.get(lc);
			 int currVal=heap.get(currIdx);
			 int rightVal=Integer.MAX_VALUE;
			 if(rc<heap.size())
				 rightVal=heap.get(rc);
			 
			 if(leftVal<currVal && leftVal<=rightVal)
			 {
				 heap.set(currIdx,leftVal);
				 heap.set(lc,currVal);
				 currIdx=lc;
			 }
			 else if(rightVal<currVal && rightVal<=currVal)
			 {
				 heap.set(currIdx,rightVal);
				 heap.set(rc, currVal);
				 currIdx=rc;
			 }
			 
			 lc=2*currIdx+1;
			 rc=2*currIdx+2;
		 }
		 
		 
		 
		 return minEle;
		 
	 }

	public void insertIntoHeap(int ele, ArrayList<Integer> heap) {
		heap.add(ele);
		int lastIdx=heap.size()-1;
		int lastParentIndex=(lastIdx-1)/2;
		if(heap.size()==1)
			return ;
		while(lastIdx>0)
		{
			if(heap.get(lastParentIndex)>heap.get(lastIdx))
			{
				int temp=heap.get(lastParentIndex);
				heap.set(lastParentIndex, heap.get(lastIdx));
				heap.set(lastIdx, temp);
				
			}
			lastIdx=lastParentIndex;
			lastParentIndex=(lastIdx-1)/2;
		}

	}

}

package in.cdac.heaps;

import java.util.ArrayList;
import java.util.Arrays;

/*N people having different priorities are standing in a queue.	

The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).*/

/*A = [1, 40, 2, 3]
		 B = 2*/



/*[1, 2, 3, 40]*/
public class KPlacesApart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ele:solve(new ArrayList<Integer>(Arrays.asList(4,7,9)),3))
			
		{
			System.out.println(ele);
		}

	}
	public static ArrayList<Integer> solve(ArrayList<Integer> A,int B){
		if(B==0)
		{
			return A;
		}
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<Integer> heap=new ArrayList<>();
		for(int i=0;i<B;i++)
		{
			heap.add(A.get(i));
		}
		heapify(heap);
		for(int i=B;i<A.size();i++)
		{
			list.add(getMin(heap));
			insertIntoHeap(A.get(i),heap);
		}
		
		while(heap.size()!=0)
		{
			list.add(getMin(heap));
		}
		
		
		
		return list;
	}
	public static void heapify(ArrayList<Integer> heap)
	{
		int lastParentIndex=(heap.size()-2)/2;
		for(int i=lastParentIndex;i>=0;i--)
		{
			
			int currIndx=i;
			int lc=(2*currIndx)+1;
			int rc=(2*currIndx)+2;
			System.out.println("currIndex"+currIndx);
			while(lc<heap.size())
			{
				int leftVal=heap.get(lc);
				int rightVal=Integer.MAX_VALUE;
				int currVal=heap.get(currIndx);
				if(rc<heap.size())
					rightVal=heap.get(rc);
				
				if(currVal>leftVal && leftVal<=rightVal)
				{
					heap.set(currIndx,leftVal);
					heap.set(lc, currVal);
					currIndx=lc;
				}
				else if(currVal>rightVal && rightVal<leftVal)
				{
					heap.set(currIndx,rightVal);
					heap.set(rc,currVal);
					currIndx=rc;
				}
				else
				{
					break;
				}
				lc=(2*currIndx)+1;
				rc=(2*currIndx)+2;
				
			}
		}
	}
	
	public static int getMin(ArrayList<Integer> heap)
	{ 
		int min=heap.get(0);
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int currIndx=0;
		int lc=(2*currIndx)+1;
		int rc=(2*currIndx)+2;
		while(lc<heap.size())
		{
			int leftVal=heap.get(lc);
			int currVal=heap.get(currIndx);
			int rightVal=Integer.MAX_VALUE;
			if(rc<heap.size())
			{
				rightVal=heap.get(rc);
			}
			
			if(currVal>leftVal && leftVal<=rightVal)
			{
				heap.set(currIndx,leftVal);
				heap.set(lc,currVal);
				currIndx=lc;
			}
			else if(currVal>rightVal && rightVal<leftVal)
			{
				heap.set(currIndx, rightVal);
				heap.set(rc, currVal);
				currIndx=rc;
			}
			else
			{
				break;
			}
			lc=(2*currIndx)+1;
			rc=(2*currIndx)+2;
			
		}
		
		
		
		return min;
		
	}
	public static void insertIntoHeap(int ele,ArrayList<Integer> heap)
	{
		heap.add(ele);
		int currIndex=heap.size()-1;
		int parentIndex=(currIndex-1)/2;
		while(currIndex>0)
		{
			if(heap.get(parentIndex)>heap.get(currIndex))
			{
				int temp=heap.get(parentIndex);
				heap.set(parentIndex,heap.get(currIndex));
				heap.set(currIndex,temp);
				currIndex=parentIndex;
				parentIndex=(currIndex-1)/2;
			}
			else
			{
				break;
			}
		}
	}

}

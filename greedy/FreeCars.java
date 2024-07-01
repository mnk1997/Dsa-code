package in.cdac.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*Given two arrays, A and B of size N. 
A[i] represents the time by which you can buy the ith car without paying any money.

B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.

Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:

You can start buying from time = 0.
Return your answer modulo 109 + 7.*/

/*A = [1, 3, 2, 3, 3]
B = [5, 6, 1, 3, 9]
		20
		
		
		--------
		
		 A = [3, 8, 7, 5]
				 B = [3, 1, 7, 19]
						 30*/
public class FreeCars {

	static class TimeWithValue
	 {
		 int time;
		 int value;
		 public TimeWithValue(int t,int v)
		 {
			 time=t;
			 value=v;
		 }
		 public int getTime()
		 {
			 return time;
		 }
		 public int getValue()
		 {
			 return value;
		 }
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(6,8,5,4,2,1,6,4,2,8,5,4,4,8,8,5,3,4,4,5,8,5,5,7,2,4,5,2,6)),new ArrayList<Integer>(Arrays.asList(11,10,8,10,5,7,5,9,8,7,11,5,7,4,7,9,8,5,5,5,8,11,8,4,4,2,9,6,6))));

	}
	 public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		 long ans=0;
		ArrayList<TimeWithValue> list=new ArrayList<>();
		for(int i=0;i<A.size();i++)
		{
			list.add(new TimeWithValue(A.get(i),B.get(i)));
		}
		Collections.sort(list,new Comparator<TimeWithValue>() {
			public int compare(TimeWithValue o1,TimeWithValue o2)
			{
				if(o1.getTime()-o2.getTime()==0)
				{
					return o2.getValue()-o1.getValue();
				}
				return o1.getTime()-o2.getTime();
				 
			}
			
		});
		System.out.println("After sorting ");
		
		for(TimeWithValue ele:list)
		{
			System.out.println("ele time "+ele.getTime()+"   ele value "+ele.getValue());
		}
		
		
		System.out.println("------------------------------------------------------------");
		ArrayList<Integer> minHeapForValues=new ArrayList<>();
		
		//heapify(minHeapForValues);
		int t=0;
		for(TimeWithValue ele:list)
		{
			if(t==0)
			{
				insertIntoHeap(ele.getValue(),minHeapForValues);
				t++;
			}
			else if(ele.getTime()==t)
			{
				if(ele.getValue()>minHeapForValues.get(0))
				{
					removeMinFromHeap(minHeapForValues);
					insertIntoHeap(ele.getValue(),minHeapForValues);
					
				}
			}
			else if (ele.getTime()> t)
			{
				insertIntoHeap(ele.getValue(),minHeapForValues);
				t++;
			}
		}
		
		
		 for(int i=0;i<minHeapForValues.size();i++)
		 {
			 System.out.println(" "+minHeapForValues.get(i));
			 ans+=minHeapForValues.get(i);
		 }
		 
		 
		 
		 return (int)(ans%1000000007);
	    }
	 
	 public static void removeMinFromHeap(ArrayList<Integer> heap)
	 {
		       int lastIndex=heap.size()-1;
		       heap.set(0,heap.get(lastIndex));
		       heap.remove(lastIndex);
		       int currIndex=0;
		       int lc=(2*currIndex)+1;
		       int rc=(2*currIndex)+2;
		       while(lc<heap.size())
		       {
		    	   int currValue=heap.get(currIndex);
		    	   int leftValue=heap.get(lc);
		    	   int rightValue=Integer.MAX_VALUE;
		    	   if(rc<heap.size())
		    		   rightValue=heap.get(rc);
		    	   if(currValue > leftValue && leftValue<=rightValue)
		    	   {
		    		     //int temp=currValue;
		    		     heap.set(currIndex,leftValue);
		    		     heap.set(lc, currValue);
		    		     currIndex=lc;
		    	   }
		    	   else if(currValue > rightValue && rightValue<=leftValue)
		    	   {
		    		  // int temp=currValue;
		    		     heap.set(currIndex,rightValue);
		    		     heap.set(rc, currValue);
		    		     currIndex=rc;
		    	   }
		    	   else 
		    	   {
		    		   break;
		    	   }
		    	   lc=(2*currIndex)+1;
			       rc=(2*currIndex)+2;
		       }
		 
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
				 int temp=heap.get(currIndex);
				 heap.set(currIndex, heap.get(parentIndex));
				 heap.set(parentIndex,temp);
			 }
			 currIndex=parentIndex;
			 parentIndex=(currIndex-1)/2;
		 }
		 System.out.println("*****************************************************************************");
		 System.out.println();
		 for(int i=0;i<heap.size();i++)
		 {
			 System.out.print(heap.get(i)+"  ");
		 }
		 System.out.println();
		 System.out.println("*****************************************************************************");
	 }
	

}

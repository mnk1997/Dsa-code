package in.cdac.heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectRopes {
	//1,18
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(54,2,1,135,68,143,124,67,78,35,13,200,62,177,93,156,59,65,121,113,93,8,18,3,38,124,149,145,167,194,144,93,102,95,101,27,52,38,68,105,143,1,135,66,38,11,191))));

	}
	 public static int solve(ArrayList<Integer> A) {
		  int minCost=0;
		  ArrayList<Integer> heap=new ArrayList<>(A);
		  System.out.println("heap size "+heap.size());
		 
		  heapify(heap);
		  while(heap.size()!=1)
		  {
			  
			  System.out.println(" inside while");
			  int x=getMin(heap);
			  int y=getMin(heap);
			  System.out.println("x "+x +"    y:"+y + " heap size "+heap.size()) ;
			  minCost+=x+y;
			  insertIntoHeap(x+y,heap);
			  System.out.println(" after insert heap size "+heap.size());
			  System.out.println("---------------------------");
		  }
		  
		  return minCost;
	    }
	 public static void heapify(ArrayList<Integer> heap)
	 {
		 int n=heap.size();
		 int numberOfLeaves=(n+1)/2;
		 int lastParentIndex=(n-1)/2;
		 for(int i=lastParentIndex;i>=0;i--)
		 {
			 
			 int  currIndex=i;
			 int lc=2*currIndex+1;
			 int rc=2*currIndex+2;
			 
			 while(lc<heap.size())
			 {
				 int rightValue=Integer.MAX_VALUE;
				 if(rc<heap.size())
				 {
					 rightValue=heap.get(rc);
				 }
				 int currVal=heap.get(currIndex);
				 int leftVal=heap.get(lc);
				 if(currVal>leftVal && leftVal<=rightValue)
				 {
					// System.out.println(" currIndex "+currIndex + " parentIndex "+parentIndex +" val at curr indx "+heap.get(currIndex)+"  val at parent indx "+heap.get(parentIndex));
					 int temp=heap.get(currIndex);
					 heap.set(currIndex,heap.get(lc));
					 heap.set(lc, temp);
					 currIndex=lc;
				 }
				 else if(currVal>rightValue && rightValue<leftVal)
				 {
					 int temp=heap.get(currIndex);
					 heap.set(currIndex,heap.get(rc));
					 heap.set(rc, temp);
					 currIndex=rc;
				 }
				 else
				 {
					 break;
				 }
				 
				 lc=2*currIndex+1;
				 rc=2*currIndex+2;
			 }
			 if(lc<heap.size() && heap.get(currIndex) >heap.get(lc))
			 {
				 System.out.println("Stilll lc is left");
				 int temp=heap.get(currIndex);
				 heap.set(currIndex,heap.get(lc));
				 heap.set(lc, temp);
				 currIndex=lc;
			 }
		 }
		 
		 System.out.println("heapiiiffffyyyyyyyyy");
		 System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		 for(int ele:heap)
		 {
			 System.out.println(ele);
		 }
		 System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		 
	 }
	 public static int getMin(ArrayList<Integer> heap)
	 {
		 int min=heap.get(0);
		 int lastIndex=heap.size()-1;
		 heap.set(0,heap.get(lastIndex));
		// heap.set(lastIndex,min);
		 heap.remove(lastIndex);
		 //heapify(heap);
		
			int currIndex=0;
			int lc=(currIndex*2)+1;
			int rc=(currIndex*2)+2;
			//int parentIndex=(currIndex-1)/2;
			while(lc<heap.size())
			{
				int rightValue=Integer.MAX_VALUE;
				 if(rc<heap.size())
				 {
					 rightValue=heap.get(rc);
				 }
				 int currVal=heap.get(currIndex);
				 int leftVal=heap.get(lc);
				if(currVal>leftVal && leftVal<= rightValue)
				{
					int temp=heap.get(currIndex);
					heap.set(currIndex,leftVal);
					heap.set(lc,temp);
					currIndex=lc;
					
				}
				else if(currVal>rightValue && rightValue<leftVal)
				{
					int temp=heap.get(currIndex);
					heap.set(currIndex,heap.get(rc));
					heap.set(rc,temp);
					currIndex=rc;
					
				}
				else
				{
					break;
				}
				lc=(currIndex*2)+1;
				rc=(currIndex*2)+2;
				
			}
			
			 return min;
		}
		
		 
	 
	 public static void insertIntoHeap(int sum,ArrayList<Integer> heap)
	 {
		 heap.add(sum);
	
				int currIndex=heap.size()-1;
				int parentIndex=(currIndex-1)/2;
				while(currIndex>0)
				{
					if(heap.get(parentIndex)>heap.get(currIndex))
					{
						int temp=heap.get(parentIndex);
						heap.set(parentIndex,heap.get(currIndex));
						heap.set(currIndex,temp);
						
					}
					currIndex=parentIndex;
					 parentIndex=(currIndex-1)/2;

					
				}
			
		 
		 
	 }

}

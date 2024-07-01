package in.cdac.heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int ele:solve(new ArrayList<Integer>(Arrays.asList(59,64,10,39))))
		{
			System.out.println(ele);
		}

	}
	   public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		   ArrayList<Integer> minHeap=new ArrayList<>();
	        ArrayList<Integer> maxHeap=new ArrayList<>();
	        ArrayList<Integer> op=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	           
	            if(i==0)
	            {
	                  insertIntoMaxHeap(A.get(i),maxHeap);
	                 // op.add(maxHeap.get(0));
	                  
	            }
	            else 
	            {
	                if(A.get(i)>maxHeap.get(0))
	                {
	                    insertIntoMinHeap(A.get(i),minHeap);
	                  //  op.add(minHeap.get(0));
	                }
	                else{
	                    insertIntoMaxHeap(A.get(i),maxHeap);
	                  //  op.add(maxHeap.get(0));
	                }
	            }
	            
	             if(maxHeap.size()-minHeap.size()>1)
	            {
	                //remove element from maxHeap and insert into minHeap
	                    insertIntoMinHeap(removeFromMaxHeap(maxHeap),minHeap);
	            }
	            else if(minHeap.size() - maxHeap.size()>0)
	            {
	                //remove element from minHeap and insert into maxHeap
	                insertIntoMaxHeap(removeElementFromMinHeap(minHeap),maxHeap);
	            }
	           
	             op.add(maxHeap.get(0));
	        }

	         return op;
	    }
	   
	   
	    public static void insertIntoMaxHeap(int ele,ArrayList<Integer> maxHeap)
	    {
	        maxHeap.add(ele);
	        
	      
	            //int leafIndex=;
	            
	            int currIndex=maxHeap.size()-1;
	            int parentIndex=(currIndex-1)/2;
	            while(currIndex>0)
	            {
	                if(maxHeap.get(parentIndex)<maxHeap.get(currIndex))
	                {
	                    int temp=maxHeap.get(parentIndex);
	                    maxHeap.set(parentIndex,maxHeap.get(currIndex));
	                    maxHeap.set(currIndex,temp);
	                }
	                currIndex=parentIndex;
	                parentIndex=(currIndex-1)/2;
	            }
	        
	        
	    }
	      public static void insertIntoMinHeap(int ele,ArrayList<Integer> minHeap)
	    {
	        minHeap.add(ele);
	        
	            int leafIndex=minHeap.size()-1;
	            int parentIndex=(leafIndex-1)/2;
	            int currIndex=leafIndex;
	            while(currIndex>0)
	            {
	                if(minHeap.get(parentIndex)> minHeap.get(currIndex))
	                {
	                    int temp=minHeap.get(parentIndex);
	                    minHeap.set(parentIndex,minHeap.get(currIndex));
	                    minHeap.set(currIndex,temp);
	                }
	                currIndex=parentIndex;
	                parentIndex=(currIndex-1)/2;
	            }
	        
	        
	    }
	    public static int removeFromMaxHeap(ArrayList<Integer> maxHeap)
	    {
	        int maxEle=maxHeap.get(0);
	        
	        int lastIndex=maxHeap.size()-1;
	        maxHeap.set(0,maxHeap.get(lastIndex));
	        maxHeap.remove(lastIndex);
	        int currIndex=0;
	        int leftChild=2*currIndex+1;
	        int rightChild=2*currIndex+2;
	        while(rightChild<maxHeap.size())
	        {
	            if(maxHeap.get(leftChild)>maxHeap.get(rightChild) && maxHeap.get(currIndex)<maxHeap.get(leftChild))
	            {
	                
	                
	                    int temp=maxHeap.get(currIndex);
	                    maxHeap.set(currIndex,maxHeap.get(leftChild));
	                    maxHeap.set(leftChild,temp);
	                    currIndex=leftChild;

	            }
	            else if(maxHeap.get(rightChild)>maxHeap.get(leftChild) && maxHeap.get(currIndex)<maxHeap.get(rightChild))
	            {
	                 int temp=maxHeap.get(currIndex);
	                    maxHeap.set(currIndex,maxHeap.get(rightChild));
	                    maxHeap.set(rightChild,temp);
	                    currIndex=rightChild;

	            }
	            else 
	            {
	                break;
	            }



	         leftChild=2*currIndex+1;
	         rightChild=2*currIndex+2;
	        }
	        if(leftChild<maxHeap.size())
	        {
	        	if(maxHeap.get(currIndex)<maxHeap.get(leftChild))
	        	{
	        		 int temp=maxHeap.get(currIndex);
	                    maxHeap.set(currIndex,maxHeap.get(leftChild));
	                    maxHeap.set(leftChild,temp);
	                    currIndex=leftChild;
	        	}
	        }
	        return maxEle;

	    }
	     public static int removeElementFromMinHeap(ArrayList<Integer> minHeap)
	    {
	        int minEle=minHeap.get(0);
	        int lastIndex=minHeap.size()-1;
	        minHeap.set(0,minHeap.get(lastIndex));
	        minHeap.remove(lastIndex);
	        int currIndex=0;
	        int leftChild=2*currIndex+1;
	        int rightChild=2*currIndex+2;
	        while(rightChild<minHeap.size())
	        {
	            if(minHeap.get(leftChild)< minHeap.get(rightChild) && minHeap.get(currIndex)>minHeap.get(leftChild))
	            {
	                
	                
	                    int temp=minHeap.get(currIndex);
	                    minHeap.set(currIndex,minHeap.get(leftChild));
	                    minHeap.set(leftChild,temp);
	                    currIndex=leftChild;

	            }
	            else if(minHeap.get(rightChild)< minHeap.get(leftChild) && minHeap.get(currIndex)> minHeap.get(rightChild))
	            {
	                 int temp=minHeap.get(currIndex);
	                    minHeap.set(currIndex,minHeap.get(rightChild));
	                    minHeap.set(rightChild,temp);
	                    currIndex=rightChild;

	            }
	            else 
	            {
	                break;
	            }



	         leftChild=2*currIndex+1;
	         rightChild=2*currIndex+2;
	        }
	        if(leftChild<minHeap.size())
	        {
	        	if(minHeap.get(currIndex)>minHeap.get(leftChild))
	        	{
	        		 int temp=minHeap.get(currIndex);
	                    minHeap.set(currIndex,minHeap.get(leftChild));
	                    minHeap.set(leftChild,temp);
	                    currIndex=leftChild;
	        	}
	        }
	        return minEle;

	    }

}

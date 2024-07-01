package in.cdac.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class AveragePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(solve(new ArrayList<>(Arrays.asList(30,47,19,23,40))));
   // System.out.println(solve(new ArrayList<>(Arrays.asList(6,28,49,39,38,15,14,26,4))));
	}
	
	    public static Long solve(ArrayList<Integer> A) {
	        ArrayList<Integer> leftTallest=findLeftTallestForEachIndex(A);
	        ArrayList<Integer> leftShortest=findLeftShortestForEachIndex(A);
	        ArrayList<Integer> rightTallest=findRightTallestForEachIndex(A);
	        ArrayList<Integer> rightShortest=findRightShortestForEachIndex(A);
	        
	        for(int i=0;i<A.size();i++) {
	        	System.out.println("ele "+A.get(i) +" left Short "+leftShortest.get(i)+" left Tallest "+leftTallest.get(i)+" right Smallest"+rightShortest.get(i)+"  right Tallest "+rightTallest.get(i));
	        }
	        long totalCount=0;
	        //using contribution technique  ==> how many subArray the particular element wil contribute for tallest and shortest
	        for(int i=0;i<A.size();i++)
	        {
	            //first calculate for subArrayWhich Ends at that index-1;
	            long first=numberOfTimesCurrIndexWasTallestAndShortestTillThisPointOfSubarray(leftTallest.get(i),leftShortest.get(i),i);
	            long second=numberOfTimesCurrIndexWasTallestAndShortestFromThisPointOfSubarray(rightTallest.get(i),rightShortest.get(i),i,A.size());
	            System.out.println("for "+A.get(i) +" we have its contribution till this "+first +" fromhere "+second);
	            if(first==0)
	            	first=1;
	            if(second==0)
	            	second=1;
	            totalCount+=first*second;
	        }
	        return totalCount;
	    }
	    public static long numberOfTimesCurrIndexWasTallestAndShortestTillThisPointOfSubarray(int leftTallIdx,int leftShortIdx,int currIdx)
	    {
	         long toalNumberOfSubArray=currIdx;
	         if(toalNumberOfSubArray<=1)
	               return 0;
	         long lengthOfSubArrayforTall=currIdx-leftTallIdx;
	         long lengthOfSubArrayForShort=currIdx-leftShortIdx;
	         
	         
	        	 lengthOfSubArrayforTall-=2;
	        
	        	 lengthOfSubArrayForShort-=2;
	        	 if(lengthOfSubArrayforTall<0)
	        		 lengthOfSubArrayforTall=0;
	        	 if(lengthOfSubArrayForShort<0)
	        		 lengthOfSubArrayForShort=0;
	         return (toalNumberOfSubArray -(lengthOfSubArrayforTall+lengthOfSubArrayForShort));
	        
	    }
	    public static long numberOfTimesCurrIndexWasTallestAndShortestFromThisPointOfSubarray(int rightTallIdx,int rightShortIdx,int currIdx,int size)
	    {
	        long totalNumberOfSubArrayFromThisPoint=size-currIdx-2;
	        if(totalNumberOfSubArrayFromThisPoint<=0)
	            return 0;
	        long lengthOfSubArrayForTall=rightTallIdx-currIdx;
	        long lengthOfSubArrayForShort=rightShortIdx-currIdx;
	        
	        
	        	lengthOfSubArrayForTall-=2;
	       
	        	lengthOfSubArrayForShort-=2;
	        	if(lengthOfSubArrayForShort<0)
	        		lengthOfSubArrayForShort=0;
	        	if(lengthOfSubArrayForTall<0)
	        		lengthOfSubArrayForTall=0;
	             
	        return (totalNumberOfSubArrayFromThisPoint -(lengthOfSubArrayForTall+lengthOfSubArrayForShort));     
	        
	    }
	    
	    public static ArrayList<Integer> findLeftTallestForEachIndex(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> op=new ArrayList<Integer>();
	        Stack<Integer> stack=new Stack<>();
	        for(int i=0;i<A.size();i++)
	        {
	            while(!stack.isEmpty() && A.get(stack.peek())<A.get(i))
	            {
	                stack.pop();
	            }
	            if(stack.isEmpty())
	                {
	                    stack.push(i);
	                    op.add(-1);
	                }
	                else
	                {
	                    op.add(stack.peek());
	                    stack.push(i);
	                }
	        }
	        return op;
	        
	    }
	     public static ArrayList<Integer> findLeftShortestForEachIndex(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> op=new ArrayList<>();
	        Stack<Integer> stack=new Stack<>();
	        for(int i=0;i<A.size();i++)
	        {
	            while(!stack.isEmpty() && A.get(i) < A.get(stack.peek()))
	            {
	                stack.pop();
	            }
	            if(stack.isEmpty())
	            {
	                stack.push(i);
	                op.add(-1);
	            }
	            else
	            {
	                op.add(stack.peek());
	                stack.push(i);
	            }
	        }
	        return op;
	    }
	     public static ArrayList<Integer> findRightTallestForEachIndex(ArrayList<Integer> A)
	    {
	         ArrayList<Integer> op=new ArrayList<>();
	        Stack<Integer> stack=new Stack<>();
	        for(int i=A.size()-1;i>=0;i--)
	        {
	            while(!stack.isEmpty() && A.get(i) >A.get(stack.peek()))
	            {
	                stack.pop();
	            }
	            if(stack.isEmpty())
	            {
	                op.add(A.size());
	                stack.push(i);
	            }
	            else
	            {
	                op.add(stack.peek());
	                stack.push(i);
	            }
	        }
	        Collections.reverse(op);
	        return op;
	    }
	     public static ArrayList<Integer> findRightShortestForEachIndex(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> op=new ArrayList<>();
	        
	        Stack<Integer> stack=new Stack<>();
	        for(int i=A.size()-1;i>=0;i--)
	        {
	            while(!stack.isEmpty() && A.get(i) <A.get(stack.peek()))
	            {
	                stack.pop();
	            }
	            if(stack.isEmpty())
	            {
	                op.add(A.size());
	                stack.push(i);
	            }
	            else
	            {
	                op.add(stack.peek());
	                stack.push(i);
	            }
	        }
	        Collections.reverse(op);
	        return op;
	    }
	


}

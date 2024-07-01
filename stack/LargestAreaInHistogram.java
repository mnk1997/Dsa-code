package in.cdac.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestAreaInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(90,58,69,70,82,100,13,57,47,18));
		System.out.println(largestRectangleArea(list));

	}
	  public static int largestRectangleArea(ArrayList<Integer> A) {
	        ArrayList<Integer> nearestLeft=findNearestSmallestOnLeft(A);
	         ArrayList<Integer> nearestRight=findNearestSmallestOnRight(A);
	         System.out.println("nearest smallest on left ----------");
             for(int i=0;i<A.size();i++)
             {
            	 System.out.print(nearestLeft.get(i)+"  ");
             }
             System.out.println("nearest smallest on Right ----------");
             for(int i=0;i<A.size();i++)
             {
            	 System.out.print(nearestRight.get(i)+"   ");
             }
	         int maxArea=0;
	         for(int i=0;i<A.size();i++)
	         {
	             int rightIndex=nearestRight.get(i);
	             int leftIndex=nearestLeft.get(i);
	             if(rightIndex==-1)
	             {
	                 rightIndex=A.size();
	             }
	             maxArea=Integer.max(maxArea,A.get(i)*(rightIndex-leftIndex-1));
	         }

	        return maxArea;
	    }

	    //find the nearestSmallestOnLeft for each index
	    public static ArrayList<Integer> findNearestSmallestOnLeft(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> nearestLeft=new ArrayList<>();
	        Stack<Integer> currNearestSmallest=new Stack<>();
	        for(int i=0;i<A.size();i++)
	        {
	            while((!currNearestSmallest.isEmpty()) && A.get(currNearestSmallest.peek())>=A.get(i))
	            {
	                currNearestSmallest.pop();
	            }
	            if(currNearestSmallest.isEmpty())
	            {
	                currNearestSmallest.push(i);
	                nearestLeft.add(i,-1);
	            }
	            else
	            {
	                nearestLeft.add(i,currNearestSmallest.peek());
	                currNearestSmallest.push(i);
	                
	            }
	        }
	        return nearestLeft;


	    }
	    //finding nearest Smallest on Right
	     public static ArrayList<Integer> findNearestSmallestOnRight(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> nearestRight=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	            nearestRight.add(0);
	        }
	        Stack<Integer> currNearestSmallest=new Stack<>();
	        for(int i=A.size()-1;i>=0;i--)
	        {
	            while((!currNearestSmallest.isEmpty()) && A.get(currNearestSmallest.peek())>=A.get(i))
	            {
	                currNearestSmallest.pop();
	            }
	            if(currNearestSmallest.isEmpty())
	            {
	                currNearestSmallest.push(i);
	                nearestRight.set(i,-1);
	            }
	            else
	            {
	                nearestRight.set(i,currNearestSmallest.peek());
	                currNearestSmallest.push(i);
	                
	            }
	        }
	        return nearestRight;

	    }
	     
	   
	     

}

package in.cdac.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*Given an array of integers A.

The value of an array is computed as the difference between the maximum element
in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.*/
public class MAxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solve(new ArrayList<>(Arrays.asList(4, 7, 3, 8))));
		System.out.println(solveOne(new ArrayList<>(Arrays.asList(992387,932142,971117,934674,988917,967890,948508,970347))));
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println(solve(new ArrayList<>(Arrays.asList(992387,932142,971117,934674,988917,967890,948508,970347))));

	}
	 public static int solve(ArrayList<Integer> A) {
		 ArrayList<Integer>smallestLeft= findNearestSmallestOnLeft(A);
			ArrayList<Integer>largestLeft= findNearestLargestOnLeft(A);
			 ArrayList<Integer>smallRight= findNearestSmallestOnRight(A);
			ArrayList<Integer>largestRight= findNearestLargestOnRight(A);
			long sum=0;
			for(int i=0;i<A.size();i++)
			{
				System.out.println("For i: "+i+" smallestLeft->"+smallestLeft.get(i)+"smallestRight->"+smallRight.get(i)+" LargestLEft "+largestLeft.get(i)+" LArgest Right->"+largestRight.get(i));
				
				sum+=(long)A.get(i)*(long)(((i-largestLeft.get(i))*1l*(largestRight.get(i)-i))-((i-smallestLeft.get(i))*1l*(smallRight.get(i)-i)));
			  // System.out.println("ans "+sum);
			}
			
			return (int) (sum%1000000007);
		
	    }
	 public static  ArrayList<Integer> findNearestSmallestOnLeft(ArrayList<Integer> A)
	 {
		 ArrayList<Integer> nearestSmallestLeft=new ArrayList<>();
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<A.size();i++)
		 {
			 while((!st.isEmpty()) && A.get(st.peek())>A.get(i))
			 {
				 st.pop();
			 }
			 if(st.isEmpty())
			 {
				 st.push(i);
				 nearestSmallestLeft.add(i,-1);
			 }
			 else
			 {
				 nearestSmallestLeft.add(i,st.peek());
				 st.push(i);
			 }
		 }
		
		 return nearestSmallestLeft;
	 }
	 
	 public static ArrayList<Integer> findNearestLargestOnLeft(ArrayList<Integer> A)
	 {
		 ArrayList<Integer> nearestSmallestLeft=new ArrayList<>();
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<A.size();i++)
		 {
			 while((!st.isEmpty()) && A.get(st.peek())<A.get(i))
			 {
				 st.pop();
			 }
			 if(st.isEmpty())
			 {
				 st.push(i);
				 nearestSmallestLeft.add(i,-1);
			 }
			 else
			 {
				 nearestSmallestLeft.add(i,st.peek());
				 st.push(i);
			 }
		 }
		 return nearestSmallestLeft;
	 }
	 public static  ArrayList<Integer> findNearestSmallestOnRight(ArrayList<Integer> A)
	 {
		 ArrayList<Integer> nearestSmallestLeft=new ArrayList<>();
		 for(int i=0;i<A.size();i++)
		 {
			 nearestSmallestLeft.add(0);
		 }
		 Stack<Integer> st=new Stack<>();
		 for(int i=A.size()-1;i>=0;i--)
		 {
			 while((!st.isEmpty()) && A.get(st.peek())>A.get(i))
			 {
				 st.pop();
			 }
			 if(st.isEmpty())
			 {
				 st.push(i);
				 nearestSmallestLeft.set(i,A.size());
			 }
			 else
			 {
				 nearestSmallestLeft.set(i,st.peek());
				 st.push(i);
			 }
		 }
		 return nearestSmallestLeft;
	 }
	 
	 public static  ArrayList<Integer> findNearestLargestOnRight(ArrayList<Integer> A)
	 {
		 ArrayList<Integer> nearestSmallestLeft=new ArrayList<>();
		 Stack<Integer> st=new Stack<>();
		 for(int i=0;i<A.size();i++)
		 {
			 nearestSmallestLeft.add(0);
		 }
		 for(int i=A.size()-1;i>=0;i--)
		 {
			 while((!st.isEmpty()) && A.get(st.peek())<A.get(i))
			 {
				 st.pop();
			 }
			 if(st.isEmpty())
			 {
				 st.push(i);
				 nearestSmallestLeft.set(i,A.size());
			 }
			 else
			 {
				 nearestSmallestLeft.set(i,st.peek());
				 st.push(i);
			 }
		 }
		 return nearestSmallestLeft;
	 }
 ///////////////////////////////////////////////////WRONGGGGGGGGGGGGGGGGGGGGGG ONNNNNNNNNNNNNNNNNEEEEEEEEEEEEEEEEEEEEEEEEE/////////////////////////////
	 
	 public static int solveOne(ArrayList<Integer> A) {
	        ArrayList<Integer> nextLargestOnLeft=findNextLargestOnLeftForEachEle(A);
	        ArrayList<Integer>nextLargestOnRight=findNextLargestOnRightForEachEle(A);
	        ArrayList<Integer> nextSmallestOnLeft=findNextSmallestOnLeftForEachEle(A);
	        ArrayList<Integer>nextSmallestOnRight=findNextSmallestOnRightForEachEle(A);
	        long ans=0;
	        for(int i=0;i<A.size();i++)
	        {
	            int nextLargeOnLeft=nextLargestOnLeft.get(i);
	            int nextLargeOnRight=nextLargestOnRight.get(i);
	             int nextSmallOnLeft=nextSmallestOnLeft.get(i);
	            int nextSmallOnRight=nextSmallestOnRight.get(i);
	            if(nextLargeOnLeft==i)
	               
	               {
	                   nextLargeOnLeft=-1;
	               }
	            if(nextLargeOnRight==i)
	            {
	                nextLargeOnRight=A.size();
	            }
	             if(nextSmallOnLeft==i)
	               
	               {
	                   nextSmallOnLeft=-1;
	               }
	            if(nextSmallOnRight==i)
	            {
	                nextSmallOnRight=A.size();
	            }
	            System.out.println("For i: "+i+" smallestLeft->"+nextSmallOnLeft+"smallestRight->"+nextSmallOnRight+" LargestLEft "+nextLargeOnLeft+" LArgest Right->"+nextLargeOnRight);
	            ans+=(long)A.get(i)*(long)(((i-nextLargeOnLeft)*1l*(nextLargeOnRight-i))-((i-nextSmallOnLeft*1l*(nextSmallOnRight-i))));
				  // System.out.println("ans "+ans);
	            
	        }
	        
	        return (int) (ans%1000000007);
	    }
	 public static ArrayList<Integer> findNextLargestOnLeftForEachEle(ArrayList<Integer> A)
	    {
	       ArrayList<Integer> op=new ArrayList<Integer>(A.size());
	       Stack<Integer> st=new Stack<>();
	       for(int i=0;i<A.size();i++)
	       {
	           int currEle=A.get(i);
	           //inserting into deque
	           while(!st.isEmpty() && A.get(st.peek())<=currEle)
	           {
	               st.pop();
	           }
	           st.add(i);
	           op.add(i,st.peek());
	       }
	       
	       return op;
	       
	    }
	     public static ArrayList<Integer> findNextSmallestOnLeftForEachEle(ArrayList<Integer> A)
	    {
	       ArrayList<Integer> op=new ArrayList<Integer>(A.size());
	       Stack<Integer> st=new Stack<>();
	       for(int i=0;i<A.size();i++)
	       {
	           int currEle=A.get(i);
	           //inserting into deque
	           while(!st.isEmpty() && A.get(st.peek())>currEle)
	           {
	               st.pop();
	           }
	           st.push(i);
	           op.add(i,st.peek());
	       }
	       
	      
	       return op;
	       
	    }
	     public static ArrayList<Integer> findNextLargestOnRightForEachEle(ArrayList<Integer> A)
	    {
	       ArrayList<Integer> op=new ArrayList<Integer>(A.size());
	       for(int i=0;i<A.size();i++)
	       {
	           op.add(i,0);
	       }
	       Stack<Integer> st=new Stack<>();
	       for(int i=A.size()-1;i>=0;i--)
	       {
	           int currEle=A.get(i);
	           //inserting into deque
	           while(!st.isEmpty() && A.get(st.peek())<=currEle)
	           {
	               st.pop();
	           }
	           st.push(i);
	           op.add(i,st.peek());
	       }
	       
	       return op;
	       
	    }
	       public static ArrayList<Integer> findNextSmallestOnRightForEachEle(ArrayList<Integer> A)
	    {
	       ArrayList<Integer> op=new ArrayList<Integer>(A.size());
	       for(int i=0;i<A.size();i++)
	       {
	           op.add(i,0);
	       }
	       Stack<Integer> st=new Stack<>();
	       for(int i=A.size()-1;i>=0;i--)
	       {
	           int currEle=A.get(i);
	           //inserting into deque
	           while(!st.isEmpty() && A.get(st.peek())>=currEle)
	           {
	               st.pop();
	           }
	           st.push(i);
	           op.add(i,st.peek());
	       }
	       
	       return op;
	       
	    }
}

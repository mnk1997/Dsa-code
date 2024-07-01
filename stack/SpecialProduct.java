package in.cdac.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SpecialProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(maxSpecialProduct(new ArrayList<Integer>(Arrays.asList(6, 7, 9, 5, 5, 8))));
	}
	   public static int maxSpecialProduct(ArrayList<Integer> A) {
	        ArrayList<Integer> nearestGreaterOnLeft=new ArrayList<>();
	        ArrayList<Integer> nearestGreaterOnRight=new ArrayList<>();
	        nearestGreaterOnLeft=findNearestGreaterOnLeft(A);
	        nearestGreaterOnRight=findNearestGreaterOnRight(A);
	        for(int i=0;i<A.size();i++)
	        {
	        	System.out.println("A[i]: "+ A.get(i)+" left max : "+nearestGreaterOnLeft.get(i)+"  right max :  "+nearestGreaterOnRight.get(i) );
	        }
	        long max=-1;
	        for(int i=0;i<A.size();i++)
	        {
	            long currProd=(long) nearestGreaterOnLeft.get(i)*1l*nearestGreaterOnRight.get(i);
	            if(currProd > max)
	            {
	                max=currProd;
	            }
	        }
	        return (int) (max%1000000007);
	        
	    }
	    public static ArrayList<Integer> findNearestGreaterOnLeft(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> nearestMaxOnLeft=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	            nearestMaxOnLeft.add(0);
	        }
	        Stack<Integer> st=new Stack<>();
	        for(int i=0;i<A.size();i++)
	        {
	            if(i==0)
	            {
	                nearestMaxOnLeft.set(i,0);
	                st.push(A.get(0));
	            }
	            else
	            {
	                while(!st.isEmpty() && st.peek()<A.get(i))
	                {
	                    st.pop();
	                }
	                if(st.isEmpty())
	                {
	                    st.push(A.get(i));
	                    nearestMaxOnLeft.set(i,0);
	                }
	                else{
	                    nearestMaxOnLeft.set(i,st.peek());
	                    st.push(A.get(i));
	                }
	                
	            }
	        }
	        
	        return nearestMaxOnLeft;
	    }
	      public static ArrayList<Integer> findNearestGreaterOnRight(ArrayList<Integer> A)
	    {
	        ArrayList<Integer> nearestMaxOnRight=new ArrayList<>();
	        for(int i=0;i<A.size();i++)
	        {
	            nearestMaxOnRight.add(0);
	           
	        }
	        Stack<Integer> st=new Stack<>();
	        for(int i=A.size()-1;i>=0;i--)
	        {
	            if(i==A.size()-1)
	            {
	                nearestMaxOnRight.set(i,0);
	                 st.push(A.get(i));
	            }
	            else
	            {
	                while(!st.isEmpty() && st.peek()<A.get(i))
	                {
	                    st.pop();
	                }
	                if(st.isEmpty())
	                {
	                    st.push(A.get(i));
	                    nearestMaxOnRight.set(i,0);
	                }
	                else{
	                    nearestMaxOnRight.set(i,st.peek());
	                    st.push(A.get(i));
	                }
	                
	            }
	        }
	        
	        return nearestMaxOnRight;
	    }

}

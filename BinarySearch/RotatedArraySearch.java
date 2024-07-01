package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100));
		int B=202;
		
		System.out.println(search(list,B));

	}
	 public static int search(final List<Integer> A, int B) {

	        //defining search space
	        int leftPtr=0;
	        int rightPtr=A.size()-1;
	        int firstEle=A.get(0);
	        //check for extra cond. that no rotation has been done in Array
	        if(A.get(0)<A.get(A.size()-1))
	        {
	        	int left=0;
		        int right=A.size()-1;
		        while(left<=right)
		        {
		        	int mid=left + (right -left)/2;
		        	if(A.get(mid)==B)
		        	{
		        		return mid;
		        	}
		        	else if(A.get(mid)>B)
		        	{
		        		right=mid-1;
		        	}
		        	else
		        	{
		        		left=mid+1;
		        	}
                                       


		        	
		        }
	        }
	        while(leftPtr<=rightPtr)
	        {
	        	
	            int mid=leftPtr +(rightPtr-leftPtr)/2;
	            System.out.println("mid"+mid);
	            //check if middle element is answer or NOT
	            if(A.get(mid)==B)
	                return mid;
	            if(firstEle>B)
	            {
	                //this condin means that element is in 2nd half..
	                //now we have to check mid is in first part or second part

	                if(A.get(mid)< firstEle)
	                {
	                    //mid is also in 2nd part 

	                    if(A.get(mid)>B)
	                    {
	                        rightPtr=mid-1;
	                    }
	                    else
	                    {
	                        leftPtr=mid+1;
	                    }
	                }
	                else{
	                    leftPtr=mid+1;
	                }
	            }
	            else if(firstEle<B)
	            {
	                //B is in 1st part now we have to check where is the mid
	                if(A.get(mid)>firstEle)
	                {
	                    //this means mid is also in firt part 

	                    if(A.get(mid)>B)
	                    {
	                        rightPtr=mid-1;
	                    }
	                    else{
	                        leftPtr=mid+1;
	                    }
	                }
	                else
	                {
	                	//mid is in second part
	                	rightPtr=mid-1;
	                }
	            }
	            else{
	                return 0;
	            }
	        }

	        return -1;
	    }

}

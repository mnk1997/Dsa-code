package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3,5));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
		System.out.println(findMedianSortedArrays(A, B));
		//System.out.println(findNumberOfSmallerElements(B, 5));

	}

	public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
		double result = 0.0;
        int desiredCount=-1;
        int desiredCountOne=-1;
		int totalLen=A.size()+B.size();
		if(totalLen%2==0)
		{
			desiredCount=((A.size() +B.size()) / 2)-1;
			desiredCountOne=(A.size() +B.size()) / 2;
		}
		else
		{
			desiredCount = (A.size() +B.size()) / 2;
		}
			
		
		
		System.out.println("desired count" + desiredCount +" and "+desiredCountOne);
		int l = 0;
		int r = A.size() - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			//System.out.println("---------------------------------------------mid current " + mid);
			int count = findNumberOfSmallerElements(B, A.get(mid));
			
			count = count + mid;
			System.out.println("from another array "+count+"   vlaue"+A.get(mid));
			if (totalLen%2==1 && count == desiredCount ) {
				// System.out.println("********************************"+A.get(mid));
				result += A.get(mid);

			}
			else if( totalLen%2==0 &&(count==desiredCount || count==desiredCountOne))
			{
				//System.out.println("********************************"+A.get(mid));
				result+=A.get(mid);
			}
			else
			{
				
			}
			if (count < desiredCount) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Till now answe ris "+result);
		// ------------------NOW CHECK WHETHER SECOND ARRAY CONTAINS THE ANSWER OR NOT
		l = 0;
		r = B.size() - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			//System.out.println("---------------------------------------------mid current " + mid);
			int count = findNumberOfSmallerElements(A, B.get(mid));
			count = count + mid;
			System.out.println("from another array "+count+"   vlaue"+B.get(mid));
			if (totalLen%2==1 && count == desiredCount ) {
				// System.out.println("********************************"+B.get(mid));
				result += B.get(mid);

			}
			else if( totalLen%2==0 &&(count==desiredCount || count==desiredCountOne))
			{
				//System.out.println("********************************"+B.get(mid));
				result+=B.get(mid);
			}
			else
			{
				
			}
			if (count < desiredCount) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
        if(A.size()%2==0)
		       result /= 2;
		return result;

	}

	public static int findNumberOfSmallerElements(List<Integer> A, int ele) {
		Queue<Integer> q=new PriorityQueue<>();
		
		
		
		int count = 0;
		int l = 0;
		int r = A.size() - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			//System.out.println("mid "+A.get(mid));
			if ((mid == 0) || mid==A.size()-1 || (A.get(mid) >= ele && A.get(mid - 1) <= ele)) {
				if (mid == 0) {
					if (A.get(mid) == ele)
						return 0;
					else if (A.get(mid) < ele)
						return 1;

				}
				else if(mid==A.size()-1)
				{
					if(A.get(mid)<ele)
						count=A.size();
					else 
						count=A.size()-1;
					return count;
				}
				
				//System.out.println("mid  returning" + mid);
				count= count +mid;
				//System.out.println("count is " + count);
				return count;
			}
			if (A.get(mid) > ele) {
				r = mid - 1;
			} else {
				//System.out.println("updating l for lee"+ele);
				l = mid + 1;
			}
		}

		//System.out.println("l" + l);
		System.out.println("r" + r);

		return count;
	}

}

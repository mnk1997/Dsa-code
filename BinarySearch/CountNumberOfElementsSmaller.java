package in.cdac.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CountNumberOfElementsSmaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1,2,3,4,5,5,6,7));
		//ArrayLisT<Integer> B=new ArrayList<>()
		// System.out.println("Answer "+findNumberOfSmallerElements(A, 4));
		System.out.println("asnwer is "+findMedianOfArray(A));
		

	}
	public static double findMedianOfArray(ArrayList<Integer> A)
	{
		double result=0.0;
		
		int desiredCount=A.size()/2;
		System.out.println("desired count"+desiredCount);
		int l=0;
		int r=A.size()-1;
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			System.out.println("---------------------------------------------mid current "+mid);
			int count=findNumberOfSmallerElements(A,mid);
			if(count==desiredCount)
			{
				System.out.println("founded median "+A.get(count) +"mid "+count );
				double ans=0.0;
				if(A.size()%2==0)
				{
					System.out.println("since even "+A.get(count-1) +"  will aslo be median");
				     ans=A.get(count)+A.get(count-1);
				    // ans/=2;
				     ans/=2;
				     
				}
				else
				{
					 ans=A.get(count)/2;
				}
				return ans;
					
			}
			if(count<desiredCount)
			{
				l=mid+1;
			}
			else
			{
				r=mid-1;
			}
		}
		
		
		return result;
	}
	public static int findNumberOfSmallerElements(ArrayList<Integer> A,int ele)
	{
		int count=0;
		int l=0;
		int r=A.size()-1;
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			if((mid==0) || (A.get(mid)>ele && A.get(mid-1)<ele) || (A.get(mid)==ele && A.get(mid-1)<ele) )
			{
				if(mid==0)
				{
					if(A.get(mid)==ele)
						return 0;
					else if(A.get(mid)<ele)
						return 1;
						
				}
				System.out.println("mid  returning"+mid);
				count=mid;
				System.out.println("count is "+count);
				return count;
			}
			if(A.get(mid)>=ele)
			{
				r=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		
		
		
		  System.out.println("l"+l); System.out.println("r"+r);
		 		
		return count;
	}

}

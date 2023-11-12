package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.*/
public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> listThree=new ArrayList<>(Arrays.asList(73,58,30,72,44,78,23,9));
		int B=5;
		//ArrayList<Integer> list=new ArrayList<>(Arrays.asList(12,34,67,90));
		ArrayList<Integer> listOne=new ArrayList<>(Arrays.asList(97,26,12,67,10,33,79,49,79,21,67,72,93,36,85,45,28,91,94,57,1,53,8,44,68,90,24));
		//int B=2;
		//int B=26;
		//findNumberOfStudentIfGivenPageIsMinimum(B, listThree);
		System.out.println(books(listThree,B));
		

	}
	   public static int books(ArrayList<Integer> A, int B) {
		  // int count=0;
		   if(A.size()<B)
		   {
			   return -1;
		   }
		   int left=minimumNumberOfPagesWhichCanBeAllocatedToStudent(A);
		   int right=maximumNumberOfPagesWhichCanBeAllocatedToStudent(A);
		   while(left<=right)
		   {
			   int mid=left +(right-left)/2;
			   int numberOfStudent=findNumberOfStudentIfGivenPageIsMinimum(mid,A);
			  // System.out.println("mid :"+mid +" numberOfStudent"+numberOfStudent);
			   if(numberOfStudent==B && findNumberOfStudentIfGivenPageIsMinimum(mid-1, A)>numberOfStudent)
			   {
				   return mid;
			   }
			   
			   if(numberOfStudent>B)
			   {
				   left=mid+1;
			   }
			   else
			   {
				   right=mid-1;
			   }
		   }
		   
          System.out.println("returning from last");
        	   return left;
           
	    }
	   private static int findNumberOfStudentIfGivenPageIsMinimum(int mid, ArrayList<Integer> a) {
		// TODO Auto-generated method stub
		   int count=1;
		   int currCapacity=mid;
		   
		   for(int page:a)
		   {
			   if(currCapacity>=page)
			   {
				   currCapacity=currCapacity-page;
			   }
			   else
			   {
				   count++;
				   currCapacity=mid-page;
			   }
		   }
		   System.out.println("mid : "+mid+"  count : "+count);
		return count;
	}
	//this will be the case when number of student is only 1 and he/she has to read all the books
	private static int maximumNumberOfPagesWhichCanBeAllocatedToStudent(ArrayList<Integer> a) {
		int sum=0;
		for(int pages:a)
		{
			sum+=pages;
		}
		// TODO Auto-generated method stub
		return sum;
	}
	
	//this will be the case when n number ie number of students is equal to A.size() then all the student will have only 1books
	private static int minimumNumberOfPagesWhichCanBeAllocatedToStudent(ArrayList<Integer> a) {
		// TODO Auto-generated method stub
	//	Collections.sort(a);
		//int n=a.size();
		int min=-1;
		for(int ele:a)
		{
			if(ele>min)
			{
				min=ele;
			}
		}
		//as each will get only 1 book so the last student will get this book 
		return min;
		
	}
}

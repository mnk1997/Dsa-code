package in.cdac.pract;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;

/*Farmer John has built a new long barn with N stalls. 
 * Given an array of integers A of size N where each element of 
 * the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive
 towards each other once put into a stall. To prevent the cows from hurting each other,
  John wants to assign the cows to the stalls, such that the minimum distance
between any two of them is as large as possible. What is the largest minimum distance?*/
public class CowAgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> listTwo=new ArrayList<>(Arrays.asList(71,83,65,68,21,73,94,4,68,80,24,2,46,91,59,31,11,63,65,45,18,1,92,84,41,10,35,18,48,60,90,6,8,97,32,72,72,52,11,36,92,31,75,54,71,75,75));
		//ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> listOne=new ArrayList<>(Arrays.asList(82,61,38,88,12,7,6,12,48,8,31,90,35,5,88,2,66,19,5,96,84,95));
		int B=8;
		//System.out.println(numberOfCowsInGivenDistance(listTwo,4));
       System.out.println(solve(listTwo,21));
	}
	//considering stall ie A is sorted
	 public static int solve(ArrayList<Integer> A, int B) {
		 Collections.sort(A);
		
		 int currDistance=-1;
		 int ans=0;
		 int minDistance=1;//considering many cows
		 int maxDistance=A.get(A.size()-1) - A.get(0);//considering only 2 cows first placed at 1 stall and second at last stall
		 while(minDistance<=maxDistance)
		 {
			  currDistance=minDistance + (maxDistance -minDistance)/2;
			 int cowsPossible=numberOfCowsInGivenDistance(A, currDistance);
			 System.out.println("cows possible  "+cowsPossible +"   for distance   "+currDistance);
			 if(cowsPossible==B && numberOfCowsInGivenDistance(A,currDistance+1) < cowsPossible)
			 {
				 return currDistance;
			 }
			 
			 if(cowsPossible>=B)
			 {
				 minDistance=currDistance+1;
			 }
			 else
			 {
				 maxDistance=currDistance-1;
			 }
			 System.out.println("MAx "+maxDistance+"    Min"+minDistance);
		 }
		 
		 
		 System.out.println("returning ");
		 return currDistance;
	 }
	 
	 public static int numberOfCowsInGivenDistance(ArrayList<Integer>A,int minDist)
	 {
		 Collections.sort(A);
		 int nextDistance=0;
		 int numberOfCowsPossible=0;
		 for(int stall:A)
		 {
			 if(nextDistance<=stall)
			 {
				 nextDistance=stall+minDist;
				 numberOfCowsPossible++;
			 }
			
		 }
		 return numberOfCowsPossible;
	 }
	 

}

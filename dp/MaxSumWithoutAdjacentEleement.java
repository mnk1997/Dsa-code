package in.cdac.dp;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a 2 x N grid of integers, A, your task is to 
choose numbers from the grid such that sum of these numbers is maximized. 
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally. 

Return the maximum possible sum.

Note: You are allowed to choose more than 2 numbers from the grid.*/


/*A = [   
     [1, 2, 3, 4]
     [2, 3, 4, 5]    
  ]
		  8*/


public class MaxSumWithoutAdjacentEleement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		/*
		 * list.add(new ArrayList<>(Arrays.asList(74,37,82,1))); list.add(new
		 * ArrayList<>(Arrays.asList(66,38,16,1)));
		 */
		
		list.add(new ArrayList<>(Arrays.asList(16,5,54,55,36,82,61,77,66,61)));
		list.add(new ArrayList<>(Arrays.asList(31,30,36,70,9,37,1,11,68,14)));
      System.out.println(adjacent(list));
	}
	 public static  int adjacent(ArrayList<ArrayList<Integer>> A) {
		 
		 if(A.size()==0)
			 return 0;
		 
		// int ans=0;
		 int[] dp=new int[A.get(0).size()];
		 dp[0]=Math.max(A.get(0).get(0),A.get(1).get(0));
		 if(dp[0]<0)
			 dp[0]=0;
		
		 
		 if(A.get(0).size()==1)
			  return dp[0];
			 
		 dp[1]=Math.max(dp[0], Math.max(A.get(0).get(1),A.get(1).get(1)));
			 if(dp[1]<0)
				 dp[1]=0;
			 
			for(int i=2;i<A.get(0).size();i++)
			{
				dp[i]=Math.max(dp[i-1],Math.max(A.get(0).get(i), A.get(1).get(i))+dp[i-2]);
			}
			 
			for(int i=0;i<dp.length;i++)
				
			{
				System.out.print(dp[i]+" ");
			}
			 
			 
			 
			 return dp[A.get(0).size()-1];
		 }
		
		 
		 
	    
	 public static int findAns(ArrayList<ArrayList<Integer>> A,int currRow,int currCol,ArrayList<ArrayList<Integer>> res)
	 {
		 if(res.get(currRow).get(currCol)>0)
		 {
			 return res.get(currRow).get(currCol);
		 }
		 for(int r=currRow+1;r<A.size();r++)
		 {
			 for(int c=0;c<currCol-1;c++)
			 {
				 
				 
			 }
		 }
		return currCol;
		
		 
		 
	 }
	

}

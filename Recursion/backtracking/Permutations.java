package in.cdac.pract.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

		 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]*/
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int[] nums= {1,2,3};
	  permute(nums);

	}
	
	 public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result=new ArrayList<>();
	        Stack<Integer> setOfNumbers=new Stack<>();
	        for(int i:nums)
	        {
	        	setOfNumbers.add(i);
	        }
	      for(int i=0;i<nums.length;i++)
	      {
	    	  ArrayList<Integer> currSet=new ArrayList<>();
	    	  currSet.add(nums[i]);
	    	  setOfNumbers.remove(nums[i]);
	    	  generateAllThePermutations(result,setOfNumbers,0,new ArrayList<>());
	    	  setOfNumbers.add(nums[i]);
	    	  currSet.remove(currSet.size()-1);
	      }
	      
		 
		 
		 return result;
	    }
	 public static void generateAllThePermutations(List<List<Integer>> result,Stack<Integer> setOfNumbers,int start,List<Integer> currSet)
	 {
		 if(setOfNumbers.isEmpty())
		 {
			 System.out.println("Solution found");
			 ArrayList<Integer> res=new ArrayList<>(currSet);
			 for(int i:res)
			 {
				 System.out.print(i+" ");
			 }
			 result.add(res);
			 return;
		 }
		
		    setOfNumbers.remove(currSet.get(currSet.size()-1));
			for(int i:setOfNumbers)
			{
				currSet.add(i);
				
				 generateAllThePermutations(result, setOfNumbers, start+1, currSet);
				 currSet.remove(currSet.size()-1);
				 //setOfNumbers.add(i);
				
			}
			
			return;
			 
			
			 
			 
		 
	 }

}

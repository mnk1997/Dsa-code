package in.cdac.pract;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=-3;
		System.out.println(a%2+2);
               
	}
	   public boolean canFinish(int numCourses, int[][] prerequisites) {
	        boolean result=false;
	        if(numCourses==0)
	        {
	            return result;
	        }
	        Stack<Integer> coursesToBeDone=new Stack<>();
	        int lastCourseSelected=coursesToBeDone.push(prerequisites[0][0]);;
	        for(int i=0;i<prerequisites.length;i++)
	        {
	               if(coursesToBeDone.contains(lastCourseSelected))
	            	   
	               {
	            	   result=false;
	            	   return result;
	               }
	               else
	               {
	            	   coursesToBeDone.push(lastCourseSelected);
	            	   lastCourseSelected=prerequisites[i][1];
	            	   
	               }
	               
	        }
	        
	        result=coursesToBeDone.size() <=numCourses ?true:false;
	        return result;   
	    }
}

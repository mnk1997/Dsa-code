package in.cdac.pract.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towerOfHanoi(3, 1, 3,2);

	}
	public static void towerOfHanoi(int n,int source ,int destination,int auxilary)
	{
		     if(n==0)
		    	  return ;
		    
		     
		     if(n==1)
		     {
		    	 System.out.println(n+" disk moving from "+source +"  to  "+destination);
		    	 return;
		     }
				/*
				 * if(n==2) { //System.out.println(n-1+" disk moving from "+source
				 * +"  to  "+auxilary); towerOfHanoi(n-1, source, auxilary,destination);
				 * System.out.println(n+" disk moving from "+source +"  to  "+destination);
				 * //System.out.println(n-1+" disk moving from "+auxilary
				 * +"  to  "+destination); towerOfHanoi(n-1,auxilary,destination,source);
				 * return;
				 * 
				 * }
				 */
		     StringBuilder res=new StringBuilder();
		     String resOne=new String(res);
		     res.append('n');
		     
		     towerOfHanoi(n-1, source,auxilary,destination);
		     System.out.println(n+" disk moving from "+source +"  to  "+destination);
		     towerOfHanoi(n-1,auxilary,destination,source);
	}

}

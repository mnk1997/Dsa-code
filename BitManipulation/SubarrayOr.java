package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayOr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(solve(list));

	}
	  public static int solve(ArrayList<Integer> A) {
		  long ans=0;
		  int n=A.size();
		 // int[] count=new int[32];
		 
			 for(int i=0;i<=n;i++)
			 {
				 for(int j=i+1;j<n;j++)
				 {
					 ans+=A.get(i)|A.get(j);
				 }
				
			 }
		 
		 
	
		  
		  
		  
		  return (int) ans%1000000007;
	    }

}

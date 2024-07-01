package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;

public class PairSumDivisibleM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(5,17,100,11));
      System.out.println(solve(A,28));
	}
	public static int solve(ArrayList<Integer> A, int B) {
        int ans=0;
        int[] frequency=new int[B];
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)%B<0)
            {
                   A.set(i,(A.get(i)%B+B)%B);
            }
            else
            {
                 A.set(i,A.get(i)%B);
            }
               
                
                //frequency[A.get(i)]+=1;
                  
        }
        
        for(int i=0;i<A.size();i++)
        {
            if(frequency[(B-A.get(i))%B]>=1)
            {
            	System.out.println("updating answer at "+i);
            	
                ans=((ans%1000000007)+(frequency[(B-A.get(i))%B])%1000000007)%1000000007;
                System.out.println("answer "+ans);
            }
                frequency[A.get(i)%B]=(frequency[A.get(i)%B]%1000000007+1)%1000000007;
            
        }
        System.out.println("printing freq arary");
        
        for(int i=0;i<frequency.length;i++)
        {
        	System.out.print(" "+frequency[i]);
        }
        //now counting numebr of 0 present 
        
        System.out.println("Anser before 0 finding"+ans);
        int n=0;
        for(int ele:A)
        {
        	if(ele==0)
        	{
        		n+=1;
        	}
        	
        }
        System.out.println("valu of n"+n);
         //ans+=(n*(n-1))/2;
        return ans;
        

    }
}

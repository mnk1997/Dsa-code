package in.cdac.pract;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class AMagicalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(solve(19,11,13));
		//System.out.println(solve(20,4,4));
		System.out.println(solve(807414236,3788,38141));
		//System.out.println(solve(14,10,12));
		HashMap<String,Integer> values=new HashMap<>();
		for(Map.Entry<String, Integer> val :values.entrySet())
		{
			val.get
		}
		
	}
	public static int solve(int a, int b, int c) {
		System.out.println("AAAA"+a);
	       //gcd will help in to find lcm
	        long gcd=findGcd(b>c?b:c,c>b?b:c);
	        long lcm=((b*c)/gcd);
	        System.out.println(gcd);
	        System.out.println("lcm"+lcm);
	        long left=b>c?c:b;
	        long right=Math.max((b*a),(c*a));
	        while(left<=right)
	        {
	        	long mid=left +((right-left)/2);
	        	long count;
	        	
	        		 count=(mid/b)+(mid/c)-(mid/lcm);
	        	
	            
	        	System.out.println("LEft :"+left+"  Right:"+right +"    mid:"+mid +"   count:"+ count);
	        	//System.out.println("kkk");
	             if(mid==left || mid==right )
	             {
	            	 if(left%b==0 || left%c==0)
	            	 {
	            		 return (int)left%1000000007;
	            	 }
	            	 else if(right%b==0 || right%c==0)
	            	 {
	            		 return (int)right%1000000007;
	            	 }
	             }
	            if((mid%b==0 || mid%c==0) && count>=a)
	            {
	                return (int)mid%1000000007;
	            }
	            if(count>=a)
	            {
	                 right=mid-1;
	            } 
	            else
	            {
	                 left=mid+1;
	            }
	        }
	        return -1;
	    }
	    public static long findGcd(int b,int c)
	    {
	         if(c==0)
	         {
	             return b;
	         }
	         return findGcd(c,b%c);
	    }

}

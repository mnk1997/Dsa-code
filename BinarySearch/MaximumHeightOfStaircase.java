package in.cdac.binarySearch;

public class MaximumHeightOfStaircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(7267325));

	}
	 public static int solve(int A) {
	        int l=1;
	        int r=A;
	        while(l<=r)
	        {
	            int mid=l+(r-l)/2;
	           long sum=calculateSum(mid);
	           System.out.println("mid "+mid +"  sum"+sum);
	            if(sum<=A && calculateSum(mid+1)>A)
	               return mid;
	            if(sum<A && sum>0)
	               l=mid+1;
	            else 
	              r=mid-1;
	        }
	        return 0;
	    }

	    public static long calculateSum(int A)
	    {
	    	long sum=1;
	    	if(A%2==0)
	    	{
	    	       sum=A/2;
	    	       sum=sum*(A+1);
	    	}
	    	else
	    	{
	    		sum=(A+1)/2;
	    		sum=sum*A;
	    	}
	       
	        return sum;
	    }
}

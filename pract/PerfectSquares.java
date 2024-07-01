package in.cdac.pract;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(numSquares(12));
	}
	  public static int numSquares(int n) {
	        int square=1;

	        for(int i=1;i*i<=n;i++)
	        {
	                 square++;
	        }
	         int ans =0;
	         while(n>0)
	         {
	        	 System.out.println("Curr n " +n +" ans "+ans +" square "+square);
	            if(square*square>n)
	             {
	            	//System.out.println("current square was "+square*square);
	                square-=1;
	             }
	             else
	             {
	                n-=square*square;
	                ans+=1;
	             }
	         }

	         return ans;
	        
	    }

}

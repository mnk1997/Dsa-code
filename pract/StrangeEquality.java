package in.cdac.pract;

public class StrangeEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve(2));

	}
	 public static int solve(int A) {
	        int X=0;
	        int Y=0;
	        if(A==0)
	        {
	            return 0;
	        }
	        if(A==1)
	        {
	            X=0;
	            Y=2;
	            return X^Y;
	        }
	        
	        //first find value of X
	        int temp=A;
	        int bit=0;
	        while(temp>0)
	        {
	              if((temp & 1)==0)
	              {
	                  X=X|1<<bit;
	              }
	              temp=temp>>1;
	              bit++;
	        }
	        System.out.println("x value "+X);
	        //finding value of Y
	        
	        for(bit=31;bit>0;bit--)
	        {
	                    if((A & (1<<(bit-1)))>=1)
	                    {
	                        Y=Y|1<<bit;
	                        break;
	                    }
	        }
           System.out.println("Y value"+Y);
	        return X^Y;
	    }

}

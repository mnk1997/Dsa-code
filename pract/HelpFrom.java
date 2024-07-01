package in.cdac.pract;

public class HelpFrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(7));

	}
	  public static int solve(int A) {
		  System.out.println(1>>1 & 1);
		  int total=0;
		  while(A>0)
		  {
			  System.out.println("inside A"+A+" val"+ (A & 1));
			  total+= A&1;
			  A=A>>1;
			  
			  
		  }
		  
		  

	           return total;
	    }
	}


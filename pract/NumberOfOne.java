package in.cdac.pract;

public class NumberOfOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countDigitOne(101));

	}
	  public static int countDigitOne(int n) {
		  System.out.println("called countDigitOne");
		  int count=0;
		  int factor=1;int temp=1;
		  int remainder=0;
		  while(factor<=n)
		  {
			 
			  temp=factor;
			  factor=factor*10;
			  System.out.println("factor "+factor+"  te"+temp+" count"+count);
			  if(n%factor==0)
			  {
				  remainder=0;
			  }
			  else if(n%factor>=2*temp)
			  {
				  remainder=temp;
			  }
			  else
			  {
				  System.out.println("else ");
				  remainder=(n%factor)-temp+1;
				  remainder=Math.max(remainder,0);
				  System.out.println("Remainder"+remainder);
			  }
			  
			  //factor=factor*10;
			  count+=(n/factor)*temp+remainder;
			  
			  
		  }
		  if(factor<n)
		  {
			  System.out.println("outside loop");
			  System.out.println("factor "+factor+"  te"+temp);
			  if(n%factor==0)
			  {
				  remainder=0;
			  }
			  else if(n%factor>=2*temp)
			  {
				  remainder=temp;
			  }
			  else
			  {
				  remainder=n%factor-temp+1;
			  }
			  count+=(n/factor)*temp+remainder;
		  }
		  
		  
		  
		  
		  return count;
	        
	    }

}

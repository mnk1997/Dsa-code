package in.cdac.pract;

public class Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  int[] arr1= {1033,4179,1931,8117,7364,7737,6219,3439,1537,7993}; 
		  int[] arr2=
		  {6386};
		 
		/*
		 * int[] arr1= {1,2,3}; int[] arr2= {6,5};
		 */
		System.out.println((getXORSum(arr1, arr2)));

	}
	 public static int getXORSum(int[] arr1, int[] arr2) {
		 int[] count=new int[32];
		 for(int i=0;i<arr2.length;i++)
		 {
			 for(int bit=0;bit<=31;bit++)
			 {
				 if((arr2[i] & 1<<bit) >=1)
				 {
					      count[bit]+=1; 
				 }
			 }
		 }
		 
		 int[] countOfSetBits=new int[32];
		for(int i=0;i<arr1.length;i++)
		{
			
		
			 for(int bit=0;bit<=31;bit++)
			 {
				  if((arr1[i] & 1<<bit) >=1)
				  {
					  if(countOfSetBits[bit]==0)
					  {
						  countOfSetBits[bit]=count[bit];
					  }
					  else
					  {
						  countOfSetBits[bit]+=count[bit];
					  }
					  
				  }
			 }
		}
		
		int ans=0;
		for(int i=0;i<=31;i++)
		{
			if(countOfSetBits[i]%2==1)
			{
				ans=ans | 1<<i;
			}
		}
		
		//System.out.println("answer "+ans);
		return ans;
	        
	    }

}

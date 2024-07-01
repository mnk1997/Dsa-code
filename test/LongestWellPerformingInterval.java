package in.cdac.test;

public class LongestWellPerformingInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hours = { 6, 9, 6 };
		//System.out.println(longestWPI(hours));
		
		System.out.println(longestWPIOne(new int[]{9,9,6,0,6,6,9}));
		

	}

	// prefix and suffix
//	     0,1,0
//	     0,1,0
	public static int longestWPI(int[] hours) {
		int firstIndexHavingGreaterThanNine = -1;
		for (int i = 0; i < hours.length; i++) {
			if (hours[i] > 8) {
				firstIndexHavingGreaterThanNine = i;
				break;
			}
		}

		if (firstIndexHavingGreaterThanNine == -1)
			return 0;
		if (firstIndexHavingGreaterThanNine == hours.length - 1)
			return 1;

		System.out.println("first index " + firstIndexHavingGreaterThanNine);
		int ans = 0;
		int temp = 0;
		for (int i = firstIndexHavingGreaterThanNine; i < hours.length; i++) {
			if (hours[i] > 8) {

				temp += 1;

			} else {
				temp -= 1;
			}
			System.out.println("temp " + temp);
			if (temp > 0)
				ans = Math.max(ans, i + 1);
		}

		return ans;

	}

	public static int longestWPIOne(int[] hours) {
		int numberOfTiringDays = 0;
		int firstIndexOfTiringDay=-1;
		for (int i = 0; i < hours.length; i++) {
			if (hours[i] > 8) {
				if(firstIndexOfTiringDay==-1)
				{
					firstIndexOfTiringDay=i;
					
				}
				numberOfTiringDays += 1;	
					

			}
		}
  
		if (numberOfTiringDays == 0)
			return 0;
		else if (numberOfTiringDays == 1)
			return 1;
		else if (numberOfTiringDays > (hours.length) / 2)
			return hours.length;

		int[] prefix = new int[hours.length];
		int[] suffix = new int[hours.length];
		for (int i = firstIndexOfTiringDay; i < hours.length; i++) {
             if(hours[i]>8)
             {
            	 if(i==0)
            		 prefix[i]=1;
            	 else 
            	  prefix[i]=prefix[i-1]+1;
             }
             else
             {
            	 if(i==0)
            		 prefix[i]=0;
            	 else 
            	    prefix[i]=prefix[i-1]-1;
             }
			 
		}
		
		for (int i = hours.length-1; i >=0; i--) {
			if(i==hours.length-1)
			{
				if(hours[i]>8)
					suffix[i]=1;
				else
					suffix[i]=0;
			}
			else
			{
				  if(hours[i]>8)
		            {
		           	 suffix[i]=suffix[i+1]+1;
		            }
		            else
		            {
		           	 suffix[i]=suffix[i+1]-1;
		            }
			}
          
			 
		}
		int maxLength=0;
		int temp=0;
		System.out.println("prefix ");
		for(int i=0;i<prefix.length;i++)
		{
			System.out.print(prefix[i]+" ");
		}
		for(int i=0;i<prefix.length;i++)
		{
			if(prefix[i]>0)
			{
				temp+=1;
			}
			else
			{
				temp=0;
				
			}
			maxLength=Math.max(maxLength,temp);
		}
		
		int len=0;
		for(int i=suffix.length-1;i>=1;i--)
		{
			if(suffix[i-1]>suffix[i])
			{
				len+=1;
			}
			else
			{
				len=0;
			}
			maxLength=Math.max(maxLength,len+1);
		}
		return maxLength;

	}
	
	
public static int longestWPIThree(int[] hours) {
	int ans=0;
	
	for(int i=0;i<hours.length;i++)
	{
		
			int tempCount=0;
			for(int j=i;j<hours.length;j++) {
				if(hours[j]>8)
					tempCount++;
				else
					tempCount-=1;
				if(tempCount>0)
					ans=Math.max(ans,j-i+1);//interval size
				
			
		}
	}
	//from right to left
	for(int i=hours.length-1;i>=0;i--)
	{
		if(hours[i]>8)
		{
			int tempCount=0;
			for(int j=i;j>=0;j--) {
				if(hours[j]>8)
					tempCount++;
				else
					tempCount-=1;
				if(tempCount>0)
					ans=Math.max(ans,i-j+1);//interval size
				
			}
		}
	}
	
	
	
	return ans;                     //0,1, 2,3,4, 5, 6,7 ,8,9
	//the above soln got accepted :8,12,7,6,10,10,9,11,12,6:this was edge case
//can we optimize the above code as TC is O(N2)
        
    }

}

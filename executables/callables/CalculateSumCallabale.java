package in.cdac.executables.callables;

import java.util.concurrent.Callable;

public class CalculateSumCallabale implements Callable<Integer>{
      private int start;
      private int end;
      int sum;
      public CalculateSumCallabale(int s,int e)
      
      {
    	  this.start=s;
    	  this.end=e;
    	  sum=0;
      }
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		//int sumTillEnd=(end*(end+1))/2;
		//int sumTillFirst=(start*(start-1))/2;
		System.out.println();
		//int sum=0;
		for(int i=start;i<=end;i++)
		{
			sum+=i;
		}
		return  sum;
		//return  sumTillEnd-sumTillFirst;
	}

}

package in.cdac.leetcodedaily;

import java.util.ArrayList;

public class MinimuCostToHireKWorkers {
	static class Ratio
	{
		double ratio;
		int index;
		Ratio(double ratio,int index)
		{
			this.ratio=ratio;
			this.index=index;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] quality = {3,1,10,10,1};
		int[] wage = {4,8,2,2,7};int k = 3;
		System.out.println(mincostToHireWorkers(quality, wage, k));

	}
	   public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		   double ans=0;
		   //put all the ratio wage/quality into minHeap of size k;
		   ArrayList<Ratio> minHeap=buildMinHeapOfSizeK(quality,wage,k);
		  //construct minHeap 
		   
		   Ratio comparedRatio=getMin(minHeap);
		   int index=comparedRatio.index;
		   ans+=wage[index];
		   System.out.println("ans "+ans);
		   int currCount=0;
		   while(currCount++<k-1)
		   {
			   Ratio curr=getMin(minHeap);
			   int currIndx=curr.index;
			   //System.out.println("curr double "+curr.ratio +" curr price "+(quality[currIndx]/quality[index])*wage[index]);
			  
			   ans+=Math.max(wage[currIndx],( (double)quality[currIndx]/quality[index])*wage[index]);
			   
		   }
			   
		   return ans;
		   
	        
	        
	    }
	private static Ratio getMin(ArrayList<Ratio> minHeap) {
	      Ratio minEle=minHeap.get(0);
	      Ratio lastEle=minHeap.get(minHeap.size()-1);
	      minHeap.set(0, lastEle);
	      minHeap.remove(minHeap.size()-1);
	      int currIdx=0;
	      int lc=2*currIdx+1;
	      int rc=2*currIdx+2;
	      while(lc<minHeap.size())
	      {
	    	  Ratio currVal=minHeap.get(currIdx);
	    	  Ratio leftVal=minHeap.get(lc);
	    	  Ratio rightVal=rc<minHeap.size()?minHeap.get(rc):null;
	    	  if(currVal.ratio>leftVal.ratio && (rightVal==null||leftVal.ratio<rightVal.ratio))
	    			  {
	    		                   currIdx=lc;
	    			  }
	    	  else if(rightVal!=null && currVal.ratio>rightVal.ratio &&rightVal.ratio<leftVal.ratio)
	    	  {
	    		  currIdx=rc;
	    	  }
	    	  else
	    	  {
	    		  break;
	    	  }
	    	  lc=2*currIdx+1;
	    	  rc=2*currIdx+2;
	      }
		return minEle;
	}
	private static ArrayList<Ratio> buildMinHeapOfSizeK(int[] quality, int[] wage, int k) {
		ArrayList<Ratio> tempHeap=new ArrayList<>();
	          
		for(int i=0;i<quality.length;i++)
	         {
	        	      tempHeap.add(new Ratio(wage[i]/quality[i],i));
	         }
		    int parentIndex=(tempHeap.size()-1)/2;
		    Ratio dummy=new Ratio(-1,Integer.MIN_VALUE);
		    for(int i=parentIndex;i>=0;i--)
		    {
		    	int  currIdx=i;
		    	int lc=2*i+1;
		    	int rc=2*i+2;
		    	while(lc<tempHeap.size())
		    	{
		    		double currVal=tempHeap.get(currIdx).ratio;
		    		double leftVal=tempHeap.get(lc).ratio;
		    		double rightVal=rc<tempHeap.size()?tempHeap.get(rc).ratio:dummy.ratio;
		    		if(currVal<leftVal && leftVal<=rightVal)
		    		{
		    			tempHeap.add(lc, tempHeap.get(currIdx));
		    			tempHeap.add(currIdx,tempHeap.get(lc));
		    			currIdx=lc;
		    		}
		    		else if (rightVal<currVal && rightVal<leftVal)
		    		{
		    			tempHeap.add(currIdx,tempHeap.get(rc));
		    			tempHeap.add(rc,tempHeap.get(currIdx));
		    			currIdx=rc;
		    		}
		    		else
		    		{
		    			break;
		    		}
		    		 lc=2*currIdx+1;
				     rc=2*currIdx+2;
		    	}
		    }
		    
		    return tempHeap;
		
	}

}

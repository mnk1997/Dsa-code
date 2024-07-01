package in.cdac.pract;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceTheArraySizeToHalf {
//3,3,3,3,5,5,5,5,2,2,2,1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String lang="Java Programming Langugae"; Stream str=Stream.of(lang);
		 */
		
		int[] arr= {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(arr));
          
	}
	
	 public static int minSetSize(int[] arr) {
		 
		 HashMap<Integer,Integer> freq=new HashMap<>();
		 for(int i=0;i<arr.length;i++)
		 {
			  if(freq.containsKey(arr[i]))
			  {
				  int val=freq.get(arr[i]);
				  val+=1;
				  freq.put(arr[i],val);
			  }
			  else
			  {
				  freq.put(arr[i],1);
			  }
		 }
		 //store the freq  in maxHeap
		 PriorityQueue<Integer> maxHeap=new PriorityQueue<>((x,y)->y-x);
		  for(Map.Entry<Integer,Integer> entry:freq.entrySet())
		  {
			     maxHeap.offer(entry.getValue());
		  }
		 int requiredSize=(arr.length/2);
		 int setSize=0;
		 int currSize=0;
		 while(!maxHeap.isEmpty())
		 {
			 currSize+=maxHeap.poll();
			 setSize++;
			 if(currSize>=requiredSize)
			 {
				 break;
				 
			 }
			 
		 }
		 
		 return setSize;
		 
	        
	    }

}

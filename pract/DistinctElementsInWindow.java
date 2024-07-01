package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctElementsInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(80,18,80,80,80,80,80,80,94,18));
		A=dNums(A,8);
		for(int ele:A)
		{
			System.out.println(ele);
		}
		

	}
	 public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
         ArrayList<Integer> output=new ArrayList<>();
        if(A.size()<B)
        {
            return output;
        }
       
        HashMap<Integer,Integer> freq=new HashMap<>();
        int start=0;
        int end=start+B-1;
        for(int i=start;i<=end;i++)
        {
            if(freq.containsKey(A.get(i)))
            {
                freq.put(A.get(i),freq.get(A.get(i))+1);
            }
            else
            {
                freq.put(A.get(i),1);
            }
        }
        while(end<A.size())
        {
               output.add(freq.size());
               if(freq.containsKey(A.get(start)))
               {
                   int count=freq.get(A.get(start));
                   if(count==1)
                   {
                       freq.remove(A.get(start));
                   }
                   else{
                       freq.put(A.get(start),freq.get(A.get(start))-1);
                   }
               }
               if(end+1<A.size())
               {
                    if(freq.containsKey(A.get(end+1)))
               {
                   int count=freq.get(A.get(end+1));
                  
                   
                       freq.put(A.get(end+1),count+1);
                   
               }
               else{
                   freq.put(A.get(end+1),1);
               }

               }
               start=start+1;
               end=end+1;
        }
        return output;
    }

}

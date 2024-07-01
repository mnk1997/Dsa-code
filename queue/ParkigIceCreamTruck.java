package in.cdac.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/*648,614,490,138,657,544,745,582,738,229,775,665,876,448,4,81,807,578,712,951,867,
 * 328,308,440,542,178,637,446,882,760,354,523,935,277,158,698,536,165,892,327,574,516,36,705,900,482,558,937,207,368

9



o/p:745 745 775 775 876 876 876 876 876 876 876 951 951 951 951 951 951 
951 951 951 882 882 882 882 935 935 935 935 935 935 935 935 935 892 892 
892 900 900 900 937 937 937*/
public class ParkigIceCreamTruck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> A=new ArrayList<>(Arrays.asList(
648,614,490,138,657,544,745,582,738,229,775,665,876,448,4,81,807,578,712,951,867,328,308,440,542,178,637,446,882,760,354,523,935,277,158,698,536,165,892,327,574,516,36,705,900,482,558,937,207,368));
  for(int ele:slidingMaximum(A, 9))
  {
	  System.out.println(ele);
  }
	}
	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if(B>A.size())
            B=A.size();
       ArrayList<Integer> res=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
       
       //Deque<Integer> dq=new ConcurrentLinkedDeque<>();
       Deque<Integer> dq=new LinkedList<>();
       
        for(int i=0;i<B;i++)
        {
            if(dq.isEmpty())
                dq.add(i);
            else 
            {
                while(!dq.isEmpty() && A.get(dq.peekLast())<A.get(i))
                {
                    dq.pollLast();
                }
                dq.add(i);
                
            }
        }
        int start=1;
        int end=B;
         res.add(A.get(dq.peek()));
        while(end<A.size())
        {
            int val=A.get(end);
            while(!dq.isEmpty() && A.get(dq.peekLast())<val)
            {
                dq.pollLast();
            }
            dq.add(end);
            if(dq.peek()>start)
              dq.poll();
            res.add(A.get(dq.peek()));
            start++;
            end++;
        }

        return res;
   }

}

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        //System.out.println("Size of A"+A.size());
        Queue<Integer> q=new LinkedList<>();
        int maxGlass=0;
        int currCapacity=B;
        for(int i=0;i<A.size();i++)
        {
            
            if(A.get(i)>B)
            {
                maxGlass=Math.max(maxGlass,q.size());
                
                while(!q.isEmpty())
                {
                   int ele= q.poll();
                    currCapacity=currCapacity+ele;
                }
                continue;
            }
            else
            {
                if(currCapacity>=A.get(i))
                {
                    q.add(A.get(i));
                    currCapacity=currCapacity-A.get(i);
                }
                else
                {
                    while(currCapacity<A.get(i))
                    {
                        int ele=q.poll();
                        currCapacity=currCapacity+ele;
                    }
                     q.add(A.get(i));
                     currCapacity=currCapacity-A.get(i);
                    // continue;
                }
            }
            
            if(maxGlass<q.size())
            {
                //System.out.println("Q size is increased for  i "+i +"   and quee size is "+q.size() + "curr capacity "+currCapacity + " currEle "+A.get(i));
                maxGlass=q.size();
            }
        }
        return maxGlass;
    }
}


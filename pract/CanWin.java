package in.cdac.pract;

import java.util.Deque;
import java.util.LinkedList;

public class CanWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canIWin(20,168));

	}
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger)
                   return true;
                   //I have to implement maxHeap as well as minHeap so 
                   //implemented dq so that get max from front and min from rear
        Deque<Integer> priorityQ=new LinkedList<>();
        intializeMaxHeap(priorityQ,maxChoosableInteger);
        int turn=0;
        while(!priorityQ.isEmpty())
        {
        	int getMaxNumber=priorityQ.peekFirst();
        	int getMinNumber=priorityQ.peekLast();
        	System.out.println("max Number "+getMaxNumber);
        	System.out.println("min Number "+getMinNumber);
        	System.out.println("turn "+turn);
        	System.out.println("desired "+desiredTotal);
        	System.out.println("------------------------------------------");
        	if(turn==0)
        	{
        		if(getMaxNumber>=desiredTotal)
                    return true;
        		else
        			desiredTotal-=getMinNumber;
        		
        		priorityQ.pollLast();
        	}
        	else
        	{
        		if(getMaxNumber>=desiredTotal)
                    return false;
				
				  else desiredTotal-=getMaxNumber;
				  
				  priorityQ.pollFirst();
				 
				/*
				 * else desiredTotal-=getMinNumber;
				 * 
				 * priorityQ.pollLast();
				 */
        	}
                turn=(turn+1)%2;
        }
        return false;
        
    }
	private static void intializeMaxHeap(Deque<Integer> priorityQ, int maxChoosableInteger) {
		// TODO Auto-generated method stub
		for(int i=1;i<=maxChoosableInteger;i++)
		{
			priorityQ.addFirst(i);
		}
		
	}

}

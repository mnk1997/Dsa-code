package in.cdac.test;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQusingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
       Queue<Integer> res=new LinkedList<>();
		reverseQUsingRec(q, res);
		while(!res.isEmpty())
		{
			System.out.print(res.poll()+" ");
		}
	}
	
	public static Queue<Integer> reverseQUsingRec(Queue<Integer> q,Queue<Integer> res)
	{
		if(q.isEmpty())
			return null;
		
		int currData=q.poll();
		reverseQUsingRec(q, res);
		//System.out.println("curr data"+currData);
		res.offer(currData);
		//System.out.println("res size "+res.size());
		
		return res;
		
	}

}

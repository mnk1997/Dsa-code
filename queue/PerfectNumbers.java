package in.cdac.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.*/
public class PerfectNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(getNumber(1));
		String A="/a/b/c/../";
		String[] commands=A.split("/");
		
		for(String cmd:commands)
		{
			System.out.println("cmd "+cmd);
		}
				

	}

	public static int getNumber(int A) {
		// int A=-1;
		int idx=A-1;
		Queue<StringBuffer> q = new LinkedList<StringBuffer>();
		ArrayList<String> list = new ArrayList<String>();
		q.add(new StringBuffer("1"));
		q.add(new StringBuffer("2"));
		while (A  >= 0) {
			StringBuffer str = q.poll();
			
			StringBuffer value1 = new StringBuffer(str);
			StringBuffer value2 = new StringBuffer(str);
			String res=str.toString();
		
			 res = res.concat(String.valueOf(str.reverse()));
			list.add(res);
			//System.out.println(res);

			value1.append("1");
			//System.out.println("value 1-->" +value1);
			value2.append('2');
			//System.out.println("value2 -->"+value2);
			q.add(value1);
			q.add(value2);
			

			A--;

		}
	//	return list.get(idx );
		return Integer.valueOf(list.get(idx ));
	}

	public static int getNumberOne(int A) {
		// int A=-1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(11);
		q.add(22);
		while (A - 2 >= 0) {
			int x = q.poll();
			// System.out.println("x"+x);
			int val1 = x * 100 + x;
			/*
			 * int val2; int rem=x%10;
			 * System.out.println("x-1"+(x-1)+"   q.peek()"+q.peek()); if(rem==1)
			 * val2=(x-1)*100+q.peek()*10+1; else val2=(x-2)*100+q.peek()*10+2;
			 */
			q.add(val1);
			// q.add(val2);

			A--;
		}

		return q.peek();
	}

}
